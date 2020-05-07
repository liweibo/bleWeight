

package com.example.bleweight.utils;


public enum OrderPage {

    订单1(0),
    订单2(1),
    订单3(2),
    订单4(3),
    订单5(4),
    订单6(5),
    订单7(6),
    订单8(7),
    订单9(8),
    订单10(9);

    private final int position;

    OrderPage(int pos) {
        position = pos;
    }

    public static OrderPage getPage(int position) {
        return OrderPage.values()[position];
    }

    public static int size() {
        return OrderPage.values().length;
    }

    public static String[] getPageNames() {
        OrderPage[] pages = OrderPage.values();
        String[] pageNames = new String[pages.length];
        for (int i = 0; i < pages.length; i++) {
            pageNames[i] = pages[i].name();
        }
        return pageNames;
    }

    public int getPosition() {
        return position;
    }

}
