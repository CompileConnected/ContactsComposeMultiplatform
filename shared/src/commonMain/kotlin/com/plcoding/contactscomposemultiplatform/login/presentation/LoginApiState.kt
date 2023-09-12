package com.plcoding.contactscomposemultiplatform.login.presentation

import com.plcoding.contactscomposemultiplatform.core.data.Employee

sealed interface LoginApiState {
    object Default: LoginApiState
    object Loading : LoginApiState
    data class Success(val employee: Employee) : LoginApiState
    data class Error(val throwable: Throwable) : LoginApiState
}
