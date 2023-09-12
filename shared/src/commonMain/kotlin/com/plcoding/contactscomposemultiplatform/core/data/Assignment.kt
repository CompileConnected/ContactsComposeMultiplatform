package com.plcoding.contactscomposemultiplatform.core.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Assignment(
    @SerialName("id"               ) val id               : String? = null,
    @SerialName("createdBy"        ) val createdBy        : String? = null,
    @SerialName("createdDate"      ) val createdDate      : String? = null,
    @SerialName("modifiedBy"       ) val modifiedBy       : String? = null,
    @SerialName("modifiedDate"     ) val modifiedDate     : String? = null,
    @SerialName("ownerCompanyId"   ) val ownerCompanyId   : String? = null,
    @SerialName("systemGenerated"  ) val systemGenerated  : String? = null,
    @SerialName("assignmentNumber" ) val assignmentNumber : String? = null,
    @SerialName("name"             ) val name             : String? = null,
    @SerialName("employeeId"       ) val employeeId       : String? = null,
    @SerialName("employeeName"     ) val employeeName     : String? = null,
    @SerialName("namagabung"       ) val namagabung       : String? = null,
    @SerialName("custname"         ) val custname         : String? = null,
    @SerialName("startTime"        ) val startTime        : Long?    = null,
    @SerialName("endTime"          ) val endTime          : Long?    = null,
    @SerialName("roles"            ) val roles            : String? = null,
    @SerialName("type"             ) val type             : String? = null,
    @SerialName("remark"           ) val remark           : String? = null,
    @SerialName("status"           ) val status           : String? = null,
    @SerialName("projectStartTime" ) val projectStartTime : Long?    = null,
    @SerialName("projectEndTime"   ) val projectEndTime   : Long?    = null,
    @SerialName("date_correct"     ) val dateCorrect      : String? = null,
    @SerialName("starttimeint"     ) val starttimeint     : Long?    = null,
    @SerialName("endtimeint"       ) val endtimeint       : Long?    = null,
    @SerialName("sortName"         ) val sortName         : String? = null,
    @SerialName("sortBy"           ) val sortBy           : String? = null,
    @SerialName("row"              ) val row              : Int?    = null,
    @SerialName("page"             ) val page             : Int?    = null
)