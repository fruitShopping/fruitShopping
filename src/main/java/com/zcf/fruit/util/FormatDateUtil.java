package com.zcf.fruit.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zcf on 2015/4/29.
 * 日期工具类 默认使用 "yyyy-MM-dd HH:mm:ss" 格式化日期
 */
public final class FormatDateUtil {
    private static ThreadLocal<SimpleDateFormat> displayFormatThreadLocal = new ThreadLocal<SimpleDateFormat>();

    public static final long DAY = 24 * 60 * 60 * 1000;

    private static SimpleDateFormat getDisplayDateFormat() {
        if (displayFormatThreadLocal.get() == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            displayFormatThreadLocal.set(simpleDateFormat);
            return simpleDateFormat;
        } else {
            return displayFormatThreadLocal.get();
        }
    }

    public static String formatDisplayDateToString(Date date) {
        if(date == null)
            return "";
        SimpleDateFormat simpleDateFormat = getDisplayDateFormat();
        return simpleDateFormat.format(date);
    }

    public static String formatDateToString(Date date) {
        if(date == null)
        {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return simpleDateFormat.format(date);
    }

    public static String formatDisplayDateToString(long timestamp) {
        SimpleDateFormat simpleDateFormat = getDisplayDateFormat();
        return simpleDateFormat.format(new Date(timestamp));
    }

    public static Date formatDisplayStringToData(String dataStr) {
        SimpleDateFormat simpleDateFormat = getDisplayDateFormat();
        try {
            return simpleDateFormat.parse(dataStr);
        } catch (Exception e) {
            return null;
        }
    }
}
