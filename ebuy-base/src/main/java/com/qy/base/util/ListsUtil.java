package com.qy.base.util;

import com.google.common.collect.Lists;
import com.qy.base.entity.BaseEntity;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 * @Author: Lautumn
 * @Describe: list工具类
 * @Date: Create in 17:28 2019/11/14
 */
@Data
public class ListsUtil {

    /**
     * 获取传入的数组的某个字段属性列表
     * List<User> records = new ArrayList();
     * 获取用户id列表
     * List<String> ids = ListsUtil.ids(records, User::getId);
     *
     * @param list
     * @param function
     * @param <T>
     * @param <V>
     * @return
     */
    public static <T> List<T> limit(List<T> list, int limit) {
        if (CollectionUtils.isEmpty(list)) {
            return Lists.newArrayList();
        }
        if (limit == 0) {
            return list;
        }
        return list.stream().limit(limit).collect(Collectors.toList());
    }

    /**
     * 获取传入的数组的某个字段属性列表
     * List<User> records = new ArrayList();
     * 获取用户id列表
     * List<String> ids = ListsUtil.ids(records, User::getId);
     *
     * @param list
     * @param function
     * @param <T>
     * @param <V>
     * @return
     */
    public static <T, V> List<V> ids(List<T> list, Function<T, V> function) {
        return list.stream().map(function).collect(Collectors.toList());
    }

    /**
     * 获取传入的数组的某个字段属性列表
     * List<User> records = new ArrayList();
     * 获取用户id列表
     * List<String> ids = ListsUtil.idsSet(records, User::getId);
     *
     * @param list
     * @param function
     * @param <T>
     * @param <V>
     * @return
     */
    public static <T, V> Set<V> idsSet(List<T> list, Function<T, V> function) {
        return list.stream().map(function).collect(Collectors.toSet());
    }


    /**
     * 获取传入的数组的id列表
     * List<User> records = new ArrayList();
     * 获取用户id列表
     * List<String> ids = ListsUtil.ids(records);
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T extends BaseEntity> List<String> ids(List<T> list) {
        return ids(list, BaseEntity::getId);
    }

    /**
     * 求和
     * ListsUtil.reduce(walletDetailsList, WalletDetails::getMoney);
     *
     * @param list
     * @return
     */
    public static <T> BigDecimal reduceBigdecimal(List<T> list, Function<T, BigDecimal> function) {
        return list.stream().map(function).reduce((sum, number) -> sum.add(number)).orElse(BigDecimalUtil.ZERO);
    }

    /**
     * 求和
     * ListsUtil.reduce(walletDetailsList, WalletDetails::getIntegral);
     *
     * @param list
     * @return
     */
    public static <T> Integer reduceInt(List<T> list, Function<T, Integer> function) {
        return list.stream().map(function).reduce((sum, number) -> sum + number).orElse(0);
    }

    /**
     * 求和
     * ListsUtil.reduce(walletDetailsList, WalletDetails::getIntegral);
     *
     * @param list
     * @return
     */
    public static <T> Long reduceLong(List<T> list, Function<T, Long> function) {
        return list.stream().map(function).reduce((sum, number) -> sum + number).orElse(0L);
    }


    /**
     * 过滤
     * @param list
     * @param function
     * @param <T>
     * @param <V>
     * @return
     */
    public static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }
}