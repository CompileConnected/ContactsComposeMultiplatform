package com.plcoding.contactscomposemultiplatform.core.data.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorkGroup(
    @SerialName("id"              ) var id              : String?  = null,
    @SerialName("createdBy"       ) var createdBy       : String?  = null,
    @SerialName("createdDate"     ) var createdDate     : Long?     = null,
    @SerialName("modifiedBy"      ) var modifiedBy      : String?  = null,
    @SerialName("modifiedDate"    ) var modifiedDate    : Long?     = null,
    @SerialName("ownerCompanyId"  ) var ownerCompanyId  : String?  = null,
    @SerialName("systemGenerated" ) var systemGenerated : String?  = null,
    @SerialName("name"            ) var name            : String?  = null,
    @SerialName("billable"        ) var billable        : Boolean? = null,
    @SerialName("orderNo"         ) var orderNo         : Long?     = null,
    @SerialName("row"             ) var row             : Long?     = null,
    @SerialName("page"            ) var page            : Long?     = null,
    @SerialName("sort"            ) var sort            : String?  = null,
    @SerialName("sortName"        ) var sortName        : String?  = null,
    @SerialName("sortBy"          ) var sortBy          : String?  = null
)
