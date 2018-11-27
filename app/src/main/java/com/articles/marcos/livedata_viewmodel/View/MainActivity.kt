package com.articles.marcos.livedata_viewmodel.View

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.articles.marcos.livedata_viewmodel.R
import com.articles.marcos.livedata_viewmodel.dao.GenderDao
import com.articles.marcos.livedata_viewmodel.dataBase.AppDatabase
import com.articles.marcos.livedata_viewmodel.dataRepository.Repository
import com.articles.marcos.livedata_viewmodel.entity.Gender
import com.articles.marcos.livedata_viewmodel.viewModel.MainViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var db: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = AppDatabase.getAppDataBase(context = this)

        val model = ViewModelProviders.of(this, MainViewModel.ViewModelFactory(Repository(db))).get(MainViewModel::class.java)

        model.genders?.observe(this, Observer {
            var finalString = ""
            it?.map { finalString+= it.name+" - " }
            tv_message.text = finalString
        })
    }
}
