package com.articles.marcos.livedata_viewmodel.dataBase

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.articles.marcos.livedata_viewmodel.converter.DateTypeConverter
import com.articles.marcos.livedata_viewmodel.converter.ListConverter
import com.articles.marcos.livedata_viewmodel.dao.ExerciseDao
import com.articles.marcos.livedata_viewmodel.dao.GenderDao
import com.articles.marcos.livedata_viewmodel.dao.RoutineDao
import com.articles.marcos.livedata_viewmodel.dao.TraineeDao
import com.articles.marcos.livedata_viewmodel.entity.Exercise
import com.articles.marcos.livedata_viewmodel.entity.Gender
import com.articles.marcos.livedata_viewmodel.entity.Routine
import com.articles.marcos.livedata_viewmodel.entity.Trainee

@Database(entities = [Exercise::class, Gender::class, Routine::class, Trainee::class], version = 1)
@TypeConverters(DateTypeConverter::class, ListConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exerciseDao(): ExerciseDao
    abstract fun genderDao(): GenderDao
    abstract fun routineDao(): RoutineDao
    abstract fun traineeDao(): TraineeDao

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null){
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "myDB").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}