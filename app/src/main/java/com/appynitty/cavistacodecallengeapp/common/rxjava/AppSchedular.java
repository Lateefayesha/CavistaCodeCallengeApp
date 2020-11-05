package com.appynitty.cavistacodecallengeapp.common.rxjava;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;


/**
 * Created by Ayan Dey on 30/10/20.
 */
public  class AppSchedular  implements Schedulers {




    private static AppSchedular appSchedular;



  public   static AppSchedular getInstance() {
        if(appSchedular==null) {
            appSchedular   =new AppSchedular();

        }
        return appSchedular;
    }




    @Override
    public Scheduler mainThread() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler io() {
        return io.reactivex.schedulers.Schedulers.io();
    }

    @Override
    public Scheduler computation() {
        return io.reactivex.schedulers.Schedulers.computation();
    }


    @Override
    public Scheduler trampoline() {
        return io.reactivex.schedulers.Schedulers.trampoline();
    }

    @Override
    public Scheduler newThread() {
        return io.reactivex.schedulers.Schedulers.newThread();
    }





}
