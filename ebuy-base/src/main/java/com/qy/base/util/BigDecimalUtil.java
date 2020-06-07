package com.qy.base.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @Author: ebuy
 * @Describe: 金额比较器
 * @Date: Create in 16:25 2019/4/24
 */
public class BigDecimalUtil {


    public static final BigDecimal ZERO = BigDecimal.ZERO;
    public static final BigDecimal ONE = BigDecimal.ONE;
    public static final BigDecimal TEN = BigDecimal.TEN;

    /**
     * 比较
     * first >= second
     *
     * @param first
     * @param second
     * @return
     */
    public static boolean ge(BigDecimal first, BigDecimal second) {
        return first.compareTo(second) >= 0;
    }

    /**
     * 比较
     * first > second
     *
     * @param first
     * @param second
     * @return
     */
    public static boolean gt(BigDecimal first, BigDecimal second) {
        return first.compareTo(second) > 0;
    }

    /**
     * 比较
     * first <= second
     *
     * @param first
     * @param second
     * @return
     */
    public static boolean le(BigDecimal first, BigDecimal second) {
        return first.compareTo(second) <= 0;
    }

    /**
     * 比较
     * first < second
     *
     * @param first
     * @param second
     * @return
     */
    public static boolean lt(BigDecimal first, BigDecimal second) {
        return first.compareTo(second) < 0;
    }

    /**
     * 比较
     * first >= 0
     *
     * @param first
     * @return
     */
    public static boolean geZero(BigDecimal first) {
        return first.compareTo(ZERO) >= 0;
    }

    /**
     * 比较
     * first > 0
     *
     * @param first
     * @return
     */
    public static boolean gtZero(BigDecimal first) {
        return first.compareTo(ZERO) > 0;
    }

    /**
     * 比较
     * first <= 0
     *
     * @param first
     * @return
     */
    public static boolean leZero(BigDecimal first) {
        return first.compareTo(ZERO) <= 0;
    }

    /**
     * 比较
     * first < 0
     *
     * @param first
     * @return
     */
    public static boolean ltZero(BigDecimal first) {
        return first.compareTo(ZERO) < 0;
    }

    /**
     * 返回小的那个
     *
     * @param first
     * @return
     */
    public static BigDecimal getMin(BigDecimal first, BigDecimal second) {
        return ge(first, second) ? second : first;
    }

    /**
     * 返回大的那个
     *
     * @param first
     * @return
     */
    public static BigDecimal getMax(BigDecimal first, BigDecimal second) {
        return ge(first, second) ? first : second;
    }

    /**
     * 比较金额是否相等
     *
     * @param first
     * @return
     */
    public static boolean eq(BigDecimal first, BigDecimal second) {
        return first.compareTo(second) == 0;
    }

    public static BigDecimal create(int data) {
        return create(String.valueOf(data) + ".00");
    }

    public static BigDecimal create(String data) {
        if (StringUtils.isBlank(data)){
            return BigDecimalUtil.ZERO;
        }
        return new BigDecimal(data);
    }


    /**
     * 格式化
     *
     * @param first
     * @param num   保留小数点
     * @return
     */
    public static BigDecimal format(BigDecimal first, int num) {
        if (first == null) {
            return null;
        }
        return first.setScale(num, BigDecimal.ROUND_HALF_UP);
    }


    /**
     * 格式化
     * 1.01  ->  1.01
     * 1.00  -> 1
     * 1.10 --> 1.1
     *
     * @param first
     * @return
     */
    public static BigDecimal format(BigDecimal first) {
        if (first == null) {
            return null;
        }
        return first.stripTrailingZeros();
    }

    /**
     * 比较是否等于0
     *
     * @param first
     * @return
     */
    public static boolean eqZero(BigDecimal first) {
        return first.compareTo(ZERO) == 0;
    }

    /**
     * 校验是否小于0，如果小于0，那么返回0，否则返回传入的金额
     *
     * @param money
     * @return
     */
    public static BigDecimal checkZero(BigDecimal money) {
        if (money == null){
            return BigDecimalUtil.ZERO;
        }
        return BigDecimalUtil.ltZero(money) ? BigDecimalUtil.ZERO : money;

    }

    /**
     * 校验值是否在两个值之间，min <= number >= max
     *
     * @param number
     * @param min
     * @param max
     * @return
     */
    public static boolean isBetweenEq(BigDecimal number, BigDecimal min, BigDecimal max) {
        // number >= min ?
        if (!ge(number, min)) {
            return false;
        }
        // number <= max ?
        if (!le(number, max)) {
            return false;
        }

        return true;
    }

    /**
     * 校验值是否在两个值之间，min < number > max
     *
     * @param number
     * @param min
     * @param max
     * @return
     */
    public static boolean isBetween(BigDecimal number, BigDecimal min, BigDecimal max) {
        // number >= min ?
        if (!gt(number, min)) {
            return false;
        }
        // number <= max ?
        if (!lt(number, max)) {
            return false;
        }

        return true;
    }


    /**
     * 设置小数位
     *
     * @param zhigouPrice
     * @param i
     * @return
     */
    public static BigDecimal savePoint(BigDecimal zhigouPrice, int point) {
        return zhigouPrice.setScale(point, BigDecimal.ROUND_DOWN);

    }

    /**
     * 除法，保留两位小数，四舍五入
     *
     * @param first
     * @param second
     * @return
     */
    public static BigDecimal divide(BigDecimal first, BigDecimal second) {
        if (BigDecimalUtil.eqZero(second)){
            return BigDecimalUtil.ZERO;
        }
        return first.divide(second,2,RoundingMode.HALF_UP);
    }

}
