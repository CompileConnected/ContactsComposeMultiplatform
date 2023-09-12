package com.plcoding.contactscomposemultiplatform.core.data

import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkResult
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//fetch("https://iserveu.ag-it.com/api/assignment/get/project/manager", {
//    "headers": {
//        "accept": "application/json, text/plain, */*",
//        "accept-language": "en-US,en;q=0.9,id;q=0.8",
//        "content-type": "application/json;charset=UTF-8",
//        "sec-ch-ua": "\"Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116\"",
//        "sec-ch-ua-mobile": "?0",
//        "sec-ch-ua-platform": "\"macOS\"",
//        "sec-fetch-dest": "empty",
//        "sec-fetch-mode": "cors",
//        "sec-fetch-site": "same-origin",
//        "sec-gpc": "1",
//        "series-id": "000",
//        "token-id": "000",
//        "username": "USR0003821",
//        "cookie": "TS01840aab=0124912bcd8f5c8993dbbe8ec828165c3375cd05b64943ac6b92f8b5ae17e1107c8542959ebd5468bb13db3839f679cba3794dc8c6; username=yohanes; userid=USR0003821; name=YOHANES; npk=9832; isAuthenticated=2; session_jwt=1694358219; session_iserve=Sun%20Sep%2010%202023%2021%3A49%3A12%20GMT%2B0700%20(Western%20Indonesia%20Time)",
//        "Referer": "https://iserveu.ag-it.com/",
//        "Referrer-Policy": "strict-origin-when-cross-origin"
//    },
//    "body": "{\"projectNo\":\"P23-0542\"}",
//    "method": "POST"
//});


@Serializable
data class DirectSupervisorResponse(
    @SerialName("result"      ) var result      : List<DirectSupervisor>? = listOf(),
    @SerialName("status"      ) var status      : Boolean?                = null,
    @SerialName("description" ) var description : String?                 = null,
    @SerialName("totalData"   ) var totalData   : Int?                    = null
)



@Serializable
data class DirectSupervisor (
    @SerialName("assignmentId"     ) val assignmentId     : String?          = null,
    @SerialName("projectNo"        ) val projectNo        : String?           = null,
    @SerialName("wbsNo"            ) val wbsNo            : String?           = null,
    @SerialName("pmNPK"            ) val pmNPK            : String?           = null,
    @SerialName("pmName"           ) val pmName           : Long?              = null,
)