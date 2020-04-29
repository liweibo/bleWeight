

package com.example.bleweight.utils;


public enum MultiPage {

    批次1(0),
    批次2(1),
    批次3(2),
    批次4(3),
    批次5(4),
    批次6(5),
    批次7(6),
    批次8(7),
    批次9(8),
    批次10(9);

    private final int position;

    MultiPage(int pos) {
        position = pos;
    }

    public static MultiPage getPage(int position) {
        return MultiPage.values()[position];
    }

    public static int size() {
        return MultiPage.values().length;
    }

    public static String[] getPageNames() {
        MultiPage[] pages = MultiPage.values();
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
