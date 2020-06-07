package com.qy.base.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qy.base.comm.ResponseCode;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

/**
 * 公用返回对象
 * @param <T>
 */
@Slf4j
@ApiModel(value = "返回对象", description = "返回对象")
@Data
public class MyResult<T> implements Serializable {

    /**
     * 前端提示错误信息
     */
    private String errmsg;

    private Integer errno;

    private Data<T> data;

    /**
     * 详细错误信息
     */
    private String detailMessage;

    /**
     * debug信息
     */
    private String debugMessage;


    public MyResult() {
        this.errmsg = ResponseCode.SUCCESS.getMsg();
        this.errno = ResponseCode.SUCCESS.getCode();
        this.data = new Data<>();
        this.data.entity = (T) new JSONObject();
        this.data.list = (List<T>) new JSONArray();
        this.data.pageNo = 1L;
        this.data.pageSize = 20L;
        this.data.total = 0L;
    }


    public MyResult(IPage<T> page) {
        this.errmsg = ResponseCode.SUCCESS.getMsg();
        this.errno = ResponseCode.SUCCESS.getCode();
        this.data = new Data<>();
        this.data.entity = (T) new JSONObject();
        if (page == null) {
            this.data.list = (List<T>) new JSONArray();
            this.data.pageNo = 1L;
            this.data.pageSize = 20L;
            this.data.total = 0L;
        } else {
            this.data.list = page.getRecords();
            this.data.pageNo = page.getCurrent();
            this.data.pageSize = page.getSize();
            this.data.total = page.getTotal();
        }
    }

    public MyResult(T entity) {
        this.data = new Data<>();
        this.errmsg = ResponseCode.SUCCESS.getMsg();
        this.errno = ResponseCode.SUCCESS.getCode();
        this.data.pageNo = 1L;
        this.data.pageSize = 20L;
        this.data.total = 0L;
        if (entity instanceof List) {
            this.data.entity = (T) new JSONObject();
            this.data.list = (List<T>) entity;
        } else {
            this.data.entity = entity;
            this.data.list = (List<T>) new JSONArray();
        }
    }

    /**
     * 如果是要给单独的列表是否返回跟pageable的格式，用作其它系统返回结果作适配
     *
     * @param isPageList
     */
    public MyResult(List<T> list, boolean isPageList) {
        if (isPageList) {
            this.errmsg = ResponseCode.SUCCESS.getMsg();
            this.errno = ResponseCode.SUCCESS.getCode();
            this.data = new Data<>();
            this.data.entity = (T) new JSONObject();
            this.data.list = list;
            this.data.pageNo = 1L;
            this.data.pageSize = 20L;
            this.data.total = Long.valueOf(list.size());
        }
    }


    public void setEntity(T entity) {
        this.data.entity = entity;
    }

    public void setItems(List<T> items) {
        this.data.list = items;
    }

    public MyResult entityNotFount() {
        this.errmsg = ResponseCode.INVALID_PARAMETER.getMsg();
        this.errno = ResponseCode.INVALID_PARAMETER.getCode();
        return this;
    }


    public MyResult ok() {
        this.errmsg = ResponseCode.SUCCESS.getMsg();
        this.errno = ResponseCode.SUCCESS.getCode();
        return this;
    }

    public MyResult ok(Integer code) {
        this.errmsg = ResponseCode.SUCCESS.getMsg();
        this.errno = code;
        return this;
    }


    public MyResult ok(String msg) {
        this.errmsg = msg;
        this.errno = ResponseCode.SUCCESS.getCode();
        return this;
    }


    public MyResult faild(String msg) {
        this.errmsg = msg;
        this.errno = ResponseCode.INVALID_PARAMETER.getCode();
        return this;
    }

    public MyResult faild(String msg, Integer code) {
        this.errmsg = msg;
        this.errno = code;
        return this;
    }

    public MyResult faild(ResponseCode responseCode) {
        this.errmsg = responseCode.getMsg();
        this.errno = responseCode.getCode();
        return this;
    }





    public Integer getErrno() {
        return this.errno;
    }

    public String getMsg() {
        return this.errmsg;
    }

    @lombok.Data
    public static class Data<T> {
        private Long total;

        private Long pageNo;

        private Long pageSize;

        private T entity;

        private List<T> list;
    }




}
