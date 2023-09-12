package com.plcoding.contactscomposemultiplatform.core.network.enums


import com.plcoding.contactscomposemultiplatform.core.data.Employee
import com.plcoding.contactscomposemultiplatform.core.data.enums.ReasonOnLate
import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkActivity
import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkGroup
import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkLocation
import com.plcoding.contactscomposemultiplatform.core.data.enums.WorkResult


interface EnumApi {
    //non-existing
    //WFH
    //WFO

    suspend fun workLocation(employee: Employee): List<WorkLocation>

    /**
     * me:
     * Daily Jobs
     * Training,
     * Seminar
     * Self Development
     * Meeting Coordination
     */
    suspend fun workActivity(): List<WorkActivity>

    /**
     * me:
     * Sales
     * Business Development
     * Project Implementation
     * Project Internal
     * Internal -> shift: Regular
     */
    suspend fun workGroup(): List<WorkGroup>
    suspend fun workResult(): List<WorkResult>
    suspend fun reasonOnLate(employee: Employee): List<ReasonOnLate>
}