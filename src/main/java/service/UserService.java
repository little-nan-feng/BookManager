package service;

import org.apache.ibatis.annotations.Select;
import pojo.User;

public interface UserService {
    public User queryUser(User user);
}
