package com.plcoding.contactscomposemultiplatform

import androidx.compose.ui.interop.LocalUIViewController
import androidx.compose.ui.window.ComposeUIViewController
import com.plcoding.contactscomposemultiplatform.core.presentation.ImagePickerFactory
import com.plcoding.contactscomposemultiplatform.di.AppModule
import com.plcoding.contactscomposemultiplatform.di.DataStoreFactory
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle

fun MainViewController() = ComposeUIViewController {
    val isDarkTheme =
        UIScreen.mainScreen.traitCollection.userInterfaceStyle ==
                UIUserInterfaceStyle.UIUserInterfaceStyleDark
    App(
        darkTheme = isDarkTheme,
        dynamicColor = false,
        appModule = AppModule(),
        dataStoreFactory = DataStoreFactory(),
        imagePicker = ImagePickerFactory(LocalUIViewController.current).createPicker()
    )
}