package com.plcoding.contactscomposemultiplatform.core.network.general

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class GeneralResponse(
    @SerialName("status"      ) var status      : Boolean?          = null,
    @SerialName("description" ) var description : String?           = null,
)