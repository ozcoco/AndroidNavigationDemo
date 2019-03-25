package org.oz.test;

import android.content.res.Configuration;

import org.oz.ntv.CodecHelper;

import androidx.multidex.MultiDexApplication;

public class MainApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        CodecHelper helper = new CodecHelper();

        new Thread(() -> {
            
            helper.log("哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");

        }).start();


    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }


    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

}
