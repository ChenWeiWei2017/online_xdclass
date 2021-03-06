package xyz.chenww.online_xdclass.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import xyz.chenww.online_xdclass.model.entity.User;
import xyz.chenww.online_xdclass.utils.CommonUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SpringBootTest
@Slf4j
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setName("大乔1");
        user.setPwd(CommonUtil.MD5("123456"));
        user.setHeadImg(CommonUtil.getRandomHeadImg());
        user.setPhone("564534451");
        user.setCreateTime(new Date());
        try {
            userMapper.addUser(user);
            log.info("新增成功，新用户ID为：" + user.getId());
        } catch (DuplicateKeyException e) {
            log.error("用户名或手机号已存在！" , e);
        }
    }

    @Test
    public void testSelectUser() {
        User user = new User();
//        user.setId(17);
        user.setName("陈伟伟");
        user.setPwd(CommonUtil.MD5("123456@Abc"));
        List<User> users = userMapper.selectByScope(user);
        System.out.println(users);
    }
}
