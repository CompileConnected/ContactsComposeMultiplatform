package com.plcoding.contactscomposemultiplatform.core

typealias KermitLog = co.touchlab.kermit.Logger

inline fun KermitLog.e(throwable: Throwable) {
    this.e(throwable.message ?: throwable.toString(), throwable)
}


