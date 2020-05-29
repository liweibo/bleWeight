package com.example.bleweight.utils.data;

import java.util.ArrayList;
import java.util.List;


public class RecyclerItemDataProvider {


    public static List<productAddDataInfo> getZhongxinfachuListNewInfos() {
        List<productAddDataInfo> list = new ArrayList<>();

        list.add(new productAddDataInfo("01", "大蒜",12,
                33, 12.09,888));
        list.add(new productAddDataInfo("02", "黄瓜",8,
                13, 22.09,288));
        list.add(new productAddDataInfo("03", "葱",10,
                33, 12.99,788));
        list.add(new productAddDataInfo("04", "姜",16,
                23, 18.89,908));
        list.add(new productAddDataInfo("05", "白菜",11,
                88, 12.77,87));
        list.add(new productAddDataInfo("06", "胡萝卜",7,
                99, 12.23,856));
        list.add(new productAddDataInfo("07", "芹菜",2,
                103, 89.09,565));
        list.add(new productAddDataInfo("08", "芹菜",2,
                103, 89.09,565));
        list.add(new productAddDataInfo("09", "芹菜test",2,
                103, 19.09,565));
        list.add(new productAddDataInfo("10", "芹菜", 2,
                103, 809.09, 55));
        list.add(new productAddDataInfo("11", "芹菜", 2,
                103, 89.09, 85));

       return list;
    }



}
