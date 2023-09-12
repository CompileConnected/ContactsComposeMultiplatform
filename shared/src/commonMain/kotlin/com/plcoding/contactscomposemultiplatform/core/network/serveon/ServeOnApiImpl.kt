package com.plcoding.contactscomposemultiplatform.core.network.serveon

import com.plcoding.contactscomposemultiplatform.core.data.Employee
import com.plcoding.contactscomposemultiplatform.core.data.ServeOn
import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkActivity
import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkFrom
import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkGroup
import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkLocation
import com.plcoding.contactscomposemultiplatform.core.network.config.headerConfig
import com.plcoding.contactscomposemultiplatform.core.network.extensions.JsonMe
import com.plcoding.contactscomposemultiplatform.core.network.extensions.appendMap
import com.plcoding.contactscomposemultiplatform.core.network.general.GeneralResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime


internal class ServeOnApiImpl(private val client: HttpClient) : ServeOnApi {
    override suspend fun getTodayServeOn(employee: Employee): List<ServeOn> {
        val response = client.post("https://iserveu.ag-it.com/api/serve/findserveonforweb") {
            headers {
                appendMap(headerConfig)
                appendMap(
                    mapOf(
                        "TOKEN-ID" to employee.token!!,
                        "SERIES-ID" to employee.series!!,
                        "USERNAME" to employee.username!!
                    )
                )
            }
            setBody(TodayServeOnRequest(employee.employeeTemplate!!.npk!!))
        }.bodyAsText()
        val result = JsonMe.decodeFromString<ServeOnResponse>(response)

        if (result.status == false) {
            throw Exception(result.description)
        }
        return result.result ?: listOf()
    }

    override suspend fun serveOn(
        employee: Employee,
        workLocation: WorkLocation,
        workGroup: WorkGroup,
        workActivity: WorkActivity,
        workFrom: WorkFrom
    ) {
        val date = Clock.System.now()
        val response = client.post("https://iserveu.ag-it.com/api/serve/sync/for-web") {
            headers {
                appendMap(headerConfig)
                appendMap(
                    mapOf(
                        "TOKEN-ID" to employee.token!!,
                        "SERIES-ID" to employee.series!!,
                        "USERNAME" to employee.username!!
                    )
                )
            }
            setBody(
                ServeOnRequest(
                    servedId = serverIdFormat(employee),
                    name = employee.username,
                    npk = employee.employeeTemplate!!.npk,
                    userId = employee.employeeTemplate.employeeId,
                    serveOnTime = date.toString(),
                    serveOffTime = date.toString(),
                    serveGroupId = workGroup.id,
                    serveGroupName = workGroup.name,
                    activityId = workActivity.id,
                    activityName = workActivity.name,
                    directHead = employee.employeeTemplate.directHead,
                    directHeadName = employee.employeeTemplate.directHeadName,
                    shiftId = workLocation.workScheduleId,
                    shiftname = workLocation.workScheduleName,
                    startTime = workLocation.startTime,
                    endTime = workLocation.endTime,
                    startBreakTime = workLocation.breakStartTime,
                    endBreakTime = workLocation.breakEndTime,
                    keterangan = workFrom.name.lowercase()
                )
            )
        }.bodyAsText()
        val result = JsonMe.decodeFromString<GeneralResponse>(response)
        if (result.status == false) {
            throw Exception(result.description)
        }
    }

    private fun serverIdFormat(employee: Employee): String {
        val localDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        val monthNumber = localDateTime.monthNumber
        val dayOfMonth = localDateTime.dayOfMonth
        val hour = localDateTime.hour
        val minute = localDateTime.minute
        val second = localDateTime.second
        return buildString {

            append(employee.employeeTemplate!!.npk)
            append(localDateTime.year)
            append(
                when {
                    monthNumber < 10 -> "0${monthNumber}"
                    else -> monthNumber
                }
            )
            append(
                when {
                    dayOfMonth < 10 -> "0${dayOfMonth}"
                    else -> dayOfMonth
                }
            )
            append(
                when {
                    hour < 10 -> "0${hour}"
                    else -> hour
                }
            )
            append(
                when {
                    minute < 10 -> "0${minute}"
                    else -> minute
                }
            )
            append(
                when {
                    second < 10 -> "0${second}"
                    else -> second
                }
            )
        }
    }


//    await fetch("https://iserveu.ag-it.com/api/serve/sync/for-web", {
//        "credentials": "include",
//        "headers": {
//            "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/112.0",
//            "Accept": "application/json, text/plain, */*",
//            "Accept-Language": "en-US,en;q=0.5",
//            "TOKEN-ID": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ5b2hhbmVzIiwiZXhwIjoxNjgzNjA5MTU4fQ.DBpjJ7K07kh1Ox3MqQPV5QUuKlZTkGQanfUZ_3qW9nE",
//            "SERIES-ID": "<secured>",
//            "USERNAME": "yohanes",
//            "Content-Type": "application/json;charset=utf-8",
//            "Sec-Fetch-Dest": "empty",
//            "Sec-Fetch-Mode": "cors",
//            "Sec-Fetch-Site": "same-origin"
//        },
//        "referrer": "https://iserveu.ag-it.com/",
//        "body": "[{\"servedId\":\"983220230509114728\",\"name\":\"YOHANES\",\"npk\":\"9832\",\"userId\":\"USR0003821\",\"serveOnTime\":\"2023-05-09T04:47:28.444Z\",\"serveOffTime\":\"2023-05-09T04:47:28.444Z\",\"serveOnTimeLong\":\"\",\"serveOffTimeLong\":\"\",\"serveOnTimeString\":\"\",\"serveOffTimeString\":\"\",\"serveGroupId\":\"INT\",\"serveGroupName\":\"Internal\",\"assignmentId\":\"\",\"assignmentName\":\"\",\"assignmentNumber\":\"\",\"activityId\":\"INT002\",\"activityName\":\"Training\",\"resultId\":\"\",\"resultName\":\"\",\"directHead\":\"9072\",\"directHeadName\":\"RIZAL RICKY RUMANDA\",\"description\":\"\",\"achievement\":\"\",\"typeId\":\"\",\"categoryId\":\"\",\"categoryName\":\"\",\"next_activity_description\":\"\",\"nextActivityDate\":\"\",\"shiftId\":\"TWS0000004\",\"shiftname\":\"Regular\",\"startTime\":\"08:00\",\"endTime\":\"17:00\",\"startBreakTime\":\"12:00\",\"endBreakTime\":\"13:00\",\"keterangan\":\"wfh\"}]",

//        "method": "POST",
//        "mode": "cors"
//    });


//    await fetch("https://iserveu.ag-it.com/api/serve/sync/for-web", {
//        "credentials": "include",
//        "headers": {
//            "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/117.0",
//            "Accept": "application/json, text/plain, */*",
//            "Accept-Language": "en-US,en;q=0.5",
//            "TOKEN-ID": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ5b2hhbmVzIiwiZXhwIjoxNjk0NDMwMDkwfQ.qaEF4XAoFCNqZJkITCeTFgyJJt92uVGxdMF401_t9Qc",
//            "SERIES-ID": "<secured>",
//            "USERNAME": "yohanes",
//            "Content-Type": "application/json;charset=utf-8",
//            "Sec-Fetch-Dest": "empty",
//            "Sec-Fetch-Mode": "cors",
//            "Sec-Fetch-Site": "same-origin"
//        },
//        "referrer": "https://iserveu.ag-it.com/",
//        "body": "[{\"servedId\":\"983220230911102917\",\"name\":\"YOHANES\",\"npk\":\"9832\",\"userId\":\"USR0003821\",\"serveOnTime\":1694403000000,\"serveOffTime\":\"2023-09-11T10:31:42.617Z\",\"serveOnTimeLong\":\"\",\"serveOffTimeLong\":\"\",\"serveOnTimeString\":\"\",\"serveOffTimeString\":\"\",\"serveGroupId\":\"PRJI\",\"serveGroupName\":\"Project Implementation\",\"assignmentId\":\"P23-0542-5LAAAG\",\"assignmentName\":\"P23-0542-5LAAAG ASTRA INTERNATIONAL TBK - MVP 2 STAR 2023 \",\"activityId\":\"PRJI004\",\"activityName\":\"Develop\",\"resultId\":\"R002\",\"resultName\":\"Complete\",\"directHead\":\"9770\",\"directHeadName\":\"JUENIETTA TYAS DAMAYANTI\",\"descriptionTimesheet\":\"\",\"achievement\":\"kerja\",\"nextActivityDate\":\"\",\"description\":\"kerj\"}]",
//        "method": "POST",
//        "mode": "cors"
//    });


    fun serveOff(employee: Employee) {

    }

}



