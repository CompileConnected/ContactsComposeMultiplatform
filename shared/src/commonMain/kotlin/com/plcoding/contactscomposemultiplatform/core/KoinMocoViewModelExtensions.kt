package com.plcoding.contactscomposemultiplatform.core

import androidx.compose.runtime.Composable
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import org.koin.core.Koin




@Composable
internal inline fun<reified R : ViewModel> Koin.viewModelOf(
    key: String ,
    crossinline constructor: () -> R,

    ): R = getViewModel(
    key = key,
    factory = viewModelFactory {
        new(constructor)
    }
)

@Composable
internal inline fun<reified R : ViewModel, reified T1> Koin.viewModelOf(
    key: String,
    crossinline constructor: (T1) -> R,

    ): R = getViewModel(
    key = key,
    factory = viewModelFactory {
        new(constructor)
    }
)

@Composable
internal inline fun<reified R : ViewModel, reified T1, reified T2> Koin.viewModelOf(
    key: String,
    crossinline constructor: (T1, T2) -> R,

    ): R = getViewModel(
    key = key,
    factory = viewModelFactory {
        new(constructor)
    }
)

@Composable
internal inline fun<reified R : ViewModel, reified T1, reified T2, reified T3> Koin.viewModelOf(
    key: String,
    crossinline constructor: (T1, T2, T3) -> R,

    ): R = getViewModel(
    key = key,
    factory = viewModelFactory {
        new(constructor)
    }
)

@Composable
internal inline fun<reified R : ViewModel, reified T1, reified T2, reified T3, reified T4> Koin.viewModelOf(
    key: String,
    crossinline constructor: (T1, T2, T3, T4) -> R,

    ): R = getViewModel(
    key = key,
    factory = viewModelFactory {
        new(constructor)
    }
)

@Composable
internal inline fun<reified R : ViewModel, reified T1, reified T2, reified T3, reified T4, reified T5> Koin.viewModelOf(
    key: String,
    crossinline constructor: (T1, T2, T3, T4, T5) -> R,

    ): R = getViewModel(
    key = key,
    factory = viewModelFactory {
        new(constructor)
    }
)

@Composable
internal inline fun<reified R : ViewModel, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6> Koin.viewModelOf(
    key: String,
    crossinline constructor: (T1, T2, T3, T4, T5, T6) -> R,

    ): R = getViewModel(
    key = key,
    factory = viewModelFactory {
        new(constructor)
    }
)

@Composable
internal inline fun<reified R : ViewModel, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7> Koin.viewModelOf(
    key: String,
    crossinline constructor: (T1, T2, T3, T4, T5, T6, T7) -> R,

    ): R = getViewModel(
    key = key,
    factory = viewModelFactory {
        new(constructor)
    }
)

@Composable
internal inline fun<reified R : ViewModel, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8> Koin.viewModelOf(
    key: String,
    crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8) -> R,

    ): R = getViewModel(
    key = key,
    factory = viewModelFactory {
        new(constructor)
    }
)

@Composable
internal inline fun<reified R : ViewModel, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9> Koin.viewModelOf(
    key: String,
    crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R,

    ): R = getViewModel(
    key = key,
    factory = viewModelFactory {
        new(constructor)
    }
)

@Composable
internal inline fun<reified R : ViewModel, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10> Koin.viewModelOf(
    key: String,
    crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R,

    ): R = getViewModel(
    key = key,
    factory = viewModelFactory {
        new(constructor)
    }
)