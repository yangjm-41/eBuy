package com.qy.base.gener;

import lombok.Data;

import java.util.List;

/**
 * @Author: ebuy
 * @Describe:
 * @Date: Create in 16:29 2019/4/25
 */
@Data
public class TableInfo {

    private String tableName;

    private String comment;

    private String engine;

    private Boolean isCreate;

    private List<Column> columnList;

}
