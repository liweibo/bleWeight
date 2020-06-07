package com.example.bleweight.utils;

import java.text.DecimalFormat;

public class computeutil {
    /**
     * String转换成double 保留N位小数。
     * @param a
     * @return
     */
    public static double stringToDouble(String a){
        double b = Double.valueOf(a);
        DecimalFormat df = new DecimalFormat("#.00");//此为保留1位小数，若想保留2位小数，则填写#.00  ，以此类推
        String temp = df.format(b);
        b = Double.valueOf(temp);
        return b;
    }
}
