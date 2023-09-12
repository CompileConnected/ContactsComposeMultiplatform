package com.plcoding.contactscomposemultiplatform.core.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Employee (

    @SerialName("result"           ) val result           : Boolean?          = null,
    @SerialName("description"      ) val description      : String?           = null,
    @SerialName("userid"           ) val userid           : String?           = null,
    @SerialName("username"         ) val username         : String?           = null,
    @SerialName("accessTime"       ) val accessTime       : Long?             = null,
    @SerialName("downloadUrl"      ) val downloadUrl      : String?           = null,
    @SerialName("downloadCode"     ) val downloadCode     : String?           = null,
    @SerialName("status"           ) val status           : String?           = null,
    @SerialName("token"            ) val token            : String?           = null,
    @SerialName("refreshtoken"     ) val refreshToken     : String?           = null,
    @SerialName("series"           ) val series           : String?           = null,
    @SerialName("grantedAuths"     ) val grantedAuths     : List<String>?     = listOf(),
    @SerialName("orgId"            ) val orgId            : String?           = null,
    @SerialName("userProfile"      ) val userProfile      : UserProfile?      = UserProfile(),
    @SerialName("employeeTemplate" ) val employeeTemplate : EmployeeTemplate? = EmployeeTemplate()
)