package com.plcoding.contactscomposemultiplatform.core.network.serveon


import com.plcoding.contactscomposemultiplatform.core.data.ServeOn
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ServeOnResponse (

    @SerialName("result"      ) var result      : List<ServeOn>? = listOf(),
    @SerialName("status"      ) var status      : Boolean?          = null,
    @SerialName("description" ) var description : String?           = null,
    @SerialName("totalData"   ) var totalData   : Int?              = null

)