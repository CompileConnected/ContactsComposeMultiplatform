package com.plcoding.contactscomposemultiplatform.serveon

import com.plcoding.contactscomposemultiplatform.core.data.Assignment

sealed interface ServeOnEvent {
    data class AssignmentServeOn(val data: Assignment): ServeOnEvent

    data class ReloadAssignmentServeOn(val data: Assignment): ServeOnEvent

    object ServeOff: ServeOnEvent

    object ReloadServeOff: ServeOnEvent

    object ReloadTodayServeOn: ServeOnEvent

}