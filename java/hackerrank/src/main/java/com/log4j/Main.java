package com.log4j;

public class Main {

    public static void main(String[] args) {

        String[] values = new String[10];
        for(int i = 0; i < 10; i++) {
            values[i] = "hola" + i;
        }
        
        for(String value : values) {
            value = Utils.sanitizeLog(value);
            System.out.println("value = " + value);
        }


    }


}
