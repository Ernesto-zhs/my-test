package com.shadow.testdate;

import java.util.Calendar;
import java.util.Date;

public class TestDate {

    public static void main(String[] args) {
        Calendar instance = getCalendar(20);
        System.out.println(instance.getTime());
    }

    private static Calendar getCalendar(Integer date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.set(Calendar.MONTH, 12);
        if (instance.get(Calendar.DATE) > date) {
            instance.add(Calendar.MONTH, 1);
            while (instance.getActualMaximum(Calendar.DAY_OF_MONTH) < date) {
                instance.add(Calendar.MONTH, 1);
            }
        }
        instance.set(Calendar.DATE, date);
        return instance;
    }

}
