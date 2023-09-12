package com.plcoding.contactscomposemultiplatform.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

actual class DataStoreFactory(private val context: Context) {
    actual fun createDataStore(): DataStore<Preferences> =
        getDataStore(
            producePath = { context.filesDir.resolve(dataStoreFileName).absolutePath }
        )
}