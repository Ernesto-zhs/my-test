package com.shadow.testdate;

import java.util.Calendar;
import java.util.Date;

public class TestDate {

    public static void main(String[] args) {
        Calendar calendar = getCalendar(30);
        System.out.println(calendar.getTime());

        Calendar fixedDate = getFixedDate(30);
        System.out.println(fixedDate.getTime());
    }

    private static Calendar getCalendar(Integer date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        if (instance.get(Calendar.DATE) > date) {
            instance.add(Calendar.MONTH, 1);
            while (instance.getActualMaximum(Calendar.DAY_OF_MONTH) < date) {
                instance.add(Calendar.MONTH, 1);
            }
        }
        instance.set(Calendar.DATE, date);
        return instance;
    }

    /**
     * 获取固定日期时间
     */
    private static Calendar getFixedDate(Integer fixedDate) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        if (instance.get(Calendar.DATE) > fixedDate) {
            instance.add(Calendar.MONTH, 1);
        }
        while (instance.getActualMaximum(Calendar.DAY_OF_MONTH) < fixedDate) {
            instance.add(Calendar.MONTH, 1);
        }
        instance.set(Calendar.DATE, fixedDate);
        return instance;
    }

}
