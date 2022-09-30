package com.htl.service;

import com.htl.pojo.User;

import java.util.List;

/**
 * @author hehehe
 * @ClassName StudentService
 * @Description TODO
 * @date 2022/4/16 0016 0:45
 * @Version 1.0
 */
public interface UserService {
    List<User> getAllUser();

    User login(User user);

    int register(User user);

    int updUser(User user);

    int delUser(User user);
}
