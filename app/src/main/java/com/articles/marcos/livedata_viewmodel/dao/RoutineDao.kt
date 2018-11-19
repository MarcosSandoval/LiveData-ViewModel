package com.articles.marcos.livedata_viewmodel.dao

import android.arch.persistence.room.*
import com.articles.marcos.livedata_viewmodel.entity.Routine
import java.util.*

@Dao
interface RoutineDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRoutine(routine: Routine)

    @Update
    fun updateRoutine(routine: Routine)

    @Delete
    fun deleteRoutine(routine: Routine)

    @Query("SELECT * FROM traineeRoutine WHERE due_Day >= :due")
    fun getRoutineByDueDate(due: Date): List<Routine>
}