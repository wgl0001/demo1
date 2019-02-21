package com.baizhi.service;

import com.baizhi.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> getAll();

    User login(String username,String password);

    int remove(Integer id);

    int add(User user);

    User getById(Integer id);

    int modify(User user);
}
