package com.plcoding.contactscomposemultiplatform.core.network.login

import kotlinx.serialization.Serializable


@Serializable
data class LoginRequest(
    val companyId: String = "",
    val companyName: String = "",
    val customerId: String = "",
    val customerName: String = "",
    val ipAddress: String = "",
    val macAddress: String = "",
    val name: String = "",
    val password: String,
    val series: String = "",
    val token: String = "",
    val userId: String = "",
    val username: String,
    val workLocationId: String = "",
    val workLocationName: String = ""
)
