package com.ebuy.user.service.impl;

import com.ebuy.user.dao.UserDao;
import com.ebuy.user.entity.User;
import com.ebuy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        return userDao.getUserList();
    }
}
