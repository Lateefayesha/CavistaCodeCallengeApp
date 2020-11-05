package com.appynitty.cavistacodecallengeapp.common.rxjava;


import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Ayan Dey on 30/10/20.
 */
public class AppDisposables implements Disposables{
    private static   CompositeDisposable  compositeDisposable ;
private static AppDisposables appDisposables;



  public   static AppDisposables getInstance() {
        if(appDisposables==null) {
            appDisposables   =new AppDisposables();
            compositeDisposable = new CompositeDisposable();
        }
        return appDisposables;
    }


    @Override
    public void dispose() {
        compositeDisposable.dispose();
    }

    @Override
    public void clear() {
        compositeDisposable.dispose();
    }

    @Override
    public boolean isDisposed() {
        return compositeDisposable.isDisposed();
    }


}
