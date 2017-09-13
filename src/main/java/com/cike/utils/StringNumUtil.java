package com.cike.utils;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-13 15:59
 **/
public class StringNumUtil {
    public static int convertNum(String value) {
        if (value.contains("万")) {
            value = value.replace("万", "");
            value = value + "0000";
        }
        return Integer.parseInt(value);
    }
}
