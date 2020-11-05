package com.appynitty.cavistacodecallengeapp.common;

import android.app.Application;
import android.util.Log;

import com.appynitty.cavistacodecallengeapp.common.database.AppRoomDatabase;
import com.facebook.stetho.BuildConfig;
import com.facebook.stetho.Stetho;


/**
 * Created by Ayan Dey on 30/10/20.
 */
public  class AppApplication extends Application {

   AppRoomDatabase database=null;
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReportingTree.getInstance().isLoggable(Log.VERBOSE, "AppApplication" );
        if(BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }


    }


}
