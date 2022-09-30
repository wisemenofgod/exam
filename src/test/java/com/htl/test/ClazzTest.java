package com.htl.test;

import com.htl.dao.ClazzDao;
import com.htl.pojo.Clazz;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author hehehe
 * @ClassName ClazzTest
 * @Description TODO
 * @date 2022/4/18 0018 19:06
 * @Version 1.0
 */

public class ClazzTest {



    @Test
    public void updateTest() {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
        ClazzDao clazzDao = (ClazzDao) applicationContext.getBean("clazzDao");
        Clazz clazz = new Clazz();
        clazz.setId(3);
        clazz.setcDetails("大学英语兴趣班");
        int i = clazzDao.updateByPrimaryKeySelective(clazz);
        System.out.println(i);
    }
}
