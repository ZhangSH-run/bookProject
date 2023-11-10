package book.mapper;

import book.pojo.User;


public interface UserMapper {
    User getUserByUserName(String uname);

    void addUser(User user);
}
