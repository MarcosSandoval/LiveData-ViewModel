package com.articles.marcos.livedata_viewmodel.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity
data class Gender(
        @PrimaryKey(autoGenerate = true)
        @NonNull
        val id: Int? = null,
        val name: String)