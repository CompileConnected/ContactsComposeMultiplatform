package com.plcoding.contactscomposemultiplatform.di

import com.plcoding.contactscomposemultiplatform.core.network.assignment.AssignmentApi
import com.plcoding.contactscomposemultiplatform.core.network.assignment.AssignmentApiImpl
import com.plcoding.contactscomposemultiplatform.core.network.enums.EnumApi
import com.plcoding.contactscomposemultiplatform.core.network.enums.EnumApiImpl
import com.plcoding.contactscomposemultiplatform.core.network.extensions.JsonMe
import com.plcoding.contactscomposemultiplatform.core.network.login.LoginApi
import com.plcoding.contactscomposemultiplatform.core.network.login.LoginApiImpl
import com.plcoding.contactscomposemultiplatform.core.network.menu.MenuApi
import com.plcoding.contactscomposemultiplatform.core.network.menu.MenuApiImpl
import com.plcoding.contactscomposemultiplatform.core.network.serveon.ServeOnApi
import com.plcoding.contactscomposemultiplatform.core.network.serveon.ServeOnApiImpl
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val apiModule = module {
    single {
        HttpClient {
            expectSuccess = true
            install(ContentNegotiation) {
                json(JsonMe)
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        co.touchlab.kermit.Logger.v(null, "Ktor") { message }
                    }
                }
            }
        }
    }

    singleOf(::LoginApiImpl).bind(LoginApi::class)
    singleOf(::MenuApiImpl).bind(MenuApi::class)
    singleOf(::EnumApiImpl).bind(EnumApi::class)
    singleOf(::AssignmentApiImpl).bind(AssignmentApi::class)
    singleOf(::ServeOnApiImpl).bind(ServeOnApi::class)
}