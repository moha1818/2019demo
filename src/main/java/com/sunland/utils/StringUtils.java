package com.sunland.utils;

/**
 * Created by wg on 2016/3/25.
 */
public class StringUtils {

    public static String[] getStrings(String arg) {
        String args[];
        if (arg != null) {
            args = arg.split(",");
            return args;
        }
        args = new String[0];
        return args;
    }

    public static String getYccj(String ajzt) {

        if (ajzt != null && (!ajzt.equals(""))) {
            return ajzt;
        } else {
            return "0";
        }
    }

    public static String getNullString(String str) {

        if (str != null && (!str.equals(""))) {
            return str;
        } else {
            return "无";
        }
    }

    public static String getNullString2(String str) {

        if (str != null && (!str.equals(""))) {
            return str;
        } else {
            return "";
        }
    }


    public static void main(String[] a) {
        System.out.println(stringToIntegerHou("24"));
    }

    public static Integer stringToIntegerHou(String arg) {
        Integer i = null;
        try {
            i = new Integer(arg);
            if (!(i >= 0 && i < 24)) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        return i;
    }

    public static Integer stringToIntegerMin(String arg) {
        Integer i = null;
        try {
            i = new Integer(arg);
            if (!(i >= 0 && i < 60)) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        return i;
    }

    public static Integer stringToInteger(String arg) {

        if (null == arg || "".equals(arg))
            return null;
        else
            return new Integer(arg);
    }

    public static Integer getInteger(Integer i) {

        if (null == i)
            return 0;
        else
            return i;
    }

    public static Long getLong(String i) {

        if (null == i) {
            return 0L;
        } else {
            try {
                return new Long(i);
            } catch (Exception e) {
                return 0L;
            }
        }
    }

    /**
     * 是否超过最大异常处理数量
     *
     * @param strPer
     * @param ycclNumThisMonth 本月异常处理数量
     * @param cjNumBeforeMonth 上月违法采集数量
     * @return
     */
    public static boolean isMaxYccl(String strPer, Integer ycclNumThisMonth, Integer cjNumBeforeMonth) {
        Integer per = 0;
        try {
            per = new Integer(strPer);
        } catch (Exception e) {
            per = 0;
        }
        Integer maxNum = (per * cjNumBeforeMonth) / 100;
        maxNum = maxNum == 0 ? 1 : maxNum;
        if (ycclNumThisMonth + 1 > maxNum) {
            return true;
        } else {
            return false;
        }
    }


    public static int returnSyNum(String strPer, Integer ycclNumThisMonth, Integer cjNumBeforeMonth) {
        Integer per = 0;
        try {
            per = new Integer(strPer);
        } catch (Exception e) {
            per = 0;
        }
        Integer maxNum = (per * cjNumBeforeMonth) / 100;
        maxNum = maxNum == 0 ? 1 : maxNum;
        if (maxNum - ycclNumThisMonth < 0) {
            return 0;
        } else {
            return maxNum - ycclNumThisMonth;
        }

    }


    public static String getString(String a) {
        if (null == a) {
            return "0";
        }
        if ("".equals(a)) {
            return "0";
        }
        return a;
    }

    public static String getLshString(Integer arg) {
        String lsh = "";
        if (arg != null) {
            lsh = arg.toString();
        }
        int lshLeng = lsh.length();
        for (int i = 0; i < 5 - lshLeng; i++) {
            lsh = "0" + lsh;
        }

        return lsh;
    }


}
