package com.appynitty.cavistacodecallengeapp.home.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;

/**
 * Created by Ayan Dey on 31/10/20.
 */
public  class HomeInOutModel extends BaseObservable implements Parcelable {
    private String inTime;
    private String outTime;

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String  date;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.inTime);
        dest.writeString(this.outTime);
        dest.writeString(this.date);
    }

    public HomeInOutModel() {
    }

    protected HomeInOutModel(Parcel in) {
        this.inTime = in.readString();
        this.outTime = in.readString();
        this.date = in.readString();
    }

    public static final Creator<HomeInOutModel> CREATOR = new Creator<HomeInOutModel>() {
        @Override
        public HomeInOutModel createFromParcel(Parcel source) {
            return new HomeInOutModel(source);
        }

        @Override
        public HomeInOutModel[] newArray(int size) {
            return new HomeInOutModel[size];
        }
    };
}
