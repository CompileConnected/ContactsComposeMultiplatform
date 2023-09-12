package com.plcoding.contactscomposemultiplatform.core.data.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReasonOnLate(
    @SerialName("globalTypeId" ) var globalTypeId : String? = null,
    @SerialName("name"         ) var name         : String? = null,
    @SerialName("description"  ) var description  : String? = null,
    @SerialName("category"     ) var category     : String? = null,
    @SerialName("modulId"      ) var modulId      : String? = null,
    @SerialName("typeId"       ) var typeId       : String? = null,
    @SerialName("parent"       ) var parent       : Long?    = null
)
