package com.appynitty.cavistacodecallengeapp.secondPage.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by Ayan Dey on 4/11/20.
 */
@Dao
 interface HomeDao {

    @Query("SELECT * FROM home_data_table ")
    fun getAllItems(): LiveData<List<HomeDataModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(word: HomeDataModel)

    @Query("DELETE FROM home_data_table")
     fun deleteAll()
}