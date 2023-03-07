package vn.coursemanage.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {
    public static final String rawPattern = "yyyy-MM-dd";

    public static String dateToString(Date date,String pattern){
        SimpleDateFormat splFormat = new SimpleDateFormat(pattern == null ? rawPattern : pattern);
        return splFormat.format(date);
    }
}
