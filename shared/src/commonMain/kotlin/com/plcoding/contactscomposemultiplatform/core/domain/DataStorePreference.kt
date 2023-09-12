package com.plcoding.contactscomposemultiplatform.core.domain

import com.plcoding.contactscomposemultiplatform.core.data.Employee
import kotlinx.coroutines.flow.Flow

interface DataStorePreference {

    val loginEmployee: Flow<Employee?>
    suspend fun updateLogin(employee: Employee): Result<Unit>
    suspend fun clearLogin(): Result<Unit>
}