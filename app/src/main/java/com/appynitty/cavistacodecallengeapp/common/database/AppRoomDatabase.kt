package com.appynitty.cavistacodecallengeapp.common.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.appynitty.cavistacodecallengeapp.common.CommonConstant
import com.appynitty.cavistacodecallengeapp.secondPage.model.HomeDao
import com.appynitty.cavistacodecallengeapp.secondPage.model.HomeDataModel

/**
 * Created by Ayan Dey on 4/11/20.
 */
@Database(entities = [HomeDataModel::class], version = 1, exportSchema = false)
public abstract class AppRoomDatabase :RoomDatabase() {



    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

     public   fun getDatabase(context: Context): AppRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppRoomDatabase::class.java,
                    CommonConstant.app_db
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

    abstract fun homeDao():HomeDao
}