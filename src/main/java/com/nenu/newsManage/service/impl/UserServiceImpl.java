package com.nenu.newsManage.service.impl;

import com.nenu.newsManage.entity.User;
import com.nenu.newsManage.mapper.UserMapper;
import com.nenu.newsManage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserServiceImpl
 *
 * @author Daydreamer
 * @date 2018/6/24 18:04
 */

@Service("UserService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRES_NEW)
    public void newUser(User user) throws Exception{
        try {
            user.setUserId(user.getUserId());
            user.setUserName(user.getUserName());
            user.setPassword(user.getPassword());
            user.setUserState(user.getUserState());
            userMapper.newUser(user);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRES_NEW)
    public void delUser(Integer userId) throws Exception{
        try{
            userMapper.delUser(userId);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRES_NEW)
    public void updateUser(User user) throws Exception{
        if (user == null){
            return;
        }
        try{
            user.setUserId(user.getUserId());
            user.setUserName(user.getUserName());
            user.setPassword(user.getPassword());
            user.setUserState(user.getUserState());
            userMapper.updateUser(user);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<User> listUser() throws Exception{
        try{
            List<User> userList = userMapper.listUser();
            return userList;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public User queryUserById(Integer userId) throws Exception{
        User user = userMapper.queryUserById(userId);
        System.out.println(user.getUserName());
        return user;
    }

    @Override
    public boolean checkLogin(User user) throws Exception{
        if (user == null){
            return false;
        }
        try {
            return (userMapper.countUserByNameAndPassword(user.getUserName(), user.getPassword())) > 0 ? true : false;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
