package com.qy.base.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 手动分页
 */
public class ListPagingUtil {

    /**
     * 逻辑分页
     * @param list 进行分页的list
     * @param pageNo 页码
     * @param pageSize 每页显示条数
     * @return 分页后数据
     */
    public static <T> List<T> listPaging(List<T> list, Integer pageNo, Integer pageSize){
        if(list == null){
            list = new ArrayList<T>();
        }
        if(pageNo == null){
            pageNo = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        if(pageNo <= 0){
            pageNo = 1;
        }

        int totalitems = list.size();
        List<T> pagingList = new ArrayList<T>();

        int totalNum = ((pageNo - 1) * pageSize) + pageSize > totalitems ? totalitems : ((pageNo - 1) * pageSize) + pageSize;
        for(int i = (pageNo-1)*pageSize; i < totalNum; i++) {
            pagingList.add(list.get(i));
        }
        return pagingList;
    }
}
