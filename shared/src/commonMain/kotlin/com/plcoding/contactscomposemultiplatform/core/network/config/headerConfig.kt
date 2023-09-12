package com.plcoding.contactscomposemultiplatform.core.network.config

import io.ktor.http.HttpHeaders

val headerConfig = mapOf(
    HttpHeaders.Accept to "application/json, text/plain, */*",
    HttpHeaders.AcceptLanguage to "en-US,en;q=0.5",
    HttpHeaders.ContentType to "application/json;charset=utf-8",
    "Sec-Fetch-Dest" to "empty",
    "Sec-Fetch-Mode" to "cors",
    "Sec-Fetch-Site" to "same-origin"
)

val hendrarEnumConfig = mapOf(
    "USERNAME" to "hendrar",
    "TOKEN-ID" to "000",
    "SERIES-ID" to "000",
)

val emptyTokenAndSeriesConfig = mapOf(
    "TOKEN-ID" to "000",
    "SERIES-ID" to "000",
)
