package com.nenu.newsManage.service.impl;

import com.nenu.newsManage.entity.Columns;
import com.nenu.newsManage.mapper.ColumnMapper;
import com.nenu.newsManage.service.ColumnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ColumnServiceImpl
 *
 * @author Daydreamer
 * @date 2018/6/24 18:04
 */
@Service("ColumnsService")
public class ColumnServiceImpl implements ColumnsService {

    @Autowired
    private ColumnMapper columnMapper;

    @Override
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRES_NEW)
    public void newColumn(Columns column) throws Exception {
        try {
            column.setColumnId(column.getColumnId());
            column.setColumnName(column.getColumnName());
            column.setColumnState(column.getColumnState());

            columnMapper.newColumn(column);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRES_NEW)
    public void delColumn(Integer columnId) throws Exception {
        try {
            columnMapper.delColumn(columnId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRES_NEW)
    public void updateColumn(Columns column) throws Exception {
        if (column == null) {
            return;
        }
        try {
            column.setColumnId(column.getColumnId());
            column.setColumnName(column.getColumnName());
            column.setColumnState(column.getColumnState());

            columnMapper.updateColumn(column);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Columns> listColumn() throws Exception {
        List<Columns> columnList = columnMapper.listColumn();
        return columnList;
    }

    @Override
    public Columns queryColumnById(Integer columnId) throws Exception {
        if (columnId == null){
            return null;
        }
        try {
            Columns column = columnMapper.queryColumnById(columnId);
            return column;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
