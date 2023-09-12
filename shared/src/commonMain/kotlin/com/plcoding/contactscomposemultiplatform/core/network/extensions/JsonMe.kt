package com.plcoding.contactscomposemultiplatform.core.network.extensions

import io.ktor.http.HeadersBuilder
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject


val JsonMe = Json {
    encodeDefaults = true
    allowStructuredMapKeys = true
    prettyPrint = true
    explicitNulls = true
    ignoreUnknownKeys = true
}


inline fun <reified T> toMap(obj: T): Map<String, Any?> {
    return jsonObjectToMap(JsonMe.encodeToJsonElement(obj).jsonObject)
}

fun jsonObjectToMap(element: JsonObject): Map<String, Any?> {
    return element.entries.associate {
        it.key to extractValue(it.value)
    }
}

private fun extractValue(element: JsonElement): Any? {
    return when (element) {
        is JsonNull -> null
        is JsonPrimitive -> element.content
        is JsonArray -> element.map { extractValue(it) }
        is JsonObject -> jsonObjectToMap(element)
    }
}


fun HeadersBuilder.appendMap(map: Map<String, String>) {
    map.forEach {
        append(it.key, it.value)
    }
}