package com.plcoding.contactscomposemultiplatform.core.domain

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.plcoding.contactscomposemultiplatform.core.data.Employee
import com.plcoding.contactscomposemultiplatform.core.network.extensions.JsonMe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.serializer

internal class DataStorePreferenceImpl(private val store: DataStore<Preferences>) :
    DataStorePreference {
    private val loginKey = stringPreferencesKey("Test")

    override val loginEmployee:  Flow<Employee?>
        get() = store.data.map {
            val x = it[loginKey]
            if (!x.isNullOrEmpty()) {
                JsonMe.decodeFromString(x)
            } else {
                null
            }
        }

    override suspend fun updateLogin(employee: Employee): Result<Unit> {
        return Result.runCatching {
            store.edit {
                it[loginKey] = JsonMe.encodeToString(serializer(), value = employee)
            }
        }
    }

    override suspend fun clearLogin(): Result<Unit> {
        return Result.runCatching {
            store.edit {
                it.remove(loginKey)
            }
        }
    }
}