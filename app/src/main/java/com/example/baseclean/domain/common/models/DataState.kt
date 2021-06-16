package com.example.baseclean.domain.common.models

enum class ErrorType { NETWORK, NOT_FOUND, UNKNOWN }

sealed class DataState<out R> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(
        val errorType: ErrorType? = null,
        val errorCode: Int = 0,
        val message: String? = null
    ) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}
