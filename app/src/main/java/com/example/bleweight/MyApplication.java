package com.example.bleweight;

import android.app.Application;

import com.xuexiang.xui.XUI;

public class MyApplication extends Application {
    public int backSelect = 0;//0-数量 1-价格  2-折扣  3-+/-

    public MyApplication() {

    }



    @Override
    public void onCreate() {

        super.onCreate();
        XUI.init(this); //初始化UI框架
        XUI.debug(true);  //开启UI框架调试日志

    }


}
