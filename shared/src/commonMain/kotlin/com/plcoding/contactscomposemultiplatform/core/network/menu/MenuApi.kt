package com.plcoding.contactscomposemultiplatform.core.network.menu

import com.plcoding.contactscomposemultiplatform.core.data.Employee
import com.plcoding.contactscomposemultiplatform.core.data.Menu

interface MenuApi {
    suspend fun menu(employee: Employee): List<Menu>
}