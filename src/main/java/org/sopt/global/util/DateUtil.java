package org.sopt.global.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Date 유틸 클래스
public class DateUtil {

    // Date format
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    // String으로 Date 반환
    public static LocalDate string2Date(String str){
        return LocalDate.parse(str, DateTimeFormatter.ofPattern(DATE_PATTERN));
    }

    // Date를 String으로 변환
    public static String Date2String(LocalDate localDate){
        return localDate.format(DateTimeFormatter.ofPattern(DATE_PATTERN));
    }
}
