package com.assignment.shopping.util;

public class Utils {

    /**
     * Formats string to remove decimal part when rounded amount
     * @param dblNum Double amount
     * @return Formatted string
     */
    public static String formatDoubleForDisplay(Double dblNum) {
        return dblNum > Math.round(dblNum) ? String.valueOf(dblNum) : String.format("%.0f", dblNum);
    }

}
