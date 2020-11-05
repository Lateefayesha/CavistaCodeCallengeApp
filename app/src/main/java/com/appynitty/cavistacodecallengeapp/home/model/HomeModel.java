package com.appynitty.cavistacodecallengeapp.home.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.appynitty.cavistacodecallengeapp.BR;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ayan Dey on 31/10/20.
 */
public class    HomeModel extends BaseObservable implements Parcelable {


    public String id;
    public String title;
    public String description;
    public String dateTime;
    public String type;
    public boolean isAnimated;
    public int width;
    public int height;
    public double size;
    public int view;
    public double bandwidth;
    public String vote;
    public boolean isFavorite;
    public boolean isNsfw;
    public String section;
    public String accountId;
    public String accountUrl;
    public int adType;
    public String adUrl;
    public String topic;
    public String topicId;
    public String link;
    public int commentCount;
    public int favoriteCount;
    public int up;
    public int down;
    public int points;
    public int score;
    public boolean isAlbum;
    public boolean inGallery;
    public boolean isHasSound;
    public boolean isInMostViral;
    public boolean isAd;
    public List<Tags> tagsList;
    public AdConfiq addConfiq;
    public List<ImagesModel> imagesModelList;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

 @Bindable
    public String getTitle() {
            return title;
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

    public boolean isAnimated() {
        return isAnimated;
    }

    public void isAnimated(boolean animated) {
        isAnimated = animated;
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

    public void setSize(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getView() {
        return view;
    }

    public void setBandwidth(double bandwidth) {
        this.bandwidth = bandwidth;
    }

    public double getBandwidth() {
        return bandwidth;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getVote() {
        return vote;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void isFavorite(boolean isFavorite) {

        this.isFavorite = isFavorite;
    }

    public boolean isNsfw() {
        return isNsfw;
    }

    public void isNsfw(boolean isNsfw) {

        this.isNsfw = isNsfw;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSection() {
        return section;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountUrl(String accountUrl) {
        this.accountUrl = accountUrl;
    }

    public String getAccountUrl() {
        return accountUrl;
    }

    public void setAdType(int adType) {
        this.adType = adType;
    }

    public int getAdType() {
        return adType;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setLink(String link) {
        this.link = link;
        notifyPropertyChanged(BR.link);
    }

@Bindable
    public String getLink() {
        return link;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getUp() {
        return up;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public int getDown() {
        return down;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public boolean isAlbum() {
        return isAlbum;
    }

    public void isAlbum(boolean isAlbum) {

        this.isAlbum = isAlbum;
    }

    public boolean isInGallery() {
        return inGallery;
    }

    public void isInGallery(boolean inGallery) {
        this.inGallery = inGallery;
    }

    public boolean isHasSound() {
        return isHasSound;
    }

    public void isHasSound(boolean isHasSound) {
        this.isHasSound = isHasSound;
    }

    public boolean isInMostViral() {
        return isInMostViral;
    }

    public void isMostViral(boolean IsInMostViral) {
        isInMostViral = IsInMostViral;
    }

    public boolean isAd() {
        return isAd;
    }

    public void isAd(boolean isAd) {
        this.isAd = isAd;
    }

    public void setTagsList(List<Tags> tagsList) {
        this.tagsList = tagsList;
    }

    public List<Tags> getTagsList() {
        return tagsList;
    }

    public void setAddConfiq(AdConfiq addConfiq) {
        this.addConfiq = addConfiq;
    }

    public AdConfiq getAddConfiq() {
        return addConfiq;
    }

    public HomeModel() {
    }

    public void setImages(List<ImagesModel> images) {
        this.imagesModelList = images;
    }

    public List<ImagesModel> getImages() {
        return imagesModelList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.dateTime);
        dest.writeString(this.type);
        dest.writeByte(this.isAnimated ? (byte) 1 : (byte) 0);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeDouble(this.size);
        dest.writeInt(this.view);
        dest.writeDouble(this.bandwidth);
        dest.writeString(this.vote);
        dest.writeByte(this.isFavorite ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isNsfw ? (byte) 1 : (byte) 0);
        dest.writeString(this.section);
        dest.writeString(this.accountId);
        dest.writeString(this.accountUrl);
        dest.writeInt(this.adType);
        dest.writeString(this.adUrl);
        dest.writeString(this.topic);
        dest.writeString(this.topicId);
        dest.writeString(this.link);
        dest.writeInt(this.commentCount);
        dest.writeInt(this.favoriteCount);
        dest.writeInt(this.up);
        dest.writeInt(this.down);
        dest.writeInt(this.points);
        dest.writeInt(this.score);
        dest.writeByte(this.isAlbum ? (byte) 1 : (byte) 0);
        dest.writeByte(this.inGallery ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isHasSound ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isInMostViral ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isAd ? (byte) 1 : (byte) 0);
        dest.writeList(this.tagsList);
        dest.writeParcelable(this.addConfiq, flags);
        dest.writeList(this.imagesModelList);
    }

    protected HomeModel(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.description = in.readString();
        this.dateTime = in.readString();
        this.type = in.readString();
        this.isAnimated = in.readByte() != 0;
        this.width = in.readInt();
        this.height = in.readInt();
        this.size = in.readDouble();
        this.view = in.readInt();
        this.bandwidth = in.readDouble();
        this.vote = in.readString();
        this.isFavorite = in.readByte() != 0;
        this.isNsfw = in.readByte() != 0;
        this.section = in.readString();
        this.accountId = in.readString();
        this.accountUrl = in.readString();
        this.adType = in.readInt();
        this.adUrl = in.readString();
        this.topic = in.readString();
        this.topicId = in.readString();
        this.link = in.readString();
        this.commentCount = in.readInt();
        this.favoriteCount = in.readInt();
        this.up = in.readInt();
        this.down = in.readInt();
        this.points = in.readInt();
        this.score = in.readInt();
        this.isAlbum = in.readByte() != 0;
        this.inGallery = in.readByte() != 0;
        this.isHasSound = in.readByte() != 0;
        this.isInMostViral = in.readByte() != 0;
        this.isAd = in.readByte() != 0;
        this.tagsList = new ArrayList<Tags>();
        in.readList(this.tagsList, Tags.class.getClassLoader());
        this.addConfiq = in.readParcelable(AdConfiq.class.getClassLoader());
        this.imagesModelList = new ArrayList<ImagesModel>();
        in.readList(this.imagesModelList, ImagesModel.class.getClassLoader());
    }

    public static final Creator<HomeModel> CREATOR = new Creator<HomeModel>() {
        @Override
        public HomeModel createFromParcel(Parcel source) {
            return new HomeModel(source);
        }

        @Override
        public HomeModel[] newArray(int size) {
            return new HomeModel[size];
        }
    };
}
