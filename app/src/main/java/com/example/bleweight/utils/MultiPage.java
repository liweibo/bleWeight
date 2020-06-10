

package com.example.bleweight.utils;


public class MultiPage {
    static String[] strArray={"   "+"批次1"+"   ","   "+"批次2"+"   ","   "+"批次3"+"   ",
            "   "+"批次4"+"   ","   "+"批次5"+"   ","   "+"批次6"+"   ",
            "   "+"批次7"+"   ","   "+"批次8"+"   ","   "+"批次9"+"   ","   "+"批次10"+"   "

    };

    private final int position;

    MultiPage(int pos) {
        position = pos;
    }



    public static String[] getPageNames() {

        return strArray;
    }


}
