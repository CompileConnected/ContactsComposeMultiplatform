package com.plcoding.contactscomposemultiplatform.core.network.enums

import kotlinx.serialization.Serializable


@Serializable
data class WorkLocationRequest(
    val npk: String
)
