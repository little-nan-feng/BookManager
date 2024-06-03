package dao;

import org.apache.ibatis.annotations.*;
import pojo.User;

public interface UserMapper {

    @Select("select * from tb_user where number=#{number} and password=#{password}"
            + "and identity =#{identity}")
    User queryUser(User user);
}
