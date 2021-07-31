package com.assignment.shopping.util;

public class Utils {

    public static String formatDoubleForDisplay(Double dblNum) {
        return dblNum > Math.round(dblNum) ? String.valueOf(dblNum) : String.format("%.0f", dblNum);
    }

}
