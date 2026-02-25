package com.example.core.network

sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Error(val error: DataError) : Result<Nothing>
}

enum class DataError {
    NO_INTERNET,
    TIMEOUT,
    SERVER_ERROR,
    CLIENT_ERROR,
    UNAUTHORIZED,
    NOT_FOUND,
}