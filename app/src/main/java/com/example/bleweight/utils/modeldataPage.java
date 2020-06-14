package com.example.bleweight.utils;

import com.example.bleweight.R;

import java.util.ArrayList;
import java.util.List;

public class modeldataPage {

    public modeldataPage() {
        gukeListdata.add("李书行");
        gukeListdata.add("廖冰");
        gukeListdata.add("刘波");
        gukeListdata.add("王三毛");
        gukeListdata.add("陈炜");
        gukeListdata.add("刘鹏");
        gukeListdata.add("郝波");
        gukeListdata.add("黄铖");
        gukeListdata.add("王名");
        gukeListdata.add("黎梦");
        gukeListdata.add("吴燕飞");
        gukeListdata.add("燕家云");
        gukeListdata.add("康圆融");
    }



    //顾客
    List<String> gukeListdata = new ArrayList<>();

    //批次1
    static public int iconA[] = {
            R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi,
            R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi};

    static public String productTv[] = {"茄子1", "茄子2", "茄子3", "茄子4", "茄子5", "茄子6", "茄子7",
            "茄子8", "茄子9", "茄子10", "茄子11", "茄子12", "茄子13", "茄子14", "茄子15",
            "茄子16", "茄子17", "茄子18",
            "茄子19", "茄子20"};


    //批次2
    static public int iconPiciTwoA[] = {
            R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi,
            R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi};

    static public String productPicitwoTv[] = {"2茄子1", "2茄子2", "茄子3", "茄子4", "茄子5", "茄子6", "茄子7",
            "茄子8", "2茄子9", "茄子10", "茄子11", "茄子12", "茄子13", "茄子14", "茄子15",
            "茄子16", "2茄子17", "茄子18",
            "茄子19", "2茄子20"};


    //批次..........
    static public int iconsss[] = {
            R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi,
            R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi, R.drawable.ic_qiezi};

    static public String productsssTv[] = {"test1", "test2", "test3", "test4", "test5", "test6", "test7",
            "test8", "test9", "test10", "test11", "test12", "test13", "test14", "test15",
            "test16", "test17", "test18",
            "test19", "test20"};

    public static int[] getIconA() {
        return iconA;
    }

    public static int[] getIconPiciTwoA() {
        return iconPiciTwoA;
    }

    public static String[] getProductPicitwoTv() {
        return productPicitwoTv;
    }

    public static String[] getProductTv() {
        return productTv;
    }

    public List<String> getGukeListdata() {
        return gukeListdata;
    }

    public void setGukeListdata(List<String> gukeListdata) {
        this.gukeListdata.clear();
        for (int i = 0; i < gukeListdata.size(); i++) {
            this.gukeListdata.add(gukeListdata.get(i));

        }
    }
}
