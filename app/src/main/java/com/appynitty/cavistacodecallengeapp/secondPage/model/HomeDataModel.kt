package com.appynitty.cavistacodecallengeapp.secondPage.model

import android.os.Parcel
import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Ayan Dey on 4/11/20.
 */
@Entity(tableName = "home_data_table")
data class HomeDataModel(
    @PrimaryKey (autoGenerate = true) var id: Int,

    @ColumnInfo(name = "comments") var comments: String?,

    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "links") var link: String?
): BaseObservable(), Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )



    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(comments)
        parcel.writeString(title)
        parcel.writeString(link)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HomeDataModel> {
        override fun createFromParcel(parcel: Parcel): HomeDataModel {
            return HomeDataModel(parcel)
        }

        override fun newArray(size: Int): Array<HomeDataModel?> {
            return arrayOfNulls(size)
        }
    }




}