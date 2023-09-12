package com.plcoding.contactscomposemultiplatform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import org.koin.core.Koin
import org.koin.core.annotation.KoinInternalApi
import org.koin.core.module.Module
import org.koin.dsl.koinApplication
import org.koin.mp.KoinPlatformTools

private fun getKoinContext() = KoinPlatformTools.defaultContext().get()

@Composable
fun Koin(): Koin = LocalKoinApplication.current

val LocalKoinApplication = compositionLocalOf { getKoinContext() }

@OptIn(KoinInternalApi::class)
val LocalKoinScope = compositionLocalOf { getKoinContext().scopeRegistry.rootScope }


@OptIn(KoinInternalApi::class)
@Composable
fun KoinApplication(
    modules: () -> List<Module>,
    content: @Composable () -> Unit
) {
    val koinApplication = koinApplication { modules(modules()) }
    CompositionLocalProvider(
        LocalKoinApplication provides koinApplication.koin,
        LocalKoinScope provides koinApplication.koin.scopeRegistry.rootScope
    ) {
        content()
    }
}