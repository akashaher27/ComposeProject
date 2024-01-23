package com.example.core.util

import java.lang.Exception


inline fun <R> resultOf(block: () -> R): Result<R> {
    return try {
        Result.success(block())
    } catch (e: Exception) {
        Result.failure(e)
    }
}