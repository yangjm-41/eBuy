package com.qy.base.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qy.base.comm.MyPage;
import org.apache.commons.lang3.StringUtils;

import java.util.List;


public class PageUtil {

    private static final String DESC = "desc";

    private static final String ASC = "asc";


    public static IPage convePage(MyPage page) {
        Integer pageNo = page.getPageNo();
        Integer pageSize = page.getPageSize();
        if (pageNo == null) {
            pageNo = 1;
        }
        if (pageSize == null) {
            pageSize = 20;
        }
        Page userPage = new Page<>();
        userPage.setSize(pageSize);
        userPage.setCurrent(pageNo);
        String sort = page.getSortBy();
        String orderBy = page.getOrderBy();
        if (!StringUtils.isEmpty(orderBy)) {
            String s = StringUtil.humpToLine2(orderBy);
            if (DESC.equals(sort)) {
                userPage.setDesc(s);
            } else {
                userPage.setAsc(s);
            }
        }


        return userPage;
    }

    public static IPage convePageNoOrderBy(MyPage page) {
        Integer pageNo = page.getPageNo();
        Integer pageSize = page.getPageSize();
        if (pageNo == null) {
            pageNo = 1;
        }
        if (pageSize == null) {
            pageSize = 20;
        }
        Page userPage = new Page<>();
        userPage.setSize(pageSize);
        userPage.setCurrent(pageNo);
        return userPage;
    }

    public static IPage newConvePage(MyPage page) {
        Integer pageNo = page.getPageNo();
        Integer pageSize = page.getPageSize();
        if (pageNo == null) {
            pageNo = 1;
        }
        if (pageSize == null) {
            pageSize = 20;
        }
        Page userPage = new Page<>();
        userPage.setSize(pageSize);
        userPage.setCurrent(pageNo);

        return userPage;
    }


    public static <T> IPage<T> convePage(Integer page, Integer size) {
        Page userPage = new Page<>();
        userPage.setSize(size);
        userPage.setCurrent(page);
        return userPage;
    }

    /**
     * 通用逻辑分页
     *
     * @param list
     * @param pageNo
     * @param pageSize
     * @param <T>
     * @return
     */
    public static <T> IPage<T> logisPage(List<T> list, Integer pageNo, Integer pageSize) {
        List<T> ts = ListPagingUtil.listPaging(list, pageNo, pageSize);
        Page userPage = new Page<>();
        userPage.setSize(pageSize);
        userPage.setCurrent(pageNo);
        userPage.setRecords(ts);
        userPage.setTotal(ts.size());
        return userPage;
    }
}
