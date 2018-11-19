package com.articles.marcos.livedata_viewmodel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.articles.marcos.livedata_viewmodel.dao.GenderDao
import com.articles.marcos.livedata_viewmodel.dataBase.AppDatabase
import com.articles.marcos.livedata_viewmodel.entity.Gender
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var db: AppDatabase? = null
    private var genderDao: GenderDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = AppDatabase.getAppDataBase(context = this)

        Observable.fromCallable({
            db = AppDatabase.getAppDataBase(context = this)
            genderDao = db?.genderDao()

            var gender1 = Gender(name = "Male")
            var gender2 = Gender(name = "Female")

            with(genderDao){
                this?.insertGender(gender1)
                this?.insertGender(gender2)
            }
            db?.genderDao()?.getGenders()
        }).doOnNext({ list ->
            var finalString = ""
            list?.map { finalString+= it.name+" - " }
            tv_message.text = finalString

        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }
}
