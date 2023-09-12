package com.plcoding.contactscomposemultiplatform.login.presentation


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.plcoding.contactscomposemultiplatform.Koin
import com.plcoding.contactscomposemultiplatform.core.presentation.ErrorScreen
import com.plcoding.contactscomposemultiplatform.core.presentation.LoadingScreen
import com.plcoding.contactscomposemultiplatform.core.presentation.SimpleOutlinedTextField
import com.plcoding.contactscomposemultiplatform.core.viewModelOf
import com.plcoding.contactscomposemultiplatform.serveon.ServeOnScreen
import compose.icons.EvaIcons
import compose.icons.evaicons.Outline
import compose.icons.evaicons.outline.Eye
import compose.icons.evaicons.outline.EyeOff2
import compose.icons.evaicons.outline.Flash


class LoginScreen : Screen {
    override val key: ScreenKey
        get() = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = Koin().viewModelOf("login-screen", ::LoginViewModel)
        val loginState by viewModel.loginStateFlow.collectAsState(LoginApiState.Default)

        val formState = viewModel.loginFormState
        var showErrorPopup by remember {
            mutableStateOf(true)
        }
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                LoginTitle()
                LoginInput(loginState is LoginApiState.Loading, formState) {
                    viewModel.onEvent(it)
                    if (it is LoginEvent.DoLogin) {
                        showErrorPopup = true
                    }
                }
            }

            when (loginState) {
                LoginApiState.Loading -> LoadingScreen()
                is LoginApiState.Success -> {
                    navigator.replace(ServeOnScreen())
                }

                is LoginApiState.Error -> {
                    if (showErrorPopup) {
                        ErrorScreen((loginState as LoginApiState.Error).throwable.message ?: "") {
                            showErrorPopup = false
                        }
                    }
                }

                else -> {}
            }
        }
    }

    @Composable
    private fun LoginTitle() {
        Row {
            Icon(
                imageVector = EvaIcons.Outline.Flash,
                contentDescription = "Quick",
            )
            Text("SERVE", style = MaterialTheme.typography.headlineLarge)
        }

        Text("Serve On but faster", style = MaterialTheme.typography.bodySmall)
    }


    @Composable
    private fun PasswordVisibleIcon(showPassword: Boolean, setPassword: (Boolean) -> Unit) {
        IconButton(onClick = { setPassword(!showPassword) }) {
            if (showPassword) {
                Icon(
                    imageVector = EvaIcons.Outline.EyeOff2,
                    contentDescription = "hide password"
                )
            } else {
                Icon(
                    imageVector = EvaIcons.Outline.Eye,
                    contentDescription = "show password"
                )
            }
        }
    }

    @Composable
    private fun LoginInput(
        isLoading: Boolean,
        formState: LoginFormState,
        onEvent: (LoginEvent) -> Unit
    ) {
        val (showPassword, setShowPassword) = rememberSaveable { mutableStateOf(false) }

        val focusManager = LocalFocusManager.current
        Card(
            modifier = Modifier.fillMaxWidth(0.87f)
                .widthIn(300.dp)
                .padding(20.dp),
            elevation = CardDefaults.elevatedCardElevation(4.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onBackground
            )
        ) {
            Column(modifier = Modifier.padding(15.dp)) {
                SimpleOutlinedTextField(
                    label = "User",
                    error = formState.userNameError,
                    input = formState.userName,
                    onInput = {
                        onEvent(LoginEvent.OnUserNameChanged(it))
                    },
                    imeAction = ImeAction.Next,
                    onTabPressed = {
                        focusManager.moveFocus(FocusDirection.Next)
                    },
                    onImeAction = {
                        focusManager.moveFocus(FocusDirection.Next)
                    })

                SimpleOutlinedTextField(
                    label = "Password",
                    error = formState.passwordError,
                    input = formState.password,
                    onInput = {
                        onEvent(LoginEvent.OnPasswordChanged(it))
                    },
                    trailingIcon = { PasswordVisibleIcon(showPassword, setShowPassword) },
                    visualTransformation = if (showPassword) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },
                    onImeAction = {
                        focusManager.clearFocus()
                    }
                )
                Button(
                    enabled = !isLoading,
                    onClick = {
                        focusManager.clearFocus(true)
                        onEvent(LoginEvent.DoLogin)
                    }, modifier = Modifier.fillMaxWidth().padding(20.dp)
                ) {
                    Text(text = "Login")
                }
            }
        }
    }
}