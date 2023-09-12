package com.plcoding.contactscomposemultiplatform.core.network.enums


import com.plcoding.contactscomposemultiplatform.core.data.enums.ReasonOnLate
import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkActivity
import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkGroup
import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkLocation
import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkResult
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class WorkLocationResponse(
    @SerialName("result"      ) var result      : List<WorkLocation>? = listOf(),
    @SerialName("status"      ) var status      : Boolean?           = null,
    @SerialName("description" ) var description : String?            = null,
    @SerialName("totalData"   ) var totalData   : Int?               = null
)


@Serializable
data class WorkActivityResponse(
    @SerialName("result"      ) var result      : List<WorkActivity>? = listOf(),
    @SerialName("status"      ) var status      : Boolean?           = null,
    @SerialName("description" ) var description : String?            = null,
    @SerialName("totalData"   ) var totalData   : Int?               = null
)

@Serializable
data class WorkGroupResponse(
    @SerialName("result"      ) var result      : List<WorkGroup>? = listOf(),
    @SerialName("status"      ) var status      : Boolean?           = null,
    @SerialName("description" ) var description : String?            = null,
    @SerialName("totalData"   ) var totalData   : Int?               = null
)

@Serializable
data class WorkResultResponse(
    @SerialName("result"      ) var result      : List<WorkResult>? = listOf(),
    @SerialName("status"      ) var status      : Boolean?           = null,
    @SerialName("description" ) var description : String?            = null,
    @SerialName("totalData"   ) var totalData   : Int?               = null
)

@Serializable
data class ReasonOnLateResponse(
    @SerialName("globalType"  ) var result      : List<ReasonOnLate>? = listOf(),
    @SerialName("result"      ) var status      : Boolean?           = null,
    @SerialName("message"     ) var description : String?            = null,
    @SerialName("errorCode"   ) var errorCode   : Int?               = null
)