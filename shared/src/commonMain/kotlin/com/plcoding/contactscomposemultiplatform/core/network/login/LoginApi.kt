package com.plcoding.contactscomposemultiplatform.core.network.login

import com.plcoding.contactscomposemultiplatform.core.data.Employee

interface LoginApi {
    suspend fun login(username: String, password: String): Employee

}