package com.example.java8.datetime;

import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeServiceImpl {
    public static void excute() throws InterruptedException {
        Date date = new Date();
        long time = date.getTime();
        System.out.println(date);
        System.out.println(time);

//        Thread.sleep(1000*3);
//        Date after3Second = new Date();
//        System.out.println(after3Second);
//        after3Second.setTime(time);
//        System.out.println(after3Second.getTime());

        Calendar birthDay = new GregorianCalendar(2020, Calendar.JULY, 20);

        //기계시간
        System.out.println("1. Instant");
        Instant instant = Instant.now();
        System.out.println(instant); //기준시 UTC, GMT

        System.out.println("2. Zone");
        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime);

        System.out.println("3.LocalDateTime");
        //휴먼용 서버의 시스템 데이트를 사용
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime birthday = LocalDateTime.of(1990, Month.SEPTEMBER, 27, 0, 0, 0);
        System.out.println(birthday);
    }
}
