package com.sunland.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by batwings on 16/01/02.
 */
public class DateUtils {

    //日期格式设定
    public static java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
    public static java.text.SimpleDateFormat dateFormatShort = new java.text.SimpleDateFormat("yyyyMMdd");
    public static java.text.SimpleDateFormat dateFormatShort2 = new java.text.SimpleDateFormat("yyMMddHHmmss");
    public static java.text.SimpleDateFormat dateFormatShort3 = new java.text.SimpleDateFormat("yy");
    public static java.text.SimpleDateFormat dateFormatShort4 = new java.text.SimpleDateFormat("yyMMdd");
    public static java.text.SimpleDateFormat dateFormatShort6 = new java.text.SimpleDateFormat("HHmmss");
    public static java.text.SimpleDateFormat dateFormatShorthh = new java.text.SimpleDateFormat("HH");
    public static java.text.SimpleDateFormat dateFormatShortmm = new java.text.SimpleDateFormat("mm");
    public static java.text.SimpleDateFormat dateFormatShortSS = new java.text.SimpleDateFormat("yyyyMMddHHmmssS");

    //日期带时间格式设定
    public static java.text.SimpleDateFormat dateTimeFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static java.text.SimpleDateFormat dateTimeFormat0 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static java.text.SimpleDateFormat dateTimeFormats = new java.text.SimpleDateFormat("yyyy年MM月dd日HH:mm");
    public static java.text.SimpleDateFormat dateTimeFormats2 = new java.text.SimpleDateFormat("M月d日HH:mm");
    public static java.text.SimpleDateFormat dateTimeFormat1 = new java.text.SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
    public static java.text.SimpleDateFormat dateFormatShort5 = new java.text.SimpleDateFormat("yyMM");
    public static java.text.SimpleDateFormat dateFormatShort7 = new java.text.SimpleDateFormat("MM-dd");
    public static java.text.SimpleDateFormat dateFormatShort8 = new java.text.SimpleDateFormat("yyyy/m/d h:mm");

    public static Date getAfterDate(Date date, int several) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        long result = cal.getTimeInMillis() + ((long) several) * 24 * 60 * 60 * 1000;
        return new Date(result);
    }

    public static Date getEndDate(Date date) throws Exception {
        if (date != null) {
            String retStr = dateFormat.format(date) + " 23:59:59";
            return dateTimeFormat.parse(retStr);
        } else {
            return null;
        }
    }

    public static String formatDateYYYYMMDDHHMMSS(Date date) {
        if (date == null){
            return "";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date);
        }
    }

    public static String formatDateYYYYMMDDHHMM(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(date);
    }

    public static String formatDateYYYYMMDD(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static String formatDateYYYYMM(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        return sdf.format(date);
    }

    public static String formatDateYYYYMMdd(Date date) {
        if (date == null){
            return "";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            return sdf.format(date);
        }
    }

    public static String formatDateHH(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("H");
        return sdf.format(date);
    }

    public static String formatDatemm(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("m");
        return sdf.format(date);
    }


    /**
     * 给指定日期加分钟
     *
     * @param date
     * @param x
     * @return
     */
    public static Date addDateMinut(Date date, int x)//返回的是字符串型的时间，输入的
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 24小时制
        //引号里面个格式也可以是 HH:mm:ss或者HH:mm等等，很随意的，不过在主函数调用时，要和输入的变
        //量day格式一致
        //System.out.println("front:" + format.format(date)); //显示输入的日期
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, x);// 24小时制
        date = cal.getTime();
        // System.out.println("after:" + format.format(date));  //显示更新后的日期
        cal = null;
        return date;

    }

    public static Date parseStrYYYYMMdd(String datestr) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(getDateFormat(11)); //规定日期格式
            Date date = formatter.parse(datestr); //将符合格式的String转换为Date
            return date;
        } catch (Exception e) {
        }
        return null;
    }

    public static Date formatstr2(String datestr) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); //规定日期格式
            Date date = formatter.parse(datestr); //将符合格式的String转换为Date
            return date;
        } catch (Exception e) {
        }
        return new Date();
    }

    public static Date formatstr3(String datestr) {
        Date date = new Date();
        try {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss"); //规定日期格式
            date = formatter.parse(datestr); //将符合格式的String转换为Date

        } catch (Exception e) {
        }

        return date;
    }

    public static Date formatstr(String datestr) {
        Date date = new Date();
        try {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //规定日期格式
            date = formatter.parse(datestr); //将符合格式的String转换为Date

        } catch (Exception e) {
        }

        return date;
    }

    public static String getDate(Date date, int kind) {
        String res = "";
        if (date != null) {
            String format = getDateFormat(kind);
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            res = sdf.format(date);
        }
        return res;
    }

    private static String getDateFormat(int kind) {
        String[] format = {
                "yyyy-MM-dd", //0
                "yyyy-MM-dd HH:mm:ss", //1
                "yyyy",//2
                "M",//3
                "dd", //4
                "yyyy年M月d日H点m分", //5
                "yyyy年M月d日", //6
                "H点m分", //7
                "yyyy-MM-dd HH:mm", //8
                "HH",//9
                "mm",//10
                "yyyyMMdd", //11
                "yyyyMMddHHmmss", //12
                "yyyy-MM-dd 23:59:59", //13
                "yyyy 年 M 月 d 日", //14
                "yyyy年MM月dd日HH时mm分",//15
                "yyyy 年  M 月  d 日  H 点  m 分", //16
                "HHmmss",//17
                "HHmm",//18
                "HH:mm"//19

        };
        return format[kind];
    }


    /**
     * 格式化当前时间为 dateStyle 样式
     *
     * @param dateStyle
     * @return
     */
    public static String formatDateByStyle(String dateStyle) {
        String str = "";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(dateStyle); //规定日期格式
            str = formatter.format(new Date()); //
        } catch (Exception e) {
            return null;
        }
        return str;
    }

    /**
     * 格式化传入时间为 dateStyle 样式
     *
     * @param date
     * @param dateStyle
     * @return
     */
    public static String formatDateByStyle(Date date, String dateStyle) {
        String str = "";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(dateStyle); //规定日期格式
            str = formatter.format(date); //
        } catch (Exception e) {
            return null;
        }
        return str;
    }

    /**
     * 字符串转换为日期java.util.Date
     *
     * @param dateText 字符串
     * @param kind     日期格式
     * @return
     */
    public static Date toDate(String dateText, int kind) {
        String format = getDateFormat(kind);
        if (dateText == null) {
            return null;
        }
        DateFormat df = null;
        try {
            if (format == null) {
                df = new SimpleDateFormat();
            } else {
                df = new SimpleDateFormat(format);
            }

            // setLenient false to avoids allowing dates like 9/32/2001
            // and true to allowing, which would otherwise parse to 10/2/2001
            df.setLenient(false);

            return df.parse(dateText);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 字符串的日期格式的计算
     */
    public static int daysBetween(String smdate, String bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    public static void main(String[] a) {
        System.out.println(toDate("2015-12-29 01:22:30", 0));
//        try {
//            System.out.println(""+daysBetween("20151229","20160109"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }

}
