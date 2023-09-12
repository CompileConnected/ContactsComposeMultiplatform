package com.plcoding.contactscomposemultiplatform.serveon

import com.plcoding.contactscomposemultiplatform.core.data.Assignment
import com.plcoding.contactscomposemultiplatform.core.data.ServeOn

sealed interface ServeOnTodayApiState {
    object Default : ServeOnTodayApiState

    object Loading: ServeOnTodayApiState

    object LoginExpire :  ServeOnTodayApiState

    data class Success(val listOfServeOn: List<ServeOn>, val assignment: List<Assignment>? = null): ServeOnTodayApiState

    data class Error(val throwable: Throwable): ServeOnTodayApiState


}