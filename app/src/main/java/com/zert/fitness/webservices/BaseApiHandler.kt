package com.zert.fitness.webservices

import com.zert.fitness.data.data_source.entities.Exercises
import kotlinx.coroutines.flow.Flow

interface BaseApiHandler {
    fun getListOfTitles(): Flow<ResponseState<ArrayList<Exercises>>>;
    fun getListOfQuestions(nodeName: String): Flow<ResponseState<ArrayList<Exercises>>>
}