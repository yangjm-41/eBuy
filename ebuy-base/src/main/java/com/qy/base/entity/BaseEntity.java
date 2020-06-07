package com.qy.base.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qy.base.comm.MyPage;
import com.qy.base.gener.annotations.ColAttr;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
@XmlAccessorType(XmlAccessType.NONE)
@Data
public class BaseEntity extends MyPage  {

    @XmlTransient
    @TableId(value = "id", type = IdType.ID_WORKER_STR)//指定自增策略
    @ColAttr(value = "编号", isFrom = false, columnDefinition = "varchar(60) default '' not null primary key comment '主键'")
    private String id;

    @XmlTransient
    @ApiModelProperty(value = "创建时间", required = false, hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    @ColAttr(value = "创建时间", isFrontCol = false, isFrom = false, columnDefinition = "datetime null comment '创建时间'")
    private Date createDate;

    @XmlTransient
    @ApiModelProperty(value = "更新时间", required = false, hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.UPDATE)
    @ColAttr(value = "更新时间", isFrom = false, columnDefinition = "datetime null comment '更新时间'")
    private Date updateDate;

    @XmlTransient
    @ApiModelProperty(value = "记录状态", notes = "0 未逻辑删除,1逻辑删除", required = false, hidden = true)
    @TableLogic
    @ColAttr(value = "记录状态", isFrom = false, columnDefinition = "tinyint(1) default '0' null comment '逻辑删除,0 未逻辑删除,1逻辑删除'")
    private Integer status = 0;

    @XmlTransient
    @ApiModelProperty(value = "平台标识", notes = "平台标识jashili", required = false, hidden = true)
    @TableField(fill = FieldFill.INSERT)
    @ColAttr(value = "标识", isFrom = false, columnDefinition = "varchar(30) null comment '平台标识'")
    private String platform;

}
