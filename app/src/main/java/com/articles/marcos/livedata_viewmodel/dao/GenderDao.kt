package com.articles.marcos.livedata_viewmodel.dao

import android.arch.persistence.room.*
import com.articles.marcos.livedata_viewmodel.entity.Gender

@Dao
interface GenderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGender(gender: Gender)

    @Update
    fun updateGender(gender: Gender)

    @Delete
    fun deleteGender(gender: Gender)

    @Query("SELECT * FROM Gender WHERE name == :name")
    fun getGenderByName(name: String): List<Gender>

    @Query("SELECT * FROM Gender")
    fun getGenders(): List<Gender>
}