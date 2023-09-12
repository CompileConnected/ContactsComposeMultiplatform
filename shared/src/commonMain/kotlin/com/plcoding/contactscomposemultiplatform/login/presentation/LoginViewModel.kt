package com.plcoding.contactscomposemultiplatform.login.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import co.touchlab.kermit.Logger
import com.plcoding.contactscomposemultiplatform.core.data.Employee
import com.plcoding.contactscomposemultiplatform.core.domain.DataStorePreference
import com.plcoding.contactscomposemultiplatform.core.network.login.LoginApi
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginApi: LoginApi,
    private val dataStore: DataStorePreference
) : ViewModel() {
    private val loginApiStateFlow = MutableStateFlow<LoginApiState>(LoginApiState.Default)

    @OptIn(ExperimentalCoroutinesApi::class)
    val loginStateFlow = loginApiStateFlow.combine(dataStore.loginEmployee) { state, employee ->
        if (employee != null) {
            LoginApiState.Success(employee)
        } else {
            state
        }
    }.mapLatest {
        delay(200)
        it
    }

    var loginFormState by mutableStateOf(LoginFormState())
        private set

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnPasswordChanged -> {
                loginFormState = loginFormState.copy(password = event.value, passwordError = null)
            }

            is LoginEvent.OnUserNameChanged -> {
                loginFormState = loginFormState.copy(userName = event.value, userNameError = null)
            }

            LoginEvent.DoLogin -> {
                val password = loginFormState.password.trim()
                val userName = loginFormState.userName.trim()
                if (password.isEmpty()) {
                    loginFormState =
                        loginFormState.copy(passwordError = "Harap mengisi password terlebih dahulu")
                } else if (password.length < 6) {
                    loginFormState =
                        loginFormState.copy(passwordError = "Password yang dimasukkan kurang dari 5 karakter")
                }

                if (userName.isEmpty()) {
                    loginFormState =
                        loginFormState.copy(userNameError = "Harap mengisi user name terlebih dahulu")
                } else if (userName.length < 6) {
                    loginFormState =
                        loginFormState.copy(userNameError = "User name yang dimasukkan kurang dari 5 karakter")
                }


                val passwordError = loginFormState.passwordError
                val userNameError = loginFormState.userNameError

                val error = passwordError != null || userNameError != null
                if (!error) {
                    startLogin(userName, password)
                }
            }
        }
    }

    private fun startLogin(username: String, password: String) {
        viewModelScope.launch {
            loginApiStateFlow.emit(LoginApiState.Loading)
            try {
                val result = loginApi.login(username, password)
                Logger.v { "HTTP\n $result" }
                if (result.result == true) {
                    val updateResult = dataStore.updateLogin(result)
                    if (updateResult.isFailure) {
                        throw updateResult.exceptionOrNull()!!
                    }
                } else {

                    val errorMessage =
                        result.description ?: "Password atau username tidak ditemukan"
                    throw Exception(errorMessage)
                }
            } catch (e: Exception) {
                loginApiStateFlow.emit(LoginApiState.Error(e))
            }
        }
    }
}