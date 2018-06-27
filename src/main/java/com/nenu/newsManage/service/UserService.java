package com.nenu.newsManage.service;

import com.nenu.newsManage.entity.User;

import java.util.List;

/**
 * UserService
 *
 * @author Daydreamer
 * @date 2018/6/24 11:05
 */
public interface UserService {

    /**
     * 新建用户
     *
     * @param user
     * @throws Exception
     */
    public void newUser(User user) throws Exception;

    /**
     * 删除用户
     *
     * @param userId
     * @throws Exception
     */
    public void delUser(Integer userId) throws Exception;

    /**
     * 修改用户信息
     *
     * @param user
     * @throws Exception
     */
    public void updateUser(User user) throws Exception;

    /**
     * 查询用户列表
     *
     * @return
     * @throws Exception
     */
    public List<User> listUser() throws Exception;

    /**
     * 根据用户Id查询用户信息
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public User queryUserById(Integer userId) throws Exception;

    /**
     * 检察用户是否正确登录
     *
     * @param user
     * @return
     * @throws Exception
     */
    public boolean checkLogin(User user) throws Exception;
}
