package edu.fudan.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static SimpleDateFormat sdfLong = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat sdfShort = new SimpleDateFormat("yyyy-MM-dd");

    /*
     * 日期时间格式字符串转换为Date类型
     */
    public static Date stringLongToDate(String string) throws Exception {
        return sdfLong.parse(string);
    }

    /*
     * 日期格式字符串转换为Date类型
     */
    public static Date stringShortToDate(String string) throws Exception {
        return sdfShort.parse(string);
    }

    /*
     * 长整型毫秒(自1970-01-01  00:00:00 GMT过去的毫秒数，又称Unix时间戳)转换为Date类型
     */
    public static Date millisecondToDate(long millisecond) {
        return new Date(millisecond);
    }

    /*
     * 日期时间格式字符串转换为(Unix时间戳)长整型类型
     */
    public static long stringLongToMillisecond(String string) throws Exception {
        return stringLongToDate(string).getTime();
    }

    /*
     * 日期格式字符串转换为(Unix时间戳)长整型类型
     */
    public static long stringShortToMillisecond(String string) throws Exception {
        return stringShortToDate(string).getTime();
    }

    /*
     * Date类型转换为(Unix时间戳)长整型类型
     */
    public static long dateToMillisecond(Date date) {
        return date.getTime();
    }

    /*
     * (Unix时间戳)长整型类型转换为日期时间格式字符串
     */
    public static String millisecondToStringLong(long millisecond) {
        return sdfLong.format(millisecond);
    }

    /*
     * Date类型转换为日期时间格式字符串
     */
    public static String dateToStringLong(Date date) {
        return sdfLong.format(date);
    }

    /*
     * (Unix时间戳)长整型类型转换为日期格式字符串
     */
    public static String millisecondToStringShort(long millisecond) {
        return sdfShort.format(millisecond);
    }

    /*
     * Date类型转换为日期格式字符串
     */
    public static String dateToStringShort(Date date) {
        return sdfShort.format(date);
    }


}
