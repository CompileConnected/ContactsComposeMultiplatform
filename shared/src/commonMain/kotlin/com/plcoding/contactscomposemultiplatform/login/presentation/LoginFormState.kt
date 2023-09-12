package com.plcoding.contactscomposemultiplatform.login.presentation

data class LoginFormState(
    val userName: String = "",
    val password: String = "",
    val userNameError: String? = null,
    val passwordError: String? = null
)