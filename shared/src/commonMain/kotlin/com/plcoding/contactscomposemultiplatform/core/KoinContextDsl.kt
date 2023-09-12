package com.plcoding.contactscomposemultiplatform.core

import org.koin.core.Koin
import org.koin.core.module.dsl.new

internal inline fun <reified R> Koin.new(
    constructor: () -> R,
): R = constructor()

/**
 * @see new
 */
internal inline fun <reified R, reified T1> Koin.new(
    constructor: (T1) -> R,
): R = constructor(get())

/**
 * @see new
 */
internal inline fun <reified R, reified T1, reified T2> Koin.new(
    constructor: (T1, T2) -> R,
): R = constructor(get(), get())

/**
 * @see new
 */
internal inline fun <reified R, reified T1, reified T2, reified T3> Koin.new(
    constructor: (T1, T2, T3) -> R,
): R = constructor(get(), get(), get())

/**
 * @see new
 */
internal inline fun <reified R, reified T1, reified T2, reified T3, reified T4> Koin.new(
    constructor: (T1, T2, T3, T4) -> R,
): R = constructor(get(), get(), get(), get())

/**
 * @see new
 */
internal inline fun <reified R, reified T1, reified T2, reified T3, reified T4, reified T5> Koin.new(
    constructor: (T1, T2, T3, T4, T5) -> R,
): R = constructor(get(), get(), get(), get(), get())

/**
 * @see new
 */
internal inline fun <reified R, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6> Koin.new(
    constructor: (T1, T2, T3, T4, T5, T6) -> R,
): R = constructor(get(), get(), get(), get(), get(), get())

/**
 * @see new
 */
internal inline fun <reified R, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7> Koin.new(
    constructor: (T1, T2, T3, T4, T5, T6, T7) -> R,
): R = constructor(get(), get(), get(), get(), get(), get(), get())

/**
 * @see new
 */
internal inline fun <reified R, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8> Koin.new(
    constructor: (T1, T2, T3, T4, T5, T6, T7, T8) -> R,
): R = constructor(get(), get(), get(), get(), get(), get(), get(), get())

/**
 * @see new
 */
internal inline fun <reified R, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9> Koin.new(
    constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R,
): R = constructor(get(), get(), get(), get(), get(), get(), get(), get(), get())

/**
 * @see new
 */
internal inline fun <reified R, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10> Koin.new(
    constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R,
): R = constructor(get(), get(), get(), get(), get(), get(), get(), get(), get(), get())