package com.zert.fitness.webservices

import java.lang.Exception

sealed class ResponseState<out T> {
    data class Success<out E>(val response: E) : ResponseState<E>()
    object Loading : ResponseState<Nothing>()
    data class Error(val exception: Exception) : ResponseState<Nothing>()

}