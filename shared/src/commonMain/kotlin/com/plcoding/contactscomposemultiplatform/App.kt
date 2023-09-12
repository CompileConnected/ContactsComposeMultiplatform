package com.plcoding.contactscomposemultiplatform

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.plcoding.contactscomposemultiplatform.core.presentation.AppTheme
import com.plcoding.contactscomposemultiplatform.core.presentation.ImagePicker
import com.plcoding.contactscomposemultiplatform.di.AppModule
import com.plcoding.contactscomposemultiplatform.di.DataStoreAdapterModule
import com.plcoding.contactscomposemultiplatform.di.DataStoreFactory
import com.plcoding.contactscomposemultiplatform.di.apiModule
import com.plcoding.contactscomposemultiplatform.login.presentation.LoginScreen
import com.plcoding.contactscomposemultiplatform.serveon.ServeOnScreen


@Composable
fun App(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    appModule: AppModule,
    dataStoreFactory: DataStoreFactory,
    imagePicker: ImagePicker
) {
    AppTheme(
        darkTheme = darkTheme,
        dynamicColor = dynamicColor
    ) {
        KoinApplication(modules = {
            listOf(apiModule) + listOf(
                DataStoreAdapterModule(dataStoreFactory)
            )
        }) {
            Navigator(LoginScreen())
        }
    }
}