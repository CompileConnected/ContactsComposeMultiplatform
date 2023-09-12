package com.plcoding.contactscomposemultiplatform.core.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class EmployeeTemplate (

    @SerialName("employeeId"          ) val employeeId          : String? = null,
    @SerialName("username"            ) val username            : String? = null,
    @SerialName("npk"                 ) val npk                 : String? = null,
    @SerialName("employeeIdFromERP"   ) val employeeIdFromERP   : String? = null,
    @SerialName("employeeName"        ) val employeeName        : String? = null,
    @SerialName("employeeStatus"      ) val employeeStatus      : String? = null,
    @SerialName("gender"              ) val gender              : String? = null,
    @SerialName("maritalStatus"       ) val maritalStatus       : String? = null,
    @SerialName("golongan"            ) val golongan            : String? = null,
    @SerialName("address"             ) val address             : String? = null,
    @SerialName("mobilePhone"         ) val mobilePhone         : String? = null,
    @SerialName("homePhone"           ) val homePhone           : String? = null,
    @SerialName("birthPlace"          ) val birthPlace          : String? = null,
    @SerialName("birthDate"           ) val birthDate           : Long?    = null,
    @SerialName("employeeType"        ) val employeeType        : String? = null,
    @SerialName("employeeSubGroup"    ) val employeeSubGroup    : String? = null,
    @SerialName("email"               ) val email               : String? = null,
    @SerialName("costCentreId"        ) val costCentreId        : String? = null,
    @SerialName("costCentreName"      ) val costCentreName      : String? = null,
    @SerialName("positionId"          ) val positionId          : String? = null,
    @SerialName("positionName"        ) val positionName        : String? = null,
    @SerialName("departmentId"        ) val departmentId        : String? = null,
    @SerialName("departmentName"      ) val departmentName      : String? = null,
    @SerialName("competencyLevelId"   ) val competencyLevelId   : String? = null,
    @SerialName("competencyLevelName" ) val competencyLevelName : String? = null,
    @SerialName("directHead"          ) val directHead          : String? = null,
    @SerialName("payScaleType"        ) val payScaleType        : String? = null,
    @SerialName("createdDate"         ) val createdDate         : String? = null,
    @SerialName("createdBy"           ) val createdBy           : String? = null,
    @SerialName("modifiedBy"          ) val modifiedBy          : String? = null,
    @SerialName("modifiedDate"        ) val modifiedDate        : String? = null,
    @SerialName("systemGenerated"     ) val systemGenerated     : String? = null,
    @SerialName("customfield1"        ) val customfield1        : String? = null,
    @SerialName("customfield2"        ) val customfield2        : String? = null,
    @SerialName("customfield3"        ) val customfield3        : String? = null,
    @SerialName("customfield4"        ) val customfield4        : String? = null,
    @SerialName("customfield5"        ) val customfield5        : String? = null,
    @SerialName("customfield6"        ) val customfield6        : String? = null,
    @SerialName("customfield7"        ) val customfield7        : String? = null,
    @SerialName("customfield8"        ) val customfield8        : String? = null,
    @SerialName("customfield9"        ) val customfield9        : String? = null,
    @SerialName("customfield10"       ) val customfield10       : String? = null,
    @SerialName("directHeadName"      ) val directHeadName      : String? = null,
    @SerialName("dateofentry"         ) val dateofentry         : String? = null,
    @SerialName("bankname"            ) val bankname            : String? = null,
    @SerialName("accountnumber"       ) val accountnumber       : String? = null,
    @SerialName("accountname"         ) val accountname         : String? = null,
    @SerialName("nobpjstk"            ) val nobpjstk            : String? = null
)