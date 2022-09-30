package com.htl.test;

import com.htl.dao.UserDao;
import com.htl.pojo.User;
import com.htl.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AppTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        List<User> users = userDao.selectByExample(null);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testService(){
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServiceImpl = (UserService) applicationContext.getBean("userServiceImpl");
        List<User> users = userServiceImpl.getAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }
}


