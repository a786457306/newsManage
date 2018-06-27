package com.nenu.newsManage.service;

import com.nenu.newsManage.entity.Columns;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ColumnsService
 *
 * @author Daydreamer
 * @date 2018/6/24 11:07
 */
public interface ColumnsService {

    /**
     * 新增栏目
     *
     * @param column
     * @throws Exception
     */
    public void newColumn(Columns column) throws Exception;

    /**
     * 删除栏目
     *
     * @param columnId
     * @throws Exception
     */
    public void delColumn(Integer columnId) throws Exception;

    /**
     * 修改栏目信息
     *
     * @param column
     * @throws Exception
     */
    public void updateColumn(Columns column) throws Exception;

    /**
     * 查询所有栏目
     *
     * @return
     * @throws Exception
     */
    public List<Columns> listColumn() throws Exception;

    /**
     * 根据栏目Id查询栏目信息
     *
     * @param columnId
     * @return
     * @throws Exception
     */
    public Columns queryColumnById(Integer columnId) throws Exception;
}
