package com.appynitty.cavistacodecallengeapp.secondPage.viewModel

import android.app.Application
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.appynitty.cavistacodecallengeapp.R
import com.appynitty.cavistacodecallengeapp.common.database.AppRoomDatabase
import com.appynitty.cavistacodecallengeapp.home.model.HomeModel
import com.appynitty.cavistacodecallengeapp.secondPage.model.HomeDataModel
import com.appynitty.cavistacodecallengeapp.secondPage.model.HomeDataRepository
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Ayan Dey on 4/11/20.
 */
class SecondViewModel(application: Application) : AndroidViewModel(application) {


    var comments: ObservableField<String>? = null
    var isProgress: ObservableField<Boolean>? = null
        var urlImage: ObservableField<String>? = null
    var link: ObservableField<String>? = null

    lateinit var dataModel: HomeDataModel
    private lateinit var repository: HomeDataRepository
    private lateinit var allModel: LiveData<List<HomeDataModel>>
    private val wordsDao = AppRoomDatabase.getDatabase(application.applicationContext).homeDao()


    public fun onSubmitClicked() {
        Log.d("SeconViewModel", "onSubmitClicked: ")
        Log.d("SeconViewModel", "dataModel: " + Gson().toJson(dataModel))
        isProgress?.set(true)
        dataModel?.let { insert(it) }


    }

    fun setModel(homeModel: HomeModel) {
dataModel=HomeDataModel(0,"","","")
        link?.set(homeModel.getLink())
        dataModel.title = homeModel.getTitle()
        dataModel.link = homeModel.getLink()
        urlImage?.set(homeModel.getLink())
        dataModel.comments = comments?.get().toString()
        repository = HomeDataRepository(wordsDao)
        allModel = repository.allHomeDataModel
        Log.d("SetModel", "setModel: " + Gson().toJson(homeModel))


    }


    fun insert(word: HomeDataModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(word)
        isProgress?.set(false)

    }


//    @BindingAdapter("imagePass")
//    fun loadSecondImage(view: ImageView?, imageUrl: ObservableField<String>) :Unit{
//        Log.d("SecondViewModel.TAG", "loadImage: ${imageUrl.get()}")
//        Picasso.get()
//            .load(imageUrl.get())
//            .placeholder(R.drawable.place_holder)
//            .into(view)
//    }

    companion object {
        @JvmStatic
        @BindingAdapter("imagePass")
        fun loadSecondImage(view: ImageView?, imageUrl: ObservableField<String>?): Unit {
            Log.d("SecondViewModel.TAG", "loadImage: ${imageUrl?.get()}")
            Picasso.get()
                .load(imageUrl?.get())
                .placeholder(R.drawable.place_holder)
                .into(view)
        }
    }


}