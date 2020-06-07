package com.qy.base.util;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.qy.base.entity.BaseEntity;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Author: ebuy
 * @Describe: map工具类
 * @Date: Create in 17:28 2019/11/14
 */
@Data
public class MapsUtil {

    /**
     * list转换成map
     * List<User> userList = Lists.newArrayList();
     * Map<String, String> map = MapsUtil.toMap(userList, User::getId, User::getNickName);
     *
     * @param list      传入的list
     * @param keyFunc   key
     * @param valueFunc value
     * @param <T>
     * @param <K>
     * @param <V>
     * @return
     */
    public static <T, K, V> Map<K, V> toMap(List<T> list,
                                            Function<? super T, ? extends K> keyFunc,
                                            Function<? super T, ? extends V> valueFunc) {
        if (CollectionUtils.isEmpty(list)) {
            return Maps.newHashMap();
        }
        return list.stream().collect(Collectors.toMap(keyFunc, valueFunc, (oldData, newDate) -> newDate));
    }

    /**
     * list转换为map
     * value默认是传入的list泛型对象类型
     * List<User> userList = Lists.newArrayList();
     * Map<String, User> stringUserMap = MapsUtil.toMap(userList, User::getId);
     *
     * @param list    list
     * @param keyFunc key
     * @param <T>
     * @param <K>
     * @return
     */
    public static <T, K> Map<K, T> toMap(List<T> list,
                                         Function<? super T, ? extends K> keyFunc) {
        return toMap(list, keyFunc, Function.identity());
    }

    /**
     * list转换成map
     * key是id
     * value是list泛型对象
     * List<User> userList = Lists.newArrayList();
     * Map<String, User> stringUserMap = MapsUtil.toMap(userList);
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T extends BaseEntity> Map<String, T> toMap(List<T> list) {
        return toMap(list, BaseEntity::getId);
    }

    /**
     * 转换成 ArrayListMultimap
     *
     * @param list
     * @param keyFunc   key
     * @param valueFunc value
     * @param <T>
     * @param <K>
     * @param <V>
     * @return
     */
    public static <T, K, V> ArrayListMultimap<K, V> toMultimap(List<T> list,
                                                               Function<? super T, ? extends K> keyFunc,
                                                               Function<? super T, ? extends V> valueFunc) {
        if (CollectionUtils.isEmpty(list)) {
            return ArrayListMultimap.create();
        }
        ArrayListMultimap<K, V> result = ArrayListMultimap.create();
        list.forEach(data -> result.put(keyFunc.apply(data), valueFunc.apply(data)));
        return result;
    }

    /**
     * 转换成 ArrayListMultimap
     * value是传进来的list泛型对象
     *
     * @param list
     * @param keyFunc key
     * @param <T>
     * @param <K>
     * @return
     */
    public static <T, K> ArrayListMultimap<K, T> toMultimap(List<T> list,
                                                            Function<? super T, ? extends K> keyFunc) {
        return toMultimap(list, keyFunc, Function.identity());
    }

    /**
     * 转换成 ArrayListMultimap
     * key默认是id
     * value默认是传进来的list泛型对象
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T extends BaseEntity> ArrayListMultimap<String, T> toMultimap(List<T> list) {
        return toMultimap(list, BaseEntity::getId);
    }


    /**
     * list转换为List
     * value默认是传入的list泛型对象类型
     * List<User> userList = Lists.newArrayList();
     * Map<String, User> stringUserMap = MapsUtil.toMap(userList, User::getId);
     * 根据 参入的 keyFunc  得到List<Map>
     *
     * @param list    list
     * @param keyFunc key  要获取的value
     * @param <T>
     * @param <K>
     * @return
     */
    public static <T, K> List<K> toMapList(Collection<T> list,
                                           Function<? super T, ? extends K> keyFunc) {

        return list.stream().map(keyFunc).collect(Collectors.toList());
    }


    /**
     * list转换为Set
     * value默认是传入的list泛型对象类型
     * List<User> userList = Lists.newArrayList();
     * Map<String, User> stringUserMap = MapsUtil.toMap(userList, User::getId);
     * 根据 参入的 keyFunc  得到List<Map>
     *
     * @param list    list
     * @param keyFunc key  要获取的value
     * @param <T>
     * @param <K>
     * @return
     */

    public static <T, K> Set<K> toMapSet(Collection<T> list,
                                         Function<? super T, ? extends K> keyFunc) {

        return list.stream().map(keyFunc).collect(Collectors.toSet());
    }
}