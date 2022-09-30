package com.htl.test;

import com.htl.dao.UserDao;
import com.htl.pojo.User;
import com.htl.pojo.UserExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    private SqlSession sqlSession;
    private UserDao userDao;

//    @Before
    public void init() throws IOException {
        //获取流对象，读取核心配置文件
        InputStream is = Resources.getResourceAsStream("other/mybatis-config.xml");

        //创建SqlSession工厂构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        //获取SqlSession工厂对象
        SqlSessionFactory factory = builder.build(is);

        //获取SqlSession对象
        sqlSession = factory.openSession();

        //获取StudentDao代理类对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

//    @After
    public void close() {
        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

//    @Test
    public void findAll() {
        //调用查询所有的方法

        List<User> list = userDao.selectByExample(null);

        for (User User : list) {
            System.out.println(User);
        }
    }

//    @Test
    public void testExample() {
        //调用查询所有的方法

        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameLike("小%");
        criteria.andIdEqualTo(2);

        List<User> users = userDao.selectByExample(userExample);
        for (User user : users) {
            System.out.println(user);
        }


    }

}