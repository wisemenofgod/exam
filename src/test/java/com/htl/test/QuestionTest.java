package com.htl.test;

import com.htl.dao.ClazzDao;
import com.htl.dao.QuestionDao;
import com.htl.pojo.Clazz;
import com.htl.pojo.Question;
import com.htl.pojo.QuestionExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author hehehe
 * @ClassName QuestionTest
 * @Description TODO
 * @date 2022/4/19 0019 17:11
 * @Version 1.0
 */

public class QuestionTest {

    @Test
    public void insert(){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
        QuestionDao questionDao = (QuestionDao) applicationContext.getBean("questionDao");
        Question q=new Question();
        q.setqName("qwe?");
        q.setqAns("123");
        q.setqType(4);
        q.setCreatperson(1);
        int i = questionDao.insertSelective(q);
        System.out.println(i);
    }
    @Test
    public void getQuestionID(){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
        QuestionDao questionDao = (QuestionDao) applicationContext.getBean("questionDao");
        Question q=new Question();
        q.setqName("123123123");
        q.setqAns("A");
        q.setqType(1);
        q.setCreatperson(1);
        QuestionExample example=new QuestionExample();
        example.createCriteria().andQNameEqualTo(q.getqName());
        example.createCriteria().andQAnsEqualTo(q.getqAns());
        example.createCriteria().andCreatpersonEqualTo(q.getCreatperson());
        List<Question> questions = questionDao.selectByExample(example);
        System.out.println(questions);
    }
}
