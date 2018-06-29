package com.nenu.newsManage.mapper;

import com.nenu.newsManage.entity.Columns;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ColumnMapper
 *
 * @author Daydreamer
 * @date 2018/6/24 14:39
 */
public interface ColumnMapper {

    public void newColumn(@Param("column") Columns column) throws Exception;

    public void delColumn(@Param("columnId") Integer columnId) throws Exception;

    public void updateColumn(@Param("column") Columns column) throws Exception;

    public List<Columns> listColumn() throws Exception;

    public Columns queryColumnById(@Param("columnId") Integer columnId) throws Exception;

    public int countColumnByName(@Param("columnName") String columnName) throws Exception;
}
