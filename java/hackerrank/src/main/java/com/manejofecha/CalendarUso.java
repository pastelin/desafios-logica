package com.manejofecha;

import java.util.Calendar;

public class CalendarUso {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 20);

        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.getTime());

    }

}
