package com.articles.marcos.livedata_viewmodel.entity

import android.arch.persistence.room.*

@Entity(indices = [(Index("name")), (Index("age"))],
        foreignKeys = [(ForeignKey(entity = Gender::class, parentColumns = ["id"], childColumns = ["gender"]))])
data class Trainee(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val name: String,
        val age: Int,
        val gender: Int?,
        @Embedded
        val routine: Routine)