package com.log4j;

public class Utils {

    public static String sanitizeLog(String input) {
        return input.replace("\n", "_").replace("\r", "_").replace("\t", "_");
    }



}
