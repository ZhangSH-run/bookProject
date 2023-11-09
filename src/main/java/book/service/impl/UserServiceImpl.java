package book.service.impl;

import book.mapper.UserMapper;
import book.pojo.User;
import book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String uname, String pwd) {
        User user = userMapper.getUserByUserName(uname);
        if (user == null){
            throw new RuntimeException("账号或密码错误！");
        }
        if (!user.getPwd().equals(pwd)){
            throw new RuntimeException("账号或密码错误！");
        }
        return user;
    }
}
