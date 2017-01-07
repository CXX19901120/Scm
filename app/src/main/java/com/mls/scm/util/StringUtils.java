package com.mls.scm.util;

import android.text.TextUtils;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by CXX on 2015/9/7.
 */
public class StringUtils {

 
    public static boolean isTel(String phoneNumber) {
        String expression = "((^(13|14|15|18|17)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";
        CharSequence inputStr = phoneNumber;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);

        return matcher.matches();
    }

    public static boolean isCphm(String cph) {
        
        Pattern pattern = Pattern.compile("^[\u4e00-\u9fa5|WJ]{1}[A-Z0-9]{6}$");
        Matcher matcher = pattern.matcher(cph);
        if (!matcher.matches()) {
            return false;
        }else {
            return true;
        }
    }


    public static String getText(String text) {
        if (TextUtils.isEmpty(text)) return "";
        return text;
    }

    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static boolean isEmpty(String value) {
        if (value != null && !"".equalsIgnoreCase(value.trim()) && !"null".equalsIgnoreCase(value.trim())) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isEquals(String... agrs) {
        String last = null;
        for (int i = 0; i < agrs.length; i++) {
            String str = agrs[i];
            if (isEmpty(str)) {
                return false;
            }
            if (last != null && !str.equalsIgnoreCase(last)) {
                return false;
            }
            last = str;
        }
        return true;
    }

    /**
     * 四舍五入 设置double 保留num位小数
     *
     * @param num
     * @param d
     * @return
     */
    public static String limitDouble2(double d, int num) {
        String d2 = String.format("%.2f", d);
        return new BigDecimal(d2).toString();
    }
}
