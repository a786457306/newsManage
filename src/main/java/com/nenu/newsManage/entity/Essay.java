package com.nenu.newsManage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Essay
 *
 * @author Daydreamer
 * @date 2018/6/24 10:26
 */

@Table(name = "t_essay")
@Entity
public class Essay {

    @Column(name = "essay_id")
    private Integer essayId;

    @Column(name = "essay_name")
    private String essayName;

    @Column(name = "essay_content")
    private String essayContent;

    @Column(name = "column_id")
    private Integer columnId;

    private String columnName;

    @Column(name = "essay_state")
    private Integer essayState;

    public Integer getEssayId() {
        return essayId;
    }

    public void setEssayId(Integer essayId) {
        this.essayId = essayId;
    }

    public String getEssayName() {
        return essayName;
    }

    public void setEssayName(String essayName) {
        this.essayName = essayName;
    }

    public String getEssayContent() {
        return essayContent;
    }

    public void setEssayContent(String essayContent) {
        this.essayContent = essayContent;
    }

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

    public Integer getEssayState() {
        return essayState;
    }

    public void setEssayState(Integer essayState) {
        this.essayState = essayState;
    }
}
