package com.nenu.newsManage.service;

import com.nenu.newsManage.entity.Essay;

import java.util.List;

/**
 * EssayService
 *
 * @author Daydreamer
 * @date 2018/6/24 11:06
 */
public interface EssayService {

    /**
     * 新建文章
     *
     * @param essay
     * @throws Exception
     */
    public void newEssay(Essay essay) throws Exception;

    /**
     * 根据文章id删除文章
     *
     * @param essayId
     * @throws Exception
     */
    public void delEssay(Integer essayId) throws Exception;

    /**
     * 根据栏目id删除栏目下所有文章
     *
     * @param columnId
     * @throws Exception
     */
    public void delEssayByColumnId(Integer columnId) throws Exception;

    /**
     * 修改文章相关信息
     *
     * @param essay
     * @throws Exception
     */
    public void updateEssay(Essay essay) throws Exception;

    /**
     * 查询所有文章
     *
     * @return
     * @throws Exception
     */
    public List<Essay> listEssay() throws Exception;

    /**
     * 分页查询所有文章
     *
     * @param pageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<Essay> listEssayByPage(int pageNo,
                                       int pageSize) throws Exception;

    /**
     * 根据文章id查询文章
     *
     * @param essayId
     * @return
     * @throws Exception
     */
    public Essay queryEssayById(Integer essayId) throws Exception;

    /**
     * 根据栏目id查询栏目下所有文章
     *
     * @param columnId
     * @return
     * @throws Exception
     */
    public List<Essay> listEssayByColumnId(Integer columnId) throws Exception;

    /**
     * 根据栏目id查询栏目下所有文章并分页
     *
     * @param pageNo
     * @param pageSize
     * @param columnId
     * @return
     * @throws Exception
     */
    public List<Essay> listEssayByColumnIdByPage(int pageNo,
                                                 int pageSize,
                                                 Integer columnId) throws Exception;
}
