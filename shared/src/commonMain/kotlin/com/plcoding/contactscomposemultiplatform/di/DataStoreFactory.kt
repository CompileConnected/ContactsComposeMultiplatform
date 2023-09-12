package com.plcoding.contactscomposemultiplatform.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import kotlinx.atomicfu.locks.SynchronizedObject
import kotlinx.atomicfu.locks.synchronized
import okio.Path.Companion.toPath


/**
 * Gets the singleton DataStore instance, creating it if necessary.
 */
expect class DataStoreFactory {
    fun createDataStore(): DataStore<Preferences>
}


private lateinit var dataStore: DataStore<Preferences>

private val lock = SynchronizedObject()

fun getDataStore(producePath: () -> String): DataStore<Preferences> =
    synchronized(lock) {
        if (::dataStore.isInitialized) {
            dataStore
        } else {
            PreferenceDataStoreFactory.createWithPath(produceFile = { producePath().toPath() })
                .also { dataStore = it }
        }
    }


internal const val dataStoreFileName = "serveon.preferences_pb"


