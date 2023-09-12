package com.plcoding.contactscomposemultiplatform.core.data.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorkActivity(
    @SerialName("id"              ) var id              : String? = null,
    @SerialName("createdBy"       ) var createdBy       : String? = null,
    @SerialName("createdDate"     ) var createdDate     : Long?    = null,
    @SerialName("modifiedBy"      ) var modifiedBy      : String? = null,
    @SerialName("modifiedDate"    ) var modifiedDate    : String? = null,
    @SerialName("ownerCompanyId"  ) var ownerCompanyId  : String? = null,
    @SerialName("systemGenerated" ) var systemGenerated : String? = null,
    @SerialName("name"            ) var name            : String? = null,
    @SerialName("servegroupid"    ) var servegroupid    : String? = null,
    @SerialName("orderNo"         ) var orderNo         : Long?    = null
)
