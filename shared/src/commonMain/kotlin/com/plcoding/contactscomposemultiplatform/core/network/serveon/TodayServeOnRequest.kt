package com.plcoding.contactscomposemultiplatform.core.network.serveon

import kotlinx.serialization.Serializable

@Serializable
data class TodayServeOnRequest(val npk: String)