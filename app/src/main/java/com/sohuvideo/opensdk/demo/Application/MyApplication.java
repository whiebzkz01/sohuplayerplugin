package com.sohuvideo.opensdk.demo.Application;

import android.app.Application;

import com.sohu.lib.net.request.RequestManager;
import com.sohuvideo.push.PushManager;
import com.sohuvideo.ui_plugin.api.UiPluginInit;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        UiPluginInit.init(this);
        /**
         * 开启PUSH功能
         */
        PushManager.getInstance(this).startPush();
    }
}
