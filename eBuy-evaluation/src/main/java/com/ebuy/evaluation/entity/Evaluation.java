package com.ebuy.evaluation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "tb_evaluation")//指定表名
public class Evaluation {
    @TableId(value = "id",type = IdType.UUID)//指定自增策略
    private String id;
    @TableField(value = "user_id",exist = true)
    private String user_id;
    @TableField(value = "merchant_id",exist = true)
    private String merchant_id;
    @TableField(value = "content",exist = true)
    private String content;
    @TableField(value = "level",exist = true)
    private Integer level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
