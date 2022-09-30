package com.htl.service.impl;

import com.htl.dao.UserDao;
import com.htl.pojo.User;
import com.htl.pojo.UserExample;
import com.htl.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author hehehe
 * @ClassName UserServiceImpl
 * @Description TODO
 * @date 2022/4/16 0016 0:49
 * @Version 1.0
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.selectByExample(null);
    }

    @Override
    public User login(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (user.getUsername().contains("@")) {
            criteria.andEmailEqualTo(user.getUsername());
        } else {
            criteria.andUsernameEqualTo(user.getUsername());
        }
        criteria.andPasswordEqualTo(DigestUtils.sha256Hex(user.getPassword()));
        List<User> users = userDao.selectByExample(example);
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public int register(User user) {
        user.setRegistertime(new Date());
        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
        return userDao.insert(user);
    }

    @Override
    public int updUser(User user) {
        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
        return userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public int delUser(User user) {
        return userDao.deleteByPrimaryKey(user.getId());
    }

}
