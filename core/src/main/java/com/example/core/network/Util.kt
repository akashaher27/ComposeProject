package com.example.core.network

import okio.IOException

suspend fun <T> safeNetworkCall(execute: suspend () -> T): Result<T> {
    return try {
        Result.Success(execute())
    } catch (e: Exception) {
        Result.Error(error = mapToDataError(e))
    }
}

fun mapToDataError(e: Exception): DataError {
    return when (e) {
        is IOException -> DataError.NO_INTERNET
        else -> DataError.SERVER_ERROR
    }
}