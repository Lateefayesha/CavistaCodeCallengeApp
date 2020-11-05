package com.appynitty.cavistacodecallengeapp.home.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ayan Dey on 2/11/20.
 */
public class AdConfiq  extends BaseObservable implements Parcelable {

    public boolean isShowsAds;
//    SafeFlags,
//    HighRiskFlags,
//    UnsafeFlags,
//    WallUnsafeFlags

    public void setShowsAds(boolean showsAds) {
        isShowsAds = showsAds;
    }

    public List<String> getSafeFlags() {
        return SafeFlags;
    }

    public void setSafeFlags(List<String> safeFlags) {
        SafeFlags = safeFlags;
    }

    public List<String> getHighRiskFlags() {
        return HighRiskFlags;
    }

    public void setHighRiskFlags(List<String> highRiskFlags) {
        HighRiskFlags = highRiskFlags;
    }

    public List<String> getUnsafeFlags() {
        return UnsafeFlags;
    }

    public void setUnsafeFlags(List<String> unsafeFlags) {
        UnsafeFlags = unsafeFlags;
    }

    public List<String> getWallUnsafeFlags() {
        return WallUnsafeFlags;
    }

    public void setWallUnsafeFlags(List<String> wallUnsafeFlags) {
        WallUnsafeFlags = wallUnsafeFlags;
    }

    public static Creator<AdConfiq> getCREATOR() {
        return CREATOR;
    }

    public List<String> SafeFlags= new ArrayList<>();
    public List<String> HighRiskFlags= new ArrayList<>();
    public List<String> UnsafeFlags= new ArrayList<>();
    public List<String> WallUnsafeFlags= new ArrayList<>();

    public boolean isShowsAds() {
        return isShowsAds;
    }

    public void isShowsAds(boolean isShowsAds) {

        this.isShowsAds = isShowsAds;
    }

    public AdConfiq() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.isShowsAds ? (byte) 1 : (byte) 0);
        dest.writeStringList(this.SafeFlags);
        dest.writeStringList(this.HighRiskFlags);
        dest.writeStringList(this.UnsafeFlags);
        dest.writeStringList(this.WallUnsafeFlags);
    }

    protected AdConfiq(Parcel in) {
        this.isShowsAds = in.readByte() != 0;
        this.SafeFlags = in.createStringArrayList();
        this.HighRiskFlags = in.createStringArrayList();
        this.UnsafeFlags = in.createStringArrayList();
        this.WallUnsafeFlags = in.createStringArrayList();
    }

    public static final Creator<AdConfiq> CREATOR = new Creator<AdConfiq>() {
        @Override
        public AdConfiq createFromParcel(Parcel source) {
            return new AdConfiq(source);
        }

        @Override
        public AdConfiq[] newArray(int size) {
            return new AdConfiq[size];
        }
    };
}
