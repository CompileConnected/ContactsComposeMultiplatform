package com.plcoding.contactscomposemultiplatform.core.data.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorkResult(
    @SerialName("id"              ) var id              : String? = null,
    @SerialName("createdBy"       ) var createdBy       : String? = null,
    @SerialName("createdDate"     ) var createdDate     : Long?    = null,
    @SerialName("modifiedBy"      ) var modifiedBy      : String? = null,
    @SerialName("modifiedDate"    ) var modifiedDate    : Long? = null,
    @SerialName("ownerCompanyId"  ) var ownerCompanyId  : String? = null,
    @SerialName("systemGenerated" ) var systemGenerated : String? = null,
    @SerialName("name"            ) var name            : String? = null,
    @SerialName("row"             ) var row             : Int?    = null,
    @SerialName("page"            ) var page            : Int?    = null,
    @SerialName("sort"            ) var sort            : String? = null,
    @SerialName("sortName"        ) var sortName        : String? = null,
    @SerialName("sortBy"          ) var sortBy          : String? = null
)
