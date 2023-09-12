package com.plcoding.contactscomposemultiplatform.core.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable



@Serializable
data class Menu (
    @SerialName("id"       ) var id       : String?           = null,
    @SerialName("title"    ) var title    : String?           = null,
    @SerialName("link"     ) var link     : String?           = null,
    @SerialName("url"      ) var url      : String?           = null,
    @SerialName("icon"     ) var icon     : String?           = null,
    @SerialName("rolesKey" ) var rolesKey : String?           = null,
    @SerialName("parentId" ) var parentId : String?           = null,
    @SerialName("submenu"  ) var submenu  : List<Menu>      = listOf()
)

