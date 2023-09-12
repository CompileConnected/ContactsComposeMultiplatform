package com.plcoding.contactscomposemultiplatform.core.network.menu


import com.plcoding.contactscomposemultiplatform.core.data.Employee
import com.plcoding.contactscomposemultiplatform.core.data.Menu
import com.plcoding.contactscomposemultiplatform.core.network.config.headerConfig
import com.plcoding.contactscomposemultiplatform.core.network.extensions.JsonMe
import com.plcoding.contactscomposemultiplatform.core.network.extensions.appendMap
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.statement.bodyAsText

internal class MenuApiImpl(private val client: HttpClient) : MenuApi {

    override suspend fun menu(employee: Employee): List<Menu> {
        val response = client.get("https://iserveu.ag-it.com/api/security/get/menu/") {
            headers {
                appendMap(headerConfig)
                append("USERNAME", employee.username!!)
            }
        }.bodyAsText()

        val result = JsonMe.decodeFromString<List<Menu>>(response)
        return result
    }
}