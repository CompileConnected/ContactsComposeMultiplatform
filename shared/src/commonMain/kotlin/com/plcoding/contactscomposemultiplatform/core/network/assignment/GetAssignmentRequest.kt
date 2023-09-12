package com.plcoding.contactscomposemultiplatform.core.network.assignment

import kotlinx.serialization.Serializable


@Serializable
data class GetAssignmentRequest(
    val employeeId: String,
    val status: String = "3001",
    val sortName: String = "id",
    val sortBy: String = "asc",
    val row: Int = 100,
    val page: Int = 0
)
