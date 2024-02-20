package com.zert.fitness.data.data_source.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Tests")
data class Exercises(var title: String = "", @PrimaryKey var nodeName: String = "") : Parcelable {}