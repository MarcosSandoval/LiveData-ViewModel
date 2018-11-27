package com.articles.marcos.livedata_viewmodel.dataRepository

import com.articles.marcos.livedata_viewmodel.dataBase.AppDatabase
import com.articles.marcos.livedata_viewmodel.entity.Gender
import io.reactivex.Observable

class Repository(private val db: AppDatabase?) {
    private var genderDao = db?.genderDao()

    fun getGenders(): List<Gender>? {
        return genderDao?.getGenders()
    }

    fun insertTestGenders(): Observable<List<Gender>>{
        return Observable.fromCallable{
            with(genderDao){
                this?.insertGender(Gender(name = "Male"))
                this?.insertGender(Gender(name = "Female"))
                this?.getGenders()
            }
        }
    }
}