package com.plcoding.contactscomposemultiplatform.core.network.assignment

import com.plcoding.contactscomposemultiplatform.core.data.Assignment
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class AssignmentResult(
    @SerialName("result"      ) val result      : List<Assignment> = listOf(),
    @SerialName("status"      ) val status      : Boolean?          = null,
    @SerialName("description" ) val description : String?           = null,
    @SerialName("totalData"   ) val totalData   : Int?              = null
)