package com.nenu.newsManage.entity;

import javax.persistence.*;
import javax.persistence.Column;

/**
 * Column
 *
 * @author Daydreamer
 * @date 2018/6/24 10:26
 */

@Table(name = "t_column")
@Entity
public class Columns {

    @Column(name = "column_id")
    private Integer columnId;

    @Column(name = "columns_name")
    private String columnName;

    @Column(name = "column_state")
    public Integer columnState;

    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getColumnState() {
        return columnState;
    }

    public void setColumnState(Integer columnState) {
        this.columnState = columnState;
    }
}
