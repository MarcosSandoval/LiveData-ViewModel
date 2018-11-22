package com.articles.marcos.livedata_viewmodel.viewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.articles.marcos.livedata_viewmodel.dao.GenderDao
import com.articles.marcos.livedata_viewmodel.dataBase.AppDatabase
import com.articles.marcos.livedata_viewmodel.entity.Gender
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainViewModel : ViewModel() {
    var genders: MutableLiveData<List<Gender>>? = null

    init {

    }

    fun loadGenders(database: AppDatabase?){
        Observable.fromCallable{
            if(genders == null){
                genders = MutableLiveData()
                insertGender(database)
            }
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }


    fun insertGender(database: AppDatabase?){

        Observable.fromCallable{

            with(database?.genderDao()){
                this?.insertGender(Gender(name = "Male"))
                this?.insertGender(Gender(name = "Female"))
                this?.getGenders()
            }

        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{genders?.value = it}
    }
}