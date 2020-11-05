package com.appynitty.cavistacodecallengeapp.home.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;

/**
 * Created by Ayan Dey on 2/11/20.
 */
public  class Tags extends BaseObservable implements Parcelable {
    public String name;
    public String displayName;
    public int followers;
    public String backgroundHash;
    public String thumbnailHash;
    public boolean isPromoted;
    public String description;
    public String logoHash;
    public String logoDestinationUrl;
    public boolean iswhitelisted;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDisplayName(String displayName) {

        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowers() {
        return followers;
    }

    public void setBackgroundHash(String backgroundHash) {
        this.backgroundHash = backgroundHash;
    }

    public String getBackgroundHash() {
        return backgroundHash;
    }

    public void setThumbnailHash(String thumbnailHash) {
        this.thumbnailHash = thumbnailHash;
    }

    public String getThumbnailHash() {
        return thumbnailHash;
    }

    public boolean isPromoted() {
        return isPromoted;
    }

    public void isPromoted(boolean isPromoted) {

        this.isPromoted = isPromoted;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setLogoHash(String logoHash) {
        this.logoHash = logoHash;
    }

    public String getLogoHash() {
        return logoHash;
    }

    public void setLogoDestinationUrl(String logoDestinationUrl) {
        this.logoDestinationUrl = logoDestinationUrl;
    }

    public String getLogoDestinationUrl() {
        return logoDestinationUrl;
    }

    public boolean isIswhitelisted() {
        return iswhitelisted;
    }

    public void isWhiteListed(boolean iswhitelisted) {

        this.iswhitelisted = iswhitelisted;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.displayName);
        dest.writeInt(this.followers);
        dest.writeString(this.backgroundHash);
        dest.writeString(this.thumbnailHash);
        dest.writeByte(this.isPromoted ? (byte) 1 : (byte) 0);
        dest.writeString(this.description);
        dest.writeString(this.logoHash);
        dest.writeString(this.logoDestinationUrl);
        dest.writeByte(this.iswhitelisted ? (byte) 1 : (byte) 0);
    }

    public Tags() {
    }

    protected Tags(Parcel in) {
        this.name = in.readString();
        this.displayName = in.readString();
        this.followers = in.readInt();
        this.backgroundHash = in.readString();
        this.thumbnailHash = in.readString();
        this.isPromoted = in.readByte() != 0;
        this.description = in.readString();
        this.logoHash = in.readString();
        this.logoDestinationUrl = in.readString();
        this.iswhitelisted = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Tags> CREATOR = new Parcelable.Creator<Tags>() {
        @Override
        public Tags createFromParcel(Parcel source) {
            return new Tags(source);
        }

        @Override
        public Tags[] newArray(int size) {
            return new Tags[size];
        }
    };
}
