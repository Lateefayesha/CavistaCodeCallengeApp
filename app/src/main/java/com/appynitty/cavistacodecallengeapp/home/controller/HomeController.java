package com.appynitty.cavistacodecallengeapp.home.controller;

import android.text.TextUtils;

import com.appynitty.cavistacodecallengeapp.home.model.AdConfiq;
import com.appynitty.cavistacodecallengeapp.home.model.HomeModel;
import com.appynitty.cavistacodecallengeapp.home.model.ImagesModel;
import com.appynitty.cavistacodecallengeapp.home.model.Tags;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * Created by Ayan Dey on 31/10/20.
 */
public class HomeController {
    List<HomeModel> homeModelList = null;
    private static final String TAG = "HomeController";

    public HomeController() {

    }




    public List<HomeModel> getSearchImageModel(String res) {
        if (res != null && !TextUtils.isEmpty(res)) {
            homeModelList = new ArrayList<>();
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(res);
                if (jsonObject.has("data")) {
                    JSONArray jsonArrayData = jsonObject.getJSONArray("data");
                    for (int i = 0; i < jsonArrayData.length(); i++) {
                        JSONObject jsonObjectSingleImage = jsonArrayData.getJSONObject(i);
                        homeModelList.add(getSingleImageObject(jsonObjectSingleImage));



                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Timber.d("getSearchImageModel: %s", e.getMessage());
            }


        }
        Timber.d("homeModelList: %s", new Gson().toJson(homeModelList));
        return homeModelList;
    }




    private HomeModel getSingleImageObject(JSONObject jsonObject) {
        HomeModel model = new HomeModel();
        try {
            if(jsonObject.has("id"))
             model.setId(jsonObject.getString("id"));

            if(jsonObject.has("title"))
            model.setTitle(jsonObject.getString("title"));


            if(jsonObject.has("description"))
            model.setDescription(jsonObject.getString("description"));

            if(jsonObject.has("datetime"))
            model.setDateTime(jsonObject.getString("datetime"));

            if(jsonObject.has("type"))
            model.setType(jsonObject.getString("type"));

            if(jsonObject.has("animated"))
            model.isAnimated(jsonObject.getBoolean("animated"));

            if(jsonObject.has("width"))
            model.setWidth(jsonObject.getInt("width"));

            if(jsonObject.has("height"))
            model.setHeight(jsonObject.getInt("height"));

            if(jsonObject.has("size"))
            model.setSize(jsonObject.getDouble("size"));

            if(jsonObject.has("views"))
            model.setView(jsonObject.getInt("views"));

            if(jsonObject.has("bandwidth"))
            model.setBandwidth(jsonObject.getDouble("bandwidth"));

            if(jsonObject.has("vote"))
            model.setVote(jsonObject.getString("vote"));

            if(jsonObject.has("favorite"))
            model.isFavorite(jsonObject.getBoolean("favorite"));

            if(jsonObject.has("nsfw"))
            model.isNsfw(jsonObject.getBoolean("nsfw"));

            if(jsonObject.has("section"))
            model.setSection(jsonObject.getString("section"));

            if(jsonObject.has("account_id"))
            model.setAccountId(jsonObject.getString("account_id"));

            if(jsonObject.has("account_url"))
            model.setAccountUrl(jsonObject.getString("account_url"));

            if(jsonObject.has("is_ad"))
            model.isAd(jsonObject.getBoolean("is_ad"));

            if(jsonObject.has("in_most_viral"))
            model.isMostViral(jsonObject.getBoolean("in_most_viral"));

            if(jsonObject.has("has_sound"))
            model.isHasSound(jsonObject.getBoolean("has_sound"));

            if(jsonObject.has("ad_type"))
            model.setAdType(jsonObject.getInt("ad_type"));

            if(jsonObject.has("ad_url"))
            model.setAdUrl(jsonObject.getString("ad_url"));

            if(jsonObject.has("in_gallery"))
            model.isInGallery(jsonObject.getBoolean("in_gallery"));

            if(jsonObject.has("topic"))
            model.setTopic(jsonObject.getString("topic"));


            if(jsonObject.has("topic_id"))
            model.setTopicId(jsonObject.getString("topic_id"));

            if(jsonObject.has("link"))
            model.setLink(jsonObject.getString("link"));


            if(jsonObject.has("comment_count"))
            model.setCommentCount(jsonObject.getInt("comment_count"));

            if(jsonObject.has("favorite_count"))
            model.setFavoriteCount(jsonObject.getInt("favorite_count"));

            if(jsonObject.has("ups"))
            model.setUp(jsonObject.getInt("ups"));

            if(jsonObject.has("downs"))
            model.setDown(jsonObject.getInt("downs"));

            if(jsonObject.has("points"))
            model.setPoints(jsonObject.getInt("points"));


            if(jsonObject.has("score"))
            model.setScore(jsonObject.getInt("score"));


            if(jsonObject.has("is_album"))
            model.isAlbum(jsonObject.getBoolean("is_album"));

            if (jsonObject.has("tags")) {
                model.setTagsList(getJsonObjectTags(jsonObject));
            }
            if (jsonObject.has("ad_config")) {
                model.setAddConfiq(getJsonObjectAddConfig(jsonObject));
            }

            if(jsonObject.has("images")){
                model.setImages(getJsonObjectImages(jsonObject));

            }


        } catch (JSONException e) {
            e.printStackTrace();
            Timber.d("getSingleImageObject: %s", e.getMessage());

        }

        return model;

    }

    private List<ImagesModel> getJsonObjectImages(JSONObject jsonObject) {
        List<ImagesModel> lisImages = new ArrayList();
        try {
            if(jsonObject.has("images")) {
                if (jsonObject.get("images") instanceof JSONArray) {
                    JSONArray jsonObjectImages = jsonObject.getJSONArray("images");
                    for (int i = 0; i < jsonObjectImages.length(); i++) {
                        JSONObject jsonObjectSingleImages = jsonObjectImages.getJSONObject(i);
                        lisImages.add(getSingleImagesObject(jsonObjectSingleImages));
                    }
                } else {
                    lisImages.add(getSingleImagesObject(jsonObject.getJSONObject("images")));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return lisImages;
    }



//     "ad_config":{
//        "safeFlags":[
//        "in_gallery"
//            ],
//        "highRiskFlags":[
//
//            ],
//        "unsafeFlags":[
//        "sixth_mod_unsafe",
//                "under_10"
//            ],
//        "wallUnsafeFlags":[
//
//            ],
//        "showsAds":false
//    },

    enum AddConfiqFlag {
        SafeFlags,
        HighRiskFlags,
        UnsafeFlags,
        WallUnsafeFlags
    }

    private AdConfiq getJsonObjectAddConfig(JSONObject jsonObject) {
        AdConfiq confiq = new AdConfiq();
        try {
            if (jsonObject.has("showsAds"))
                confiq.isShowsAds(jsonObject.getBoolean("showsAds"));

            if (jsonObject.has("safeFlags")) {
                JSONArray jsonArray = jsonObject.getJSONArray("safeFlags");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObjectSafeFlags = jsonArray.getJSONObject(i);
                    confiq.setSafeFlags(getAddConfiqFlags(AddConfiqFlag.SafeFlags, jsonObjectSafeFlags));
                }

            }


            if (jsonObject.has("highRiskFlags")) {
                JSONArray jsonArray = jsonObject.getJSONArray("highRiskFlags");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObjectHighRiskFlags = jsonArray.getJSONObject(i);
                    confiq.setHighRiskFlags(getAddConfiqFlags(AddConfiqFlag.HighRiskFlags, jsonObjectHighRiskFlags));

                }

            }

            if (jsonObject.has("unsafeFlags")) {
                JSONArray jsonArray = jsonObject.getJSONArray("unsafeFlags");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObjectUnsafeFlags = jsonArray.getJSONObject(i);
                    confiq.setUnsafeFlags(getAddConfiqFlags(AddConfiqFlag.UnsafeFlags, jsonObjectUnsafeFlags));


                }

            }

            if (jsonObject.has("wallUnsafeFlags")) {
                JSONArray jsonArray = jsonObject.getJSONArray("wallUnsafeFlags");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObjectWallUnsafeFlags = jsonArray.getJSONObject(i);
                    confiq.setWallUnsafeFlags(getAddConfiqFlags(AddConfiqFlag.WallUnsafeFlags, jsonObjectWallUnsafeFlags));


                }

            }


        } catch (JSONException e) {
            e.printStackTrace();
            Timber.d("getJsonObjectAddConfig: %s", e.getMessage());
        }


        return confiq;
    }

    private    List<String> getAddConfiqFlags(AddConfiqFlag flags, JSONObject jsonObjectFlags) {
        /**
         * Flags.Ordinal return int
         *    SafeFlags =0,
         *         HighRiskFlags=1,
         *         UnsafeFlags=2,
         *         WallUnsafeFlags=3
         *
         */
        List<String> list = new ArrayList();

        switch (flags.ordinal()) {
            case 0:
                    try {
                        if(jsonObjectFlags.has("in_gallery"))
                            list.add(jsonObjectFlags.getString("in_gallery"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                break;

            case 1:
                 list.add("");

            case 3:
                list.add("");

                break;


            case 2:
                    try {
                        if(jsonObjectFlags.has("sixth_mod_unsafe"))
                            list.add(jsonObjectFlags.getString("sixth_mod_unsafe"));

                        if(jsonObjectFlags.has("under_10"))
                            list.add(jsonObjectFlags.getString("under_10"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Timber.d("getAddConfiqFlags: %s", e.getMessage());
                    }


                break;

        }

        return list;
    }

//    {"id":"jEKU7he","title":"Vanilla orchids","description":null,"datetime":1600455957,"cover":"FfuQ80T","cover_width":1536,"cover_height":2048,"account_url":"wetear4","account_id":108783711,"privacy":"hidden","layout":"blog","views":62,"link":"https:\/\/imgur.com\/a\/jEKU7he","ups":1,"downs":0,"points":1,"score":1,"is_album":true,"vote":null,"favorite":false,"nsfw":false,"section":"","comment_count":0,"favorite_count":0,"topic":"No Topic","topic_id":29,"images_count":2,"in_gallery":true,"is_ad":false,"tags":[],"ad_type":0,"ad_url":"","in_most_viral":false,"include_album_ads":false,"images":[{"id":"FfuQ80T","title":null,"description":null,"datetime":1600455941,"type":"image\/jpeg","animated":false,"width":1536,"height":2048,"size":443601,"views":116,"bandwidth":51457716,"vote":null,"favorite":false,"nsfw":null,"section":null,"account_url":null,"account_id":null,"is_ad":false,"in_most_viral":false,"has_sound":false,"tags":[],"ad_type":0,"ad_url":"","edited":"0","in_gallery":false,"link":"https:\/\/i.imgur.com\/FfuQ80T.jpg","comment_count":null,"favorite_count":null,"ups":null,"downs":null,"points":null,"score":null},{"id":"lpZngii","title":null,"description":null,"datetime":1600455939,"type":"image\/jpeg","animated":false,"width":1536,"height":2048,"size":437390,"views":117,"bandwidth":51174630,"vote":null,"favorite":false,"nsfw":null,"section":null,"account_url":null,"account_id":null,"is_ad":false,"in_most_viral":false,"has_sound":false,"tags":[],"ad_type":0,"ad_url":"","edited":"0","in_gallery":false,"link":"https:\/\/i.imgur.com\/lpZngii.jpg","comment_count":null,"favorite_count":null,"ups":null,"downs":null,"points":null,"score":null}],"ad_config":{"safeFlags":["album","in_gallery"],"highRiskFlags":[],"unsafeFlags":["sixth_mod_unsafe","under_10"],"wallUnsafeFlags":[],"showsAds":false}}

    private List<Tags> getJsonObjectTags(JSONObject jsonObject) {
        List<Tags> lisTags = new ArrayList();
        try {
            if(jsonObject.has("tags")) {
                if (jsonObject.get("tags") instanceof JSONArray) {
                    JSONArray jsonObjectTags =  jsonObject.getJSONArray("tags");
                    for (int i = 0; i < jsonObjectTags.length(); i++) {
                        JSONObject jsonObjectSingleTags = jsonObjectTags.getJSONObject(i);
                        lisTags.add(getSingleTagsObject(jsonObjectSingleTags));
                    }
                } else {
                    lisTags.add(getSingleTagsObject(jsonObject.getJSONObject("tags")));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return lisTags;

    }

    //    "name":"dobby",
//            "display_name":"dobby",
//            "followers":53,
//            "total_items":156,
//            "following":false,
//            "is_whitelisted":false,
//            "background_hash":"qaYq4fG",
//            "thumbnail_hash":null,
//            "accent":"51535A",
//            "background_is_animated":false,
//            "thumbnail_is_animated":false,
//            "is_promoted":false,
//            "description":"",
//            "logo_hash":null,
//            "logo_destination_url":null,
//            "description_annotations":{
//
//    }
    private Tags getSingleTagsObject(JSONObject jsonObjectSingleTags) {
        Tags tags = new Tags();

        try {

            if (jsonObjectSingleTags.has("name"))
                tags.setName(jsonObjectSingleTags.getString("name"));

            if (jsonObjectSingleTags.has("display_name"))
                tags.setDisplayName(jsonObjectSingleTags.getString("display_name"));

            if (jsonObjectSingleTags.has("followers"))
                tags.setFollowers(jsonObjectSingleTags.getInt("followers"));

            if (jsonObjectSingleTags.has("is_whitelisted"))
                tags.isWhiteListed(jsonObjectSingleTags.getBoolean("is_whitelisted"));

            if (jsonObjectSingleTags.has("background_hash"))
                tags.setBackgroundHash(jsonObjectSingleTags.getString("background_hash"));

            if (jsonObjectSingleTags.has("thumbnail_hash"))
                tags.setThumbnailHash(jsonObjectSingleTags.getString("thumbnail_hash"));

            if (jsonObjectSingleTags.has("is_promoted"))
                tags.isPromoted(jsonObjectSingleTags.getBoolean("is_promoted"));


            if (jsonObjectSingleTags.has("description"))
                tags.setDescription(jsonObjectSingleTags.getString("description"));

            if (jsonObjectSingleTags.has("logo_hash"))
                tags.setLogoHash(jsonObjectSingleTags.getString("logo_hash"));


            if (jsonObjectSingleTags.has("logo_destination_url"))
                tags.setLogoDestinationUrl(jsonObjectSingleTags.getString("logo_destination_url"));


            if (jsonObjectSingleTags.has("description_annotations")) {
                JSONObject jsonObjectDescriptionAnnotation = jsonObjectSingleTags.getJSONObject("description_annotations");
            }


        } catch (JSONException e) {
            e.printStackTrace();
            Timber.d(e);


        }


        return tags;
    }

//     "images":[
//    {
//        "id":"FfuQ80T",
//            "title":null,
//            "description":null,
//            "datetime":1600455941,
//            "type":"image\/jpeg",
//            "animated":false,
//            "width":1536,
//            "height":2048,
//            "size":443601,
//            "views":116,
//            "bandwidth":51457716,
//            "vote":null,
//            "favorite":false,
//            "nsfw":null,
//            "section":null,
//            "account_url":null,
//            "account_id":null,
//            "is_ad":false,
//            "in_most_viral":false,
//            "has_sound":false,
//            "tags":[
//
//               ],
//        "ad_type":0,
//            "ad_url":"",
//            "edited":"0",
//            "in_gallery":false,
//            "link":"https:\/\/i.imgur.com\/FfuQ80T.jpg",
//            "comment_count":null,
//            "favorite_count":null,
//            "ups":null,
//            "downs":null,
//            "points":null,
//            "score":null
//    },
//    {
//        "id":"lpZngii",
//            "title":null,
//            "description":null,
//            "datetime":1600455939,
//            "type":"image\/jpeg",
//            "animated":false,
//            "width":1536,
//            "height":2048,
//            "size":437390,
//            "views":117,
//            "bandwidth":51174630,
//            "vote":null,
//            "favorite":false,
//            "nsfw":null,
//            "section":null,
//            "account_url":null,
//            "account_id":null,
//            "is_ad":false,
//            "in_most_viral":false,
//            "has_sound":false,
//            "tags":[
//
//               ],
//        "ad_type":0,
//            "ad_url":"",
//            "edited":"0",
//            "in_gallery":false,
//            "link":"https:\/\/i.imgur.com\/lpZngii.jpg",
//            "comment_count":null,
//            "favorite_count":null,
//            "ups":null,
//            "downs":null,
//            "points":null,
//            "score":null
//    }
//         ],

    private ImagesModel getSingleImagesObject(JSONObject imagesJsonObject) {

//
        ImagesModel imagesModel = new ImagesModel();
             try {
                 if(imagesJsonObject.has("id"))
                     imagesModel.setId(imagesJsonObject.getString("id"));


                 if(imagesJsonObject.has("description"))
                     imagesModel.setDescription(imagesJsonObject.getString("description"));


                 if(imagesJsonObject.has("datetime"))
                     imagesModel.setDateTime(imagesJsonObject.getString("datetime"));


                 if(imagesJsonObject.has("type"))
                     imagesModel.setType(imagesJsonObject.getString("type"));


                 if(imagesJsonObject.has("animated"))
                     imagesModel.setIsAnimated(imagesJsonObject.getBoolean("animated"));




                 if(imagesJsonObject.has("width"))
                     imagesModel.setWidth(imagesJsonObject.getInt("width"));

                 if(imagesJsonObject.has("height"))
                     imagesModel.setHeight(imagesJsonObject.getInt("height"));

                 if(imagesJsonObject.has("size"))
                     imagesModel.setSize(imagesJsonObject.getInt("size"));

                 if(imagesJsonObject.has("views"))
                     imagesModel.setView(imagesJsonObject.getInt("views"));

                 if(imagesJsonObject.has("bandwidth"))
                     imagesModel.setBandwidth(imagesJsonObject.getInt("bandwidth"));

                 if(imagesJsonObject.has("vote"))
                     imagesModel.setVote(imagesJsonObject.getString("vote"));

                 if(imagesJsonObject.has("favorite"))
                     imagesModel.setIsFavorite(imagesJsonObject.getBoolean("favorite"));



                 if(imagesJsonObject.has("nsfw"))
                     imagesModel.setNsfw(imagesJsonObject.getString("nsfw"));

                 if(imagesJsonObject.has("section"))
                     imagesModel.setSection(imagesJsonObject.getString("section"));

                 if(imagesJsonObject.has("account_url"))
                     imagesModel.setAccountUrl(imagesJsonObject.getString("account_url"));

                 if(imagesJsonObject.has("account_id"))
                     imagesModel.setAccountId(imagesJsonObject.getString("account_id"));

                 if(imagesJsonObject.has("is_ad"))
                     imagesModel.setIsAdd(imagesJsonObject.getBoolean("is_ad"));

                 if(imagesJsonObject.has("in_most_viral"))
                     imagesModel.setIsMostViral(imagesJsonObject.getBoolean("in_most_viral"));

                 if(imagesJsonObject.has("has_sound"))
                     imagesModel.setIsHasSound(imagesJsonObject.getBoolean("has_sound"));

                 if(imagesJsonObject.has("ad_type"))
                     imagesModel.setAddType(imagesJsonObject.getInt("ad_type"));

                 if(imagesJsonObject.has("edited"))
                     imagesModel.setEdited(imagesJsonObject.getString("edited"));

                 if(imagesJsonObject.has("in_gallery"))
                     imagesModel.setInGallery(imagesJsonObject.getBoolean("in_gallery"));

                 if(imagesJsonObject.has("link"))
                     imagesModel.setLink(imagesJsonObject.getString("link"));

                 if(imagesJsonObject.has("comment_count"))
                     imagesModel.setCommentCount(imagesJsonObject.getString("comment_count"));

                 if(imagesJsonObject.has("favorite_count"))
                     imagesModel.setFavoriteCount(imagesJsonObject.getString("favorite_count"));

                 if(imagesJsonObject.has("ups"))
                     imagesModel.setUps(imagesJsonObject.getString("ups"));

                 if(imagesJsonObject.has("downs"))
                     imagesModel.setDowns(imagesJsonObject.getString("downs"));

                 if(imagesJsonObject.has("points"))
                     imagesModel.setPoints(imagesJsonObject.getString("points"));

                 if(imagesJsonObject.has("score"))
                     imagesModel.setScore(imagesJsonObject.getString("score"));


                 if(imagesJsonObject.has("tags"))
                     imagesModel.setTagsList(getJsonObjectTags(imagesJsonObject));


             } catch (JSONException e) {
                 e.printStackTrace();
                 Timber.d(e);
             }

//        "images":[
//    {
//        "id":"FfuQ80T",
//            "title":null,
//            "description":null,
//            "datetime":1600455941,
//            "type":"image\/jpeg",
//            "animated":false,
//            "width":1536,
//            "height":2048,
//            "size":443601,
//            "views":116,
//            "bandwidth":51457716,
//            "vote":null,
//            "favorite":false,
//            "nsfw":null,
//            "section":null,
//            "account_url":null,
//            "account_id":null,
//            "is_ad":false,
//            "in_most_viral":false,
//            "has_sound":false,
//            "tags":[
//
//               ],
//        "ad_type":0,
//            "ad_url":"",
//            "edited":"0",
//            "in_gallery":false,
//            "link":"https:\/\/i.imgur.com\/FfuQ80T.jpg",
//            "comment_count":null,
//            "favorite_count":null,
//            "ups":null,
//            "downs":null,
//            "points":null,
//            "score":null
//    },

        return imagesModel;
    }

}
