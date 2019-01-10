package com.sunland.utils;

import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by lq on 16/02/19.
 */
public class StringUtil {

    /**
     * 分转元
     * @param amount
     * @return
     */
    public static String centTransferYuan(Integer amount) {
        if (amount != null && !"".equals(amount)) {
            double money = amount / 100.0;
            return String.valueOf(money) + " 元";
        } else {
            return "";
        }
    }

    /**
     * 分转元
     * @param amount
     * @return
     */
    public static String centTransferYuan(Short amount) {
        if (amount != null && !"".equals(amount)) {
            double money = amount / 100.0;
            return String.valueOf(money) + " 元";
        } else {
            return "";
        }
    }

    /**
     * String判空
     *
     * @param param
     * @return
     */
    public static boolean isNotNull(String param) {
        if (param != null && !"".equals(param))
            return true;
        return false;
    }
    /**
     * String判空
     *
     * @param param
     * @return
     */
    public static Integer nullToZero(Integer param) {
        if (param != null && !"".equals(param))
            return param;
        return 0;
    }

    public static Double nullToZero(Double param) {
        if (param != null && !"".equals(param))
            return param;
        return 0.0;
    }
    public static String nullToZero(String param) {
        if (param != null && !"".equals(param))
            return param;
        return "0";
    }
    /**
     * String判空
     *
     * @param param
     * @return
     */
    public static boolean isNullOrZero(Integer param) {
        if (param != null && !"".equals(param)&&param!=0)
            return false;

        return true;
    }
    /**
     * String判空
     *
     * @param param
     * @return
     */
    public static boolean isNull(Integer param) {
        if (param != null && !"".equals(param))
            return false;
        return true;
    }
    public static boolean isNull(Long param) {
        if (param != null && !"".equals(param))
            return false;
        return true;
    }
    /**
     * String判空
     *
     * @param param
     * @return
     */
    public static boolean isNull(String param) {
        if (param != null && !"".equals(param))
            return false;
        return true;
    }
    /**
     * @return
     */
    public static String subString(String str, int s, int len) {
        byte[] substr = new byte[len];
        System.arraycopy(str.getBytes(), s, substr, 0, len);
        str = new String(substr);
        return str;
    }

    public final static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            String endStr = new String(str);
            return endStr;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将元数据前补零，补后的总长度为指定的长度，以字符串的形式返回
     *
     * @param sourceDate
     * @param formatLength
     * @return 重组后的数据
     */
    public static String frontCompWithZore(int sourceDate, int formatLength) {
      /*
       * 0 指前面补充零
       * formatLength 字符总长度为 formatLength
       * d 代表为正数。
       */
        String newString = String.format("%0" + formatLength + "d", sourceDate);
        return newString;
    }

    /**
     * 判断是否为有效的15位或18位的居民身份证号码
     *
     * @param sfzh 身份证号码
     * @return True有效，False无效<
     */
    public static boolean checkPerID(String sfzh) {
        String birthstr = "";
        String sexstr = "";

// 判断格式
        if (sfzh == null || sfzh.equals(""))
            return false;
        if (sfzh.length() != 15 && sfzh.length() != 18)
            return false;

        if (sfzh.length() == 15) {
            if (sfzh.matches("\\d{15}") == false) {// 格式错误
                return false;
            }
            birthstr = "19" + sfzh.substring(6, 12);
            sexstr = sfzh.substring(12);
        } else {
            if (sfzh.matches("^\\d{17}(\\d|X|x)") == false) {// 格式错误
                return false;
            }
            birthstr = sfzh.substring(6, 14);
            sexstr = sfzh.substring(14, 17);
        }
// 判断出生日期
        try {
            int year = Integer.valueOf(birthstr.substring(0, 4));
            int month = Integer.valueOf(birthstr.substring(4, 6));
            int day = Integer.valueOf(birthstr.substring(6));

            if (month > 12 || month < 1 || day < 1 || day > 31 || year < 1900) {
                return false;
            }
            if (month == 2 && day > 29) {
                return false;
            }
            if (year > Calendar.getInstance().get(Calendar.YEAR)) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
// 判断性别顺序号
        if (sexstr.equals("000")) {
            return false;
        }

        if (sfzh.length() == 18) {
// 判断校验位
            return sfzh.substring(17, 18)
                    .equalsIgnoreCase(parityBitPerID(sfzh));
        }
        return true;
    }

    /**
     * 生成身份证号的校验位
     *
     * @param sfzh 身份证号（17位及以上）
     * @return 校验位
     */
    public static String parityBitPerID(String sfzh) {
        if (sfzh.length() < 17)
            return "";

        int[] weight = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5,
                8, 4, 2};
        String parity = "10X98765432";
        char[] s17 = sfzh.substring(0, 17).toCharArray();
        int s = 0;
        for (int i = 0; i < s17.length; i++) {
            s += (s17[i] - 0x30) * weight[i];
        }
        return String.valueOf(parity.charAt(s % 11));
    }

    /**
     * 获取18位身份证号码，如果是15换18位
     *
     * @param sfzh
     * @return
     */
    public static String getNormalPerID(String sfzh) {
        if (sfzh.length() == 18) {
            return sfzh;
        } else {
            //出生日期前面加 “19”
            String perfix = sfzh.substring(0, 6);
            String suffix = sfzh.substring(6, 15);
            String fix = perfix + "19" + suffix;
            String parityBit = parityBitPerID(fix);
            return fix + parityBit;
        }
    }


    public static String getRandomString(int len) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; ++i) {
            int number = random.nextInt(62);//[0,62)  
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

}
