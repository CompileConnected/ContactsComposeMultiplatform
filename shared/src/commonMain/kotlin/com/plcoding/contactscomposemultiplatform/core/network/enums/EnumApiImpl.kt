package com.plcoding.contactscomposemultiplatform.core.network.enums


import com.plcoding.contactscomposemultiplatform.core.data.Employee
import com.plcoding.contactscomposemultiplatform.core.data.enums.ReasonOnLate
import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkActivity
import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkGroup
import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkLocation
import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkResult
import com.plcoding.contactscomposemultiplatform.core.network.config.emptyTokenAndSeriesConfig
import com.plcoding.contactscomposemultiplatform.core.network.config.headerConfig
import com.plcoding.contactscomposemultiplatform.core.network.config.hendrarEnumConfig
import com.plcoding.contactscomposemultiplatform.core.network.extensions.JsonMe
import com.plcoding.contactscomposemultiplatform.core.network.extensions.appendMap
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText


internal class EnumApiImpl(private val client: HttpClient) : EnumApi {
    override suspend fun workLocation(employee: Employee): List<WorkLocation> {
        val response =
            client.post("https://iserveu.ag-it.com/api/master/data/work/schedule/per/user") {
                headers {
                    appendMap(headerConfig)
                    appendMap(
                        mapOf(
                            "USERNAME" to employee.username!!,
                            "TOKEN-ID" to employee.token!!,
                            "SERIES-ID" to employee.series!!,
                        )
                    )
                }
                setBody(WorkLocationRequest(employee.employeeTemplate!!.npk!!))
            }.bodyAsText()
        val result = JsonMe.decodeFromString<WorkLocationResponse>(response)
        return result.result ?: listOf()
    }


    override suspend fun workActivity(): List<WorkActivity> {
        val response =
            client.get("https://iserveu.ag-it.com/api/configuration/bpi/getall/activitycategory/config") {
                headers {
                    appendMap(headerConfig)
                    appendMap(hendrarEnumConfig)
                }
            }.bodyAsText()
        val result = JsonMe.decodeFromString<WorkActivityResponse>(response)
        return result.result ?: listOf()
    }

    override suspend fun workGroup(): List<WorkGroup> {
        val response =
            client.get("https://iserveu.ag-it.com/api/configuration/bpi/getall/servegroup/config") {
                headers {
                    appendMap(headerConfig)
                    appendMap(hendrarEnumConfig)
                }
            }.bodyAsText()
        val result = JsonMe.decodeFromString<WorkGroupResponse>(response)
        return result.result ?: listOf()
    }


    override suspend fun workResult(): List<WorkResult> {
        val response =
            client.get("https://iserveu.ag-it.com/api/configuration/bpi/getall/result/category") {
                headers {
                    appendMap(headerConfig)
                    appendMap(hendrarEnumConfig)
                }
            }.bodyAsText()
        val result = JsonMe.decodeFromString<WorkResultResponse>(response)
        return result.result ?: listOf()
    }

    override suspend fun reasonOnLate(employee: Employee): List<ReasonOnLate> {
        val response =
            client.post("https://iserveu.ag-it.com/api/configuration/mobile/globaltype/search") {
                headers {
                    appendMap(headerConfig)
                    appendMap(emptyTokenAndSeriesConfig)
                    append("USERNAME", employee.userProfile!!.id!!)
                }
                setBody(ReasonOnLateRequest())
            }.bodyAsText()
        val result = JsonMe.decodeFromString<ReasonOnLateResponse>(response)
        return result.result ?: listOf()
    }

}