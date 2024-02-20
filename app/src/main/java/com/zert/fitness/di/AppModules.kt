package com.zert.fitness.di

import android.app.Application
import androidx.room.Room
import com.zert.fitness.data.data_source.database.FitnessAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModules {

    @Provides
    @Singleton
    fun provideSkillAssessmentsDatabase(app: Application): FitnessAppDatabase {
        return Room.databaseBuilder(
            app, FitnessAppDatabase::class.java, FitnessAppDatabase.DATABASE_NAME
        ).build()
    }
}