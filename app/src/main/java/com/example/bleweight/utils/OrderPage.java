

package com.example.bleweight.utils;


import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.bleweight.utils.data.RecyclerItemDataProvider;
import com.example.bleweight.utils.data.productAddDataInfo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OrderPage {
    static String[] strArray = {"订单1", "订单2", "订单3",
            "订单4", "订单5", "订单6",
            "订单7", "订单8", "订单9", "订单10"

    };

    public static List<String> orders = new ArrayList<>();


//    public static void addOneOrder() {
//        int len = orders.size() + 1;
//        String orderstr = "订单" + len;
//        if (!orders.contains(orderstr)) {//不添加重复的订单名字
//            orders.add(orderstr);
//        } else {//是重复的，则更改名字再添加，
//            orderstr = "订单" + len + 1;
//            if (!orders.contains(orderstr)) {//不添加重复的订单名字
//                orders.add(orderstr);
//            }
//        }
//    }

    public static int len =  1;
    public static  String orderstr = "订单1";
    public static void addOneOrder() {

        if (!orders.contains(orderstr)) {//不添加重复的订单名字
            orders.add(orderstr);
            RecyclerItemDataProvider.produceOneOrderData(orderstr);//生成该订单对应的list，用于存订单数据
            len++;
            orderstr = "订单"+len;
        } else {//是重复的，则更改名字再添加，
            len++;
            orderstr = "订单" +len;
            addOneOrder();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String deleteOneOrder(int index) {
        int len = orders.size();
        String whichOrdertoDele="";
        if (index < len) {
            whichOrdertoDele = orders.get(index);
            orders.remove(index);

            //订单删除后，对应的订单map数据也要删除
            Map<String, List<productAddDataInfo>> allList = RecyclerItemDataProvider.getAllOrderData();
            Iterator iterator = allList.keySet().iterator();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                if (whichOrdertoDele.equals(key)) {
                    iterator.remove();
                }
            }

        }
        return whichOrdertoDele;
    }

    public static String deleteOneOrderNotReal(int index) {
        int len = orders.size();
        String whichOrdertoDele="";
        if (index < len) {
            whichOrdertoDele = orders.get(index);
        }
        return whichOrdertoDele;
    }

    public static List<String> getOrderList() {
        return orders;
    }

    public static String[] getPageNames() {

        return strArray;
    }
}
