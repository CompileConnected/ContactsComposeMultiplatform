package com.plcoding.contactscomposemultiplatform.core.data.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class WorkLocation (

    @SerialName("id"               ) var id               : String? = null,
    @SerialName("createdBy"        ) var createdBy        : String? = null,
    @SerialName("createdDate"      ) var createdDate      : Long? = null,
    @SerialName("modifiedBy"       ) var modifiedBy       : String? = null,
    @SerialName("modifiedDate"     ) var modifiedDate     : Long? = null,
    @SerialName("ownerCompanyId"   ) var ownerCompanyId   : String? = null,
    @SerialName("systemGenerated"  ) var systemGenerated  : String? = null,
    @SerialName("userId"           ) var userId           : String? = null,
    @SerialName("workLocationId"   ) var workLocationId   : String? = null,
    @SerialName("workLocationName" ) var workLocationName : String? = null,
    @SerialName("address"          ) var address          : String? = null,
    @SerialName("latitude"         ) var latitude         : Double? = null,
    @SerialName("longitude"        ) var longitude        : Double? = null,
    @SerialName("maxRadius"        ) var maxRadius        : Long?    = null,
    @SerialName("workScheduleId"   ) var workScheduleId   : String? = null,
    @SerialName("workScheduleName" ) var workScheduleName : String? = null,
    @SerialName("orderNo"          ) var orderNo          : String? = null,
    @SerialName("startTime"        ) var startTime        : String? = null,
    @SerialName("endTime"          ) var endTime          : String? = null,
    @SerialName("breakStartTime"   ) var breakStartTime   : String? = null,
    @SerialName("breakEndTime"     ) var breakEndTime     : String? = null,
    @SerialName("lateTolerance"    ) var lateTolerance    : String? = null,
    @SerialName("type"             ) var type             : String? = null,
    @SerialName("assignmentId"     ) var assignmentId     : String? = null,
    @SerialName("npk"              ) var npk              : String? = null,
    @SerialName("main"             ) var main             : String? = null

)