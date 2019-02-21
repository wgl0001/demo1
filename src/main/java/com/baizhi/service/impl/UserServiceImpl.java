package com.baizhi.service.impl;

import com.baizhi.dao.UserMapper;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userDao;
    @Override
    public List<User> getAll() {
        return userDao.selectAll();
    }

    @Override
    public User login(String username, String password) {
        return userDao.selectByName(username);
    }

    @Override
    public int remove(Integer id) {
        return userDao.deleteByPrimaryKey(id);
    }

    @Override
    public int add(User user) {
        return userDao.insert(user);
    }

    @Override
    public User getById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public int modify(User user) {
        return userDao.updateByPrimaryKey(user);
    }
}
