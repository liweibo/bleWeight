

package com.example.bleweight.utils;


import java.util.ArrayList;
import java.util.List;

public class OrderPage {
    static String[] strArray = {"订单1", "订单2", "订单3",
            "订单4", "订单5", "订单6",
            "订单7", "订单8", "订单9", "订单10"

    };

    public static List<String> orders = new ArrayList<>();

    public static void addOneOrder() {
        int len = orders.size() + 1;
        String orderstr = "订单" + len;
        orders.add(orderstr);
    }

    public static List<String> getOrderList() {
        return orders;
    }

    public static String[] getPageNames() {

        return strArray;
    }
}
