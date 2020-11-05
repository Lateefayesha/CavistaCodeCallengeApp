package com.appynitty.cavistacodecallengeapp.common;

import timber.log.Timber;

/**
 * Created by Ayan Dey on 30/10/20.
 */
public class FakeCrashLibrary {
    public void log(int priority, String tag, String message) {
        // TODO add log entry to circular buffer.
        Timber.d(message);

    }

    public void logWarning(Throwable t) {
        t.printStackTrace();
        Timber.w(t);
    }

    public void logError(Throwable t) {
        t.printStackTrace();
        Timber.e(t);


    }



}
