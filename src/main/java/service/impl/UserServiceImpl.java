package service.impl;

import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.User;
import service.UserService;


public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    public User queryUser(User user) {
        return userMapper.queryUser(user);
    }
}
