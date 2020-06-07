package com.qy.base.comm;


import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qy.base.util.DateUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 公用分页对象
 */
@ApiModel(value = "分页对象", description = "分页对象")
@Data
@XmlAccessorType(XmlAccessType.NONE)
public class MyPage extends Object implements Serializable {

    @XmlTransient
    @TableField(exist = false)
    @ApiModelProperty(value = "当前页", example = "1")
    private Integer pageNo = 1;

    @XmlTransient
    @TableField(exist = false)
    @ApiModelProperty(value = "每页查询记录数", example = "20")
    private Integer pageSize = 20;

    @XmlTransient
    @TableField(exist = false)
    @ApiModelProperty(value = "排序方式(asc/desc)", example = "desc")
    private String sortBy = "desc";

    @XmlTransient
    @TableField(exist = false)
    @ApiModelProperty(value = "排序字段名", example = "id")
    private String orderBy = "update_date";

    @XmlTransient
    @TableField(exist = false)
    @ApiModelProperty(value = "数据起始时间", example = "beginDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginDate;

    @XmlTransient
    @TableField(exist = false)
    @ApiModelProperty(value = "数据结束时间", example = "endDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;


    public String getSortBy() {
        if (sortBy == null) {
            return "desc";
        }
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }


    @JSONField(serialize = false)
    @JsonIgnore
    public MyPage getPage() {
        MyPage myPage = new MyPage();
        myPage.setSortBy(this.getSortBy());
        myPage.setPageSize(this.getPageSize());
        myPage.setPageNo(this.getPageNo());
        myPage.setBeginDate(this.getBeginDate());
        myPage.setEndDate(this.getEndDate());
        myPage.setOrderBy(this.getOrderBy());
        return myPage;
    }


    //    @JsonIgnore
    public String getOrderBy() {
        if (orderBy == null) {
            return "update_date";
        }
        return orderBy;
    }

    //    @JsonIgnore
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    //    @JsonIgnore
    public boolean isBetween() {
        return beginDate != null && endDate != null;
    }

    //    @JsonIgnore
    public Date getBeginDate() {
        return beginDate;
    }

    //    @JsonIgnore
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    //    @JsonIgnore
    public Date getEndDate() {
        return endDate;
    }

    //    @JsonIgnore
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    //    @JsonIgnore
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    //    @JsonIgnore
    public Integer getPageNo() {
        if (pageNo == null) {
            pageNo = 1;
        }
        return pageNo;
    }

    //    @JsonIgnore
    public Integer getPageSize() {
        if (pageSize == null) {
            pageSize = 20;
        }
        return pageSize;
    }

    @JsonIgnore
    public <V> Page<V> converPage() {
        Page<V> userPage = new Page<>();
        userPage.setSize(pageSize == null ? 20 : this.getPageSize());
        userPage.setCurrent((pageNo == null) || (pageNo == 0) || (pageNo < 0) ? 1 : this.getPageNo());
        return userPage;
    }

    @JsonIgnore
    public <V> Page<V> converPage(Page page) {
        Page<V> userPage = new Page<>();
        BeanUtils.copyProperties(page, userPage);
        return userPage;
    }

    @JsonIgnore
    public <V> Page<V> converPage(IPage page, List<V> record) {
        Page<V> userPage = new Page<>();
        userPage.setTotal(page.getTotal());
        userPage.setRecords(record);
        userPage.setCurrent(page.getCurrent());
        userPage.setSize(page.getSize());
        return userPage;
    }


    public void converSort(QueryWrapper userQueryWrapper) {

        if (StringUtils.isNotBlank(this.getOrderBy()) && StringUtils.isNotBlank(this.getSortBy())) {
            return;
        }

        if (StringUtils.equalsIgnoreCase(this.getSortBy(), "asc")) {
            userQueryWrapper.orderByAsc(this.getOrderBy());
        } else {
            userQueryWrapper.orderByDesc(this.getOrderBy());
        }

    }

    /**
     * 添加创建时间查询条件
     *
     * @param queryWrapper
     */
    public void addCreateTimeWrapper(QueryWrapper queryWrapper) {
        if (isBetween()) {
            queryWrapper.between("create_date", DateUtils.formatDate(beginDate), DateUtils.formatDate(endDate));
        }
    }
}
