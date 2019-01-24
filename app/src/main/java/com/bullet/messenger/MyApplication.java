package com.bullet.messenger;

import android.app.Application;
import android.content.Context;

import com.respectwechat.RespectWXManager;

public class MyApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        RespectWXManager.getInstance().start();
    }
}
