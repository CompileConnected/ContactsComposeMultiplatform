package com.plcoding.contactscomposemultiplatform.core.network.assignment

import com.plcoding.contactscomposemultiplatform.core.data.Employee
import com.plcoding.contactscomposemultiplatform.core.network.config.headerConfig
import com.plcoding.contactscomposemultiplatform.core.network.extensions.JsonMe
import com.plcoding.contactscomposemultiplatform.core.network.extensions.appendMap
import io.ktor.client.HttpClient
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText


internal class AssignmentApiImpl(private val client: HttpClient) : AssignmentApi {
    override suspend fun getAssignment(employee: Employee): AssignmentResult {
        val response =
            client.post("https://iserveu.ag-it.com/api/assignment/search/view/assignment") {
                headers {
                    appendMap(headerConfig)
                    appendMap( mapOf(
                        "USERNAME" to employee.userProfile!!.id!!,
                        "TOKEN-ID" to "000",
                        "SERIES-ID" to "000",
                    ))
                }
                setBody(GetAssignmentRequest(employeeId = employee.employeeTemplate!!.npk!!))
            }.bodyAsText()
        val result = JsonMe.decodeFromString<AssignmentResult>(response)
        return result
    }
}