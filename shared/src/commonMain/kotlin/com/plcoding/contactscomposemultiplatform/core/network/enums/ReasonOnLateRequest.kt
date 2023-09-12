package com.plcoding.contactscomposemultiplatform.core.network.enums

import kotlinx.serialization.Serializable

@Serializable
data class ReasonOnLateRequest (
    val name: String = "",
    val category: String = "",
    val moduleId: String = "8",
    val typeId: String = "",
    val parent: String = ""

)