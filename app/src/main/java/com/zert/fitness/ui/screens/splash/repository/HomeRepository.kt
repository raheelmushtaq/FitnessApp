package com.zert.fitness.ui.screens.splash.repository

import com.zert.fitness.data.data_source.entities.Exercises
import com.zert.fitness.webservices.APIManager
import com.zert.fitness.webservices.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepository(private val apiManager: APIManager) {

    fun getListOfTests(): Flow<ResponseState<ArrayList<Exercises>>> = flow {
        emit(ResponseState.Loading)
        try {
            apiManager.getListOfTitles().collect {
                emit(it)
            }

        } catch (e: Exception) {
            emit(ResponseState.Error(e))
        }
    }

    fun getLisOfQuestions(nodeName: String): Flow<ResponseState<ArrayList<Exercises>>> =
        flow {
            emit(ResponseState.Loading)
            try {
                apiManager.getListOfQuestions(nodeName).collect {
                    emit(it)
                }

            } catch (e: Exception) {
                emit(ResponseState.Error(e))
            }
        }

}