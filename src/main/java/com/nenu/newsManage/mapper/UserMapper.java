package com.nenu.newsManage.mapper;

import com.nenu.newsManage.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserMapper
 *
 * @author Daydreamer
 * @date 2018/6/24 14:39
 */
public interface UserMapper {

    public void newUser(@Param("user")User user) throws Exception;

    public void delUser(@Param("userId")Integer userId) throws Exception;

    public void updateUser(@Param("user")User user) throws Exception;

    public List<User> listUser() throws Exception;

    public User queryUserById(@Param("userId")Integer userId) throws Exception;

    public int countUserName(@Param("userName") String userName) throws Exception;

    public int countUserByNameAndPassword(@Param("userName") String userName,
                                          @Param("password") String password)
            throws Exception;
}
