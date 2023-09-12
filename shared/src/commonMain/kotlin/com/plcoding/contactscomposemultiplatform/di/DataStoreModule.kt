package com.plcoding.contactscomposemultiplatform.di

import com.plcoding.contactscomposemultiplatform.core.domain.DataStorePreference
import com.plcoding.contactscomposemultiplatform.core.domain.DataStorePreferenceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module



internal fun DataStoreAdapterModule(dataStoreFactory: DataStoreFactory) = module {
    single { dataStoreFactory.createDataStore() }
    singleOf(::DataStorePreferenceImpl).bind(DataStorePreference::class)
}