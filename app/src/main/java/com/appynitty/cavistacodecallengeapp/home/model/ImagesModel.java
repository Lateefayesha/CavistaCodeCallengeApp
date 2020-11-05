package com.appynitty.cavistacodecallengeapp.home.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ayan Dey on 3/11/20.
 */
public class ImagesModel extends BaseObservable implements Parcelable {
    public String id;
    public String description;
    public String dateTime;
    public String type;
    public int width;
    public int height;
    public int size;
    public int view;
    public int bandwidth;
    public String vote;
    public String nsfw;
    public String section;
    public String accountUrl;
    public String accountId;
    public int addType;
    public String edited;
    public String link;
    public String commentCount;
    public String favoriteCount;
    public String ups;
    public String downs;
    public String points;
    public String score;
    public List<Tags> tagsList;
    public boolean inGallery;
    public boolean isHasSound;
    public boolean isMostViral;
    public boolean isAdd;
    public boolean isFavorite;
    public boolean isAnimated;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getView() {
        return view;
    }

    public void setBandwidth(int bandwidth) {
        this.bandwidth = bandwidth;
    }

    public int getBandwidth() {
        return bandwidth;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getVote() {
        return vote;
    }

    public void setNsfw(String nsfw) {
        this.nsfw = nsfw;
    }

    public String getNsfw() {
        return nsfw;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSection() {
        return section;
    }

    public void setAccountUrl(String accountUrl) {
        this.accountUrl = accountUrl;
    }

    public String getAccountUrl() {
        return accountUrl;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAddType(int addType) {
        this.addType = addType;
    }

    public int getAddType() {
        return addType;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getEdited() {
        return edited;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setFavoriteCount(String favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public String getFavoriteCount() {
        return favoriteCount;
    }

    public void setUps(String ups) {
        this.ups = ups;
    }

    public String getUps() {
        return ups;
    }

    public void setDowns(String downs) {
        this.downs = downs;
    }

    public String getDowns() {
        return downs;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getPoints() {
        return points;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScore() {
        return score;
    }

    public void setTagsList(List<Tags> tagsList) {
        this.tagsList = tagsList;
    }

    public List<Tags> getTagsList() {
        return tagsList;
    }

    public boolean isInGallery() {
        return inGallery;
    }

    public void setInGallery(boolean inGallery) {

        this.inGallery = inGallery;
    }


    public boolean isHasSound() {
        return isHasSound;
    }

    public void setIsHasSound(boolean isHasSound) {

        this.isHasSound = isHasSound;
    }
    public boolean isMostViral() {
        return isMostViral;
    }

    public void setIsMostViral(boolean isMostViral) {

        this.isMostViral = isMostViral;
    }

    public boolean isAdd() {
        return isAdd;
    }

    public void setIsAdd(boolean isAdd) {

        this.isAdd = isAdd;
    }


    public boolean isFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {

        this.isFavorite = isFavorite;
    }
        public boolean isAnimated() {
        return isAnimated;
    }

    public void setIsAnimated(boolean isAnimated) {
        this.isAnimated = isAnimated;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.description);
        dest.writeString(this.dateTime);
        dest.writeString(this.type);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeInt(this.size);
        dest.writeInt(this.view);
        dest.writeInt(this.bandwidth);
        dest.writeString(this.vote);
        dest.writeString(this.nsfw);
        dest.writeString(this.section);
        dest.writeString(this.accountUrl);
        dest.writeString(this.accountId);
        dest.writeInt(this.addType);
        dest.writeString(this.edited);
        dest.writeString(this.link);
        dest.writeString(this.commentCount);
        dest.writeString(this.favoriteCount);
        dest.writeString(this.ups);
        dest.writeString(this.downs);
        dest.writeString(this.points);
        dest.writeString(this.score);
        dest.writeList(this.tagsList);
        dest.writeByte(this.inGallery ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isHasSound ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isMostViral ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isAdd ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isFavorite ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isAnimated ? (byte) 1 : (byte) 0);
    }

    public ImagesModel() {
    }

    protected ImagesModel(Parcel in) {
        this.id = in.readString();
        this.description = in.readString();
        this.dateTime = in.readString();
        this.type = in.readString();
        this.width = in.readInt();
        this.height = in.readInt();
        this.size = in.readInt();
        this.view = in.readInt();
        this.bandwidth = in.readInt();
        this.vote = in.readString();
        this.nsfw = in.readString();
        this.section = in.readString();
        this.accountUrl = in.readString();
        this.accountId = in.readString();
        this.addType = in.readInt();
        this.edited = in.readString();
        this.link = in.readString();
        this.commentCount = in.readString();
        this.favoriteCount = in.readString();
        this.ups = in.readString();
        this.downs = in.readString();
        this.points = in.readString();
        this.score = in.readString();
        this.tagsList = new ArrayList<Tags>();
        in.readList(this.tagsList, Tags.class.getClassLoader());
        this.inGallery = in.readByte() != 0;
        this.isHasSound = in.readByte() != 0;
        this.isMostViral = in.readByte() != 0;
        this.isAdd = in.readByte() != 0;
        this.isFavorite = in.readByte() != 0;
        this.isAnimated = in.readByte() != 0;
    }

    public static final Parcelable.Creator<ImagesModel> CREATOR = new Parcelable.Creator<ImagesModel>() {
        @Override
        public ImagesModel createFromParcel(Parcel source) {
            return new ImagesModel(source);
        }

        @Override
        public ImagesModel[] newArray(int size) {
            return new ImagesModel[size];
        }
    };
}
