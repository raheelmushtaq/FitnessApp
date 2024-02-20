package com.zert.fitness.webservices

import com.zert.fitness.data.data_source.entities.Exercises
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class APIManager @Inject constructor(private var apiHandler: BaseApiHandler) {
    fun getListOfTitles(): Flow<ResponseState<ArrayList<Exercises>>> = apiHandler.getListOfTitles()
    fun getListOfQuestions(nodeName: String): Flow<ResponseState<ArrayList<Exercises>>> =
        apiHandler.getListOfQuestions(nodeName)

}