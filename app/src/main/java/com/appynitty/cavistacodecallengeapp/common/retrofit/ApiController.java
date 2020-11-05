package com.appynitty.cavistacodecallengeapp.common.retrofit;

/**
 * Created by Ayan Dey on 30/10/20.
 */

import io.reactivex.Observable;
import okhttp3.Call;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiController {

//    @FormUrlEncoded
//    @POST("MobileMaster/GenerateOtp")
//    Observable<ResponseBody> getMobileOtp(
//            @Field("MobileNumber") String mobileNumber);
//
//
//    @GET("LoginMaster/JsonLogin")
//    Observable<ResponseBody> postLogin(@Query("userName") String userName,
//                                       @Query("password") String password);




    @GET("3/gallery/search/1?q=vanilla")
    Observable<ResponseBody> getImageSearch();


    @GET("3/account/imgur/images/0.json")
    Observable<ResponseBody> getImageSearch(@Query("perPage") int perPage , @Query("page") int page);




}
