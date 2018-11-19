package com.articles.marcos.livedata_viewmodel.dao

import android.arch.persistence.room.*
import com.articles.marcos.livedata_viewmodel.entity.Exercise

@Dao
interface ExerciseDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDayRoutine(exercise: Exercise)

    @Update
    fun updateDayRoutine(exercise: Exercise)

    @Delete
    fun deleteDayRoutine(exercise: Exercise)

    @Query("SELECT * FROM Exercise WHERE name == :exerciseName")
    fun getExerciseByName(exerciseName: String): List<Exercise>
}