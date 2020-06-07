package com.qy.base.util;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: ebuy
 * @Describe: 字符串处理类
 * @Date: Create in 17:15 2019/5/17
 */
public class StringUtil {

    /**
     * 去掉特殊符号
     *
     * @param str
     * @return
     */
    public static String removeNonBmpUnicode(String str) {
        if (str == null) {
            return null;
        }
        str = str.replaceAll("[^\\u0000-\\uFFFF]", "");

        str = str.replaceAll("([^\\u4e00-\\u9fa5\\w\\(\\)（）])+?", "");

        return str;
    }

    private static Pattern linePattern = Pattern.compile("_(\\w)");

    /**
     * 下划线转驼峰
     */
    public static String lineToHump(String str) {

        if (StringUtils.isEmpty(str)) {
            return str;
        }
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 　　* 需求：把一个字符串的首字母转成大写，其余小写
     * 　　* 链式编程：只要保证每次调用完方法返回的是对象，就可以继续调用
     */
    public static String apitalizeInitial(String str) {
        String str1 = str.substring(0, 1).toUpperCase().concat(str.substring(1));
        return str1;
    }


    /**
     * 驼峰转下划线(简单写法，效率低于{@link #humpToLine2(String)})
     */
    public static String humpToLine(String str) {
        return str.replaceAll("[A-Z]", "_$0").toLowerCase();
    }

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 驼峰转下划线,效率比上面高
     */
    public static String humpToLine2(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 去除换行，空白字符
     *
     * @param str
     * @return
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * 切割字符串
     * 1,2,3  -> list[1,2,3]
     *
     * @param str
     * @return
     */
    public static List<String> splitter(String str) {
        return splitter(str, ",");
    }

    /**
     * 切割字符串
     * 1,2,3  -> list[1,2,3]
     *
     * @param str
     * @param splitt 分隔符
     * @return
     */
    public static List<String> splitter(String str, String splitt) {
        if (StringUtils.isBlank(str)) {
            return Lists.newArrayList();
        }
        return Lists.newArrayList(Splitter.on(splitt).omitEmptyStrings().trimResults().splitToList(str));
    }

    /**
     * 组合字符串
     * list[1,2,3] ->  1,2,3
     *
     * @param str
     * @param splitt 分隔符
     * @return
     */
    public static String join(Collection<String> str, String splitt) {
        if (CollectionUtils.isEmpty(str)) {
            return "";
        }

        return Joiner.on(splitt).join(str);
    }

    /**
     * 组合字符串
     * list[1,2,3] ->  1,2,3
     *
     * @param str
     * @return
     */
    public static String join(Collection<String> str) {
        return join(str, ",");
    }


    public static void main(String[] args) {

    }


    /**
     * 获取后number个字符
     * 字符不够默认返回所有
     *
     * @param str
     * @param number
     * @return
     */
    public static String getSuff(String str, int number) {
        if (str.length() <= number) {
            return str;
        }
        return str.substring(str.length() - number);
    }

    /**
     * 获取前number个字符
     * 字符不够默认返回所有
     *
     * @param str
     * @param number
     * @return
     */
    public static String getPrefix(String str, int number) {
        if (str.length() <= number) {
            return str;
        }
        return str.substring(0, number);
    }


    /**
     * 首字母大写
     *
     * @param name
     * @return
     */
    public static String captureName(String name) {
        char[] cs = name.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }


}
