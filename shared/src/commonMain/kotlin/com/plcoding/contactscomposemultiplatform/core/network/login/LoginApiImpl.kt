package com.plcoding.contactscomposemultiplatform.core.network.login

import com.plcoding.contactscomposemultiplatform.core.data.Employee
import com.plcoding.contactscomposemultiplatform.core.network.config.headerConfig
import com.plcoding.contactscomposemultiplatform.core.network.extensions.appendMap
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody

internal class LoginApiImpl(private val client: HttpClient) : LoginApi {
    override suspend fun login(username: String, password: String): Employee {
        return client.post("https://iserveu.ag-it.com/api/security/login") {
            headers {
                appendMap(headerConfig)
                appendMap(mapOf(
                    "TOKEN-ID" to "000",
                    "SERIES-ID" to "000",
                    "OWNER-COMPANY-ID" to "000",
                ))
            }
            setBody(
                LoginRequest(
                    username = username,
                    password = password
                )
            )
        }.body()
    }
}