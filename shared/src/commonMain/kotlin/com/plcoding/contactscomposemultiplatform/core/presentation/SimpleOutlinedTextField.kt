package com.plcoding.contactscomposemultiplatform.core.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp


@Composable
fun TextFieldError(textError: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = textError,
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.error
        )
    }
}


@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalComposeUiApi::class
)
@Composable
fun SimpleOutlinedTextField(
    label: String,
    input: String,
    onInput: (String) -> Unit,
    error: String? = null,
    modifier: Modifier = Modifier,
    onFocused: ((FocusState) -> Unit)? = null,
    maxLines: Int = 1,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    onTabPressed: () -> Boolean = { false },
    onImeAction: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var passwordFocused by remember {
        mutableStateOf(false)
    }
    fun tabPressed(keyEvent: KeyEvent): Boolean {
        return if (keyEvent.key == Key.Tab) {
            onTabPressed()
        } else {
            false
        }
    }

    OutlinedTextField(
        value = input,
        onValueChange = {
            onInput.invoke(it)
        },
        modifier = modifier
            .fillMaxWidth()
            .onFocusChanged { focusState ->
                onFocused?.invoke(focusState)
                if (focusState.isFocused) passwordFocused = true
            }
            .onKeyEvent {
                tabPressed(it)
            },
        textStyle = MaterialTheme.typography.bodyMedium,
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
            )
        },
        maxLines = maxLines,
        singleLine = maxLines == 1,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,

        isError = error != null,
        supportingText = {
            if (error != null) {
                TextFieldError(error)
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = imeAction,
            keyboardType = keyboardType
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                onImeAction()
            }
        ),
    )
}

