package com.articles.marcos.livedata_viewmodel.converter

import android.arch.persistence.room.TypeConverter
import com.articles.marcos.livedata_viewmodel.entity.Exercise
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class ListConverter {

    var gson = Gson()

    @TypeConverter
    fun fromTimestamp(data: String?): List<Exercise>? {

        if (data == null){
            return Collections.emptyList()
        }
        val listType = object : TypeToken<ArrayList<String>>() {}.type
        return gson.fromJson(data, listType)


    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<Exercise>?): String? {
        return gson.toJson(someObjects)
    }



}