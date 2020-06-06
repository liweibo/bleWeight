package com.example.bleweight;

import android.app.Application;

import com.xuexiang.xui.XUI;

public class MyApplication extends Application {
    public String clickedPro = "test";
    public boolean isJijianbtn = true;
    public int adapterPos=-1;
    public MyApplication() {

    }

    public String getClickedPro() {
        return clickedPro;
    }

    public void setClickedPro(String clickedPro) {
        this.clickedPro = clickedPro;
    }


    //是否点击计件按钮，并显示计件按钮
    public boolean isJijianbtn() {
        return isJijianbtn;
    }

    public void setJijianbtn(boolean jijian) {
        isJijianbtn = jijian;
    }

    public int getAdapterPos() {
        return adapterPos;
    }

    public void setAdapterPos(int adapterPos) {
        this.adapterPos = adapterPos;
    }



    @Override
    public void onCreate() {

        super.onCreate();
        XUI.init(this); //初始化UI框架
        XUI.debug(true);  //开启UI框架调试日志

    }


}
