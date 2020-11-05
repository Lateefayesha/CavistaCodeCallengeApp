package com.appynitty.cavistacodecallengeapp.common;

import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.SocketException;
import java.net.UnknownHostException;

import timber.log.Timber;

import static android.util.Log.INFO;

/**
 * Created by Ayan Dey on 30/10/20.
 */
public class CrashReportingTree extends Timber.Tree {
    private static CrashReportingTree crashReportingTree;




    public   static CrashReportingTree getInstance() {
        if(crashReportingTree==null) {
            crashReportingTree   =new CrashReportingTree();
        }
        return crashReportingTree;
    }

    FakeCrashLibrary library= new FakeCrashLibrary();
public boolean isLoggable(int priority, String tag){
    return priority >= INFO;
}





    @Override
    protected void log(int priority, @Nullable String tag, @NotNull String message, @Nullable Throwable t) {

        if (priority == Log.VERBOSE || priority == Log.DEBUG || t instanceof SocketException || t instanceof UnknownHostException)
            library.log(priority, tag  , message);



        if (t != null) {
            if (priority == Log.ERROR) {
                library.logError(t);
            } else if (priority == Log.WARN) {
                library.logWarning(t);
            }
        }

    }
}
