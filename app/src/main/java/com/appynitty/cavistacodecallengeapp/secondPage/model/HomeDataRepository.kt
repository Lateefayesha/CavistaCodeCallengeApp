package com.appynitty.cavistacodecallengeapp.secondPage.model

import androidx.lifecycle.LiveData

/**
 * Created by Ayan Dey on 4/11/20.
 */
class HomeDataRepository(private val homeDao: HomeDao) {

    val allHomeDataModel: LiveData<List<HomeDataModel>> = homeDao.getAllItems()

     fun insert(word: HomeDataModel) {
        homeDao.insert(word)
    }
}