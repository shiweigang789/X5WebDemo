package com.swg.x5webdemo;

import android.app.Application;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;

/**
 * Created by swg on 2017/10/18.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initX5();
    }

    /**
     * 初始化X5
     */
    private void initX5() {
        //x5內核初始化回调
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }

            @Override
            public void onViewInitFinished(boolean b) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("app", " onViewInitFinished is " + b);
            }
        };
        // X5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }
}
