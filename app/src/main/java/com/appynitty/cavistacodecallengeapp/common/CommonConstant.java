package com.appynitty.cavistacodecallengeapp.common;

import android.content.Context;

import com.appynitty.cavistacodecallengeapp.R;
import com.appynitty.cavistacodecallengeapp.common.retrofit.ApiController;
import com.appynitty.cavistacodecallengeapp.common.retrofit.Retro;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Ayan Dey on 30/10/20.
 */
public  class CommonConstant {
     public static final String baseUrl="https:/api.imgur.com/";
     public static final String userId="User_Id";


    public static final String app_db="CavistaCodeCallengeDb";

    public static ApiController  getController(Context context){
           return Retro.getInstance().getController(context.getString(R.string.authorization_header));
      }


}
