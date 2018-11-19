package com.articles.marcos.livedata_viewmodel.dao

import android.arch.persistence.room.*
import com.articles.marcos.livedata_viewmodel.entity.Trainee

@Dao
interface TraineeDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTrainee(trainee: Trainee)

    @Update
    fun updateTrainee(trainee: Trainee)

    @Delete
    fun deleteTrainee(trainee: Trainee)

    @Query("SELECT * FROM Trainee WHERE name = :nameToFind")
    fun getUserByName(nameToFind: String): List<Trainee>
}