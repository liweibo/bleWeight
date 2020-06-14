package com.example.bleweight.utils.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RecyclerItemDataProvider {

    static List<productAddDataInfo> list = new ArrayList<>();

    static Map<String, List<productAddDataInfo>> orderData = new HashMap<>();

    public static List<productAddDataInfo> getZhongxinfachuListNewInfos() {
        return list;
    }

    public static void produceOneOrderData(String ordername) {
        List<productAddDataInfo> oneOrderlistdata = new ArrayList<>();
//订单名对应该订单的list数据
        orderData.put(ordername, oneOrderlistdata);

    }
    public static  Map<String, List<productAddDataInfo>> getAllOrderData(){
        return orderData;
    }

    public void refreshListdata() {

    }


}
