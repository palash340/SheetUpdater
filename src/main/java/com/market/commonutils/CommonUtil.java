package com.market.commonutils;

/**
 * Created by administrator on 9/4/17.
 */
public class CommonUtil {
    public static int parseInt(String value){
        int intValue = -1;
        try {
            intValue = Integer.parseInt(value);
        }catch (NumberFormatException nfe){
            // Error parsing number
        }
        return intValue;
    }

    public static short parseShort(String value){
        Short shortValue = -1;
        try {
            shortValue = Short.parseShort(value);
        }catch (NumberFormatException nfe){
            // Error parsing number
        }
        return shortValue;
    }

    public static long parseLong(String value){
        long longValue = -1;
        try {
            longValue = Long.parseLong(value);
        }catch (NumberFormatException nfe){
            // Error parsing number
        }
        return longValue;
    }

    public static float parseFloat(String value){
        float floatValue = -1;
        try {
            floatValue = Float.parseFloat(value);
        }catch (NumberFormatException nfe){
            // Error parsing number
        }
        return floatValue;
    }

    public static double parseDouble(String value){
        double doubleValue = -1;
        try {
            doubleValue = Double.parseDouble(value);
        }catch (NumberFormatException nfe){
            // Error parsing number
        }
        return doubleValue;
    }
}
