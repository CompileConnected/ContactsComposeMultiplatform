package com.plcoding.contactscomposemultiplatform.serveon

import com.plcoding.contactscomposemultiplatform.core.KermitLog
import com.plcoding.contactscomposemultiplatform.core.data.Employee
import com.plcoding.contactscomposemultiplatform.core.domain.DataStorePreference
import com.plcoding.contactscomposemultiplatform.core.e
import com.plcoding.contactscomposemultiplatform.core.network.assignment.AssignmentApi
import com.plcoding.contactscomposemultiplatform.core.network.serveon.ServeOnApi
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.plugins.ClientRequestException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class ServeOnViewModel(
    private val dataStore: DataStorePreference,
    private val serveOnApi: ServeOnApi,
    private val assignmentApi: AssignmentApi,

    ) : ViewModel() {
    val employee = dataStore.loginEmployee

    private val _serveOnTodayApiStateFlow =
        MutableStateFlow<ServeOnTodayApiState>(ServeOnTodayApiState.Default)

    val serveOnTodayApiStateFlow =
        _serveOnTodayApiStateFlow.combine(employee) { state, employee ->
            if (state is ServeOnTodayApiState.Default) {
                checkTodayServeOn(employee)
                state
            } else {
                state
            }
        }.mapLatest {
            delay(200)
            it
        }


    private fun checkTodayServeOn(employee: Employee?) {
        viewModelScope.launch {
            if (employee == null) {
                _serveOnTodayApiStateFlow.emit(ServeOnTodayApiState.LoginExpire)
            } else {
                _serveOnTodayApiStateFlow.emit(ServeOnTodayApiState.Loading)
                val result = try {
                    val todayServeOn = serveOnApi.getTodayServeOn(employee)
                    val assignment = if (todayServeOn.isEmpty()) {
                        assignmentApi.getAssignment(employee).result
                    } else {
                        null
                    }

                    ServeOnTodayApiState.Success(todayServeOn, assignment)
                } catch (e: ClientRequestException) {
                    if (e.response.status.value == 401) {
                        dataStore.clearLogin()
                        ServeOnTodayApiState.LoginExpire
                    } else {
                        ServeOnTodayApiState.Error(e)
                    }
                } catch (e: Exception) {
                    KermitLog.e(e)
                    ServeOnTodayApiState.Error(e)
                }
                _serveOnTodayApiStateFlow.emit(result)
            }
        }
    }

    fun onEvent(event: ServeOnEvent) {
        viewModelScope.launch {
            when (event) {
                is ServeOnEvent.AssignmentServeOn -> {
                    //call api
                }

                is ServeOnEvent.ReloadAssignmentServeOn -> {
                    //call api
                }

                ServeOnEvent.ReloadServeOff -> {
                    //reload api
                }

                ServeOnEvent.ServeOff -> {
                    //call api
                }

                ServeOnEvent.ReloadTodayServeOn -> {
                    _serveOnTodayApiStateFlow.emit(ServeOnTodayApiState.Default)
                }
            }
        }
    }
}