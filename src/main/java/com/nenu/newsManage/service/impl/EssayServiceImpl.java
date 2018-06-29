package com.nenu.newsManage.service.impl;

import com.nenu.newsManage.entity.Essay;
import com.nenu.newsManage.mapper.ColumnMapper;
import com.nenu.newsManage.mapper.EssayMapper;
import com.nenu.newsManage.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * EssayServiceImpl
 *
 * @author Daydreamer
 * @date 2018/6/24 18:04
 */

@Service("EssayService")
public class EssayServiceImpl implements EssayService{

    @Autowired
    private EssayMapper essayMapper;

    @Autowired
    private ColumnMapper columnMapper;

    @Override
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRES_NEW)
    public void newEssay(Essay essay) throws Exception{
        if (essay == null){
            return;
        }
        try {
            essay.setEssayName(essay.getEssayName());
            essay.setEssayContent(essay.getEssayContent());
            essay.setEssayState(essay.getEssayState());
            essay.setColumnId(essay.getColumnId());
            essay.setColumnName(columnMapper.queryColumnById(essay.getColumnId()).getColumnName());

            essayMapper.newEssay(essay);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRES_NEW)
    public void delEssay(Integer essayId) throws Exception {
        if (essayId == null){
            return;
        }
        essayMapper.delEssay(essayId);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRES_NEW)
    public void delEssayByColumnId(Integer columnId) throws Exception {
        if (columnId == null){
            return;
        }
        essayMapper.delEssayByColumnId(columnId);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRES_NEW)
    public void updateEssay(Essay essay) throws Exception {
        try{
            essay.setEssayId(essay.getEssayId());
            essay.setEssayName(essay.getEssayName());
            essay.setEssayContent(essay.getEssayContent());
            essay.setColumnId(essay.getColumnId());
            essay.setEssayState(essay.getEssayState());
            essay.setColumnName(columnMapper.queryColumnById(essay.getColumnId()).getColumnName());

            essayMapper.updateEssay(essay);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Essay> listEssay(int pageNo, int pageSize) throws Exception {
        List<Essay> essayList = essayMapper.listEssay(pageNo, pageSize);
        return essayList;
    }

    @Override
    public Essay queryEssayById(Integer essayId) throws Exception {
        Essay essay = essayMapper.queryEssayById(essayId);
        if (essay == null){
            System.out.println("要查的文章不存在或已删除");
            return null;
        }
        return essay;
    }

    @Override
    public List<Essay> listEssayByColumnId(int pageNo,
                                           int pageSize,
                                           Integer columnId) throws Exception {
        List<Essay> essayList = essayMapper.listEssayByColumnId(pageNo, pageSize, columnId);
        return essayList;
    }
}
