package com.lqr;

import android.app.Application;

import com.lqr.emoji.LQRUIKit;

/**
 * Created by Administrator on 2016/12/28.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LQRUIKit.init(getApplicationContext());
    }
}
