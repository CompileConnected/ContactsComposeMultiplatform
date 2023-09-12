package com.plcoding.contactscomposemultiplatform.core.network.assignment

import com.plcoding.contactscomposemultiplatform.core.data.Employee

interface AssignmentApi {
    suspend fun getAssignment(employee: Employee): AssignmentResult
}