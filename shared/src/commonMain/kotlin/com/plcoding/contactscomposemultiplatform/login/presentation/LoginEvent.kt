package com.plcoding.contactscomposemultiplatform.login.presentation

sealed interface LoginEvent {
    object DoLogin: LoginEvent

    data class OnUserNameChanged(val value: String): LoginEvent

    data class OnPasswordChanged(val value: String): LoginEvent

}