package book.service;

import book.pojo.User;

public interface UserService {
    User login(String uname, String pwd);

    void regist(User user);

    User getUserByUsername(String uname);
}
