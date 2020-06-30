package xyz.chenww.online_xdclass.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import xyz.chenww.online_xdclass.model.entity.User;

public interface UserMapper {

    @Insert("insert into user(name, pwd, head_img, phone, create_time) values(#{name}, #{pwd}, #{headImg}, #{phone}, #{createTime})")
    // 如果数据新增成功，将新增的数据的自增ID值传递到参数对象中
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void addUser(User user);
}
