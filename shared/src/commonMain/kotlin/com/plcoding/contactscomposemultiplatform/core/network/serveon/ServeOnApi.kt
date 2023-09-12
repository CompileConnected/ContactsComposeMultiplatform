package com.plcoding.contactscomposemultiplatform.core.network.serveon

import com.plcoding.contactscomposemultiplatform.core.data.Employee
import com.plcoding.contactscomposemultiplatform.core.data.ServeOn
import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkActivity
import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkFrom
import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkGroup
import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkLocation

interface ServeOnApi {
    suspend fun getTodayServeOn(employee: Employee): List<ServeOn>
    suspend fun serveOn(
        employee: Employee,
        workLocation: WorkLocation,
        workGroup: WorkGroup,
        workActivity: WorkActivity,
        workFrom: WorkFrom
    )
}