package com.articles.marcos.livedata_viewmodel.viewModel

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.articles.marcos.livedata_viewmodel.dao.GenderDao
import com.articles.marcos.livedata_viewmodel.dataBase.AppDatabase
import com.articles.marcos.livedata_viewmodel.dataRepository.Repository
import com.articles.marcos.livedata_viewmodel.entity.Gender
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainViewModel(private var repository: Repository) : ViewModel() {
    var genders: MutableLiveData<List<Gender>>? = MutableLiveData()

    init {
        repository.insertTestGenders()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{genders?.value = it}
    }

    class ViewModelFactory(private var repository: Repository): ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }

    }
}

