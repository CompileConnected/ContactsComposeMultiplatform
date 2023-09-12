package com.plcoding.contactscomposemultiplatform.core.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup

@Composable
fun LoadingSmall() {
    Popup {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun LoadingScreen() {
    Popup {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color.DarkGray.copy(0.8f)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun ErrorScreen(message: String, onOutsideContentClick: () -> Unit) {
    Popup {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color.DarkGray.copy(0.8f))
                .clickable {
                    onOutsideContentClick()
                },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                Modifier.widthIn(min = 330.dp, max = 370.dp)
                    .heightIn(min = 300.dp, max = 370.dp)
                    .padding(10.dp)
                    .verticalScroll(rememberScrollState())
                    .clickable(role = Role.Image) { }
            ) {
                Text(
                    message, modifier = Modifier.padding(horizontal = 18.dp, vertical = 21.dp)
                )
            }
        }
    }
}