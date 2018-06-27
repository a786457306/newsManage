package com.nenu.newsManage.mapper;

import com.nenu.newsManage.entity.Essay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * EssayMapper
 *
 * @author Daydreamer
 * @date 2018/6/24 14:39
 */
public interface EssayMapper {

    public void newEssay(@Param("essay") Essay essay) throws Exception;

    public void delEssay(@Param("essayId") Integer essayId) throws Exception;

    public void delEssayByColumnId(@Param("columnId") Integer columnId) throws Exception;

    public void updateEssay(@Param("essay") Essay essay) throws Exception;

    public List<Essay> listEssay() throws Exception;

    public List<Essay> listEssayByPage(@Param("offset") int offset,
                                       @Param("pageSize") int pageSize) throws Exception;

    public List<Essay> listEssayByColumnId(@Param("columnId") Integer columnId) throws Exception;

    public List<Essay> listEssayByColumnIdByPage(@Param("offset") int offset,
                                                 @Param("pageSize") int pageSize,
                                                 @Param("columnId") Integer columnId) throws Exception;

    public Essay queryEssayById(@Param("essayId") Integer essayId) throws Exception;
}
