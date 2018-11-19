package com.articles.marcos.livedata_viewmodel.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.articles.marcos.livedata_viewmodel.converter.ListConverter
import java.util.*

@Entity(tableName = "traineeRoutine")
data class Routine(
        @PrimaryKey(autoGenerate = true)
        val routineId: Int,
        @ColumnInfo(name = "due_day")
        val dueDay: Date,
        @TypeConverters(ListConverter::class)
        val exercises: List<Exercise>)