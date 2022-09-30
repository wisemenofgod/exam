package com.htl.test;

import com.htl.dao.ExampaperhistoryviewDao;
import com.htl.pojo.User;
import com.htl.pojo.domain.Exampaperhistory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author hehehe
 * @ClassName getDoExamHistoryTest
 * @Description TODO
 * @date 2022/5/4 0004 22:38
 * @Version 1.0
 */

public class getDoExamHistoryTest {

    @Test
    public void getDoExamHistoryTest1() {
        User user = new User();
        user.setId(1);
        user.setUsername("小明");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ExampaperhistoryviewDao e = (ExampaperhistoryviewDao) applicationContext.getBean("exampaperhistoryviewDao");
        List<Exampaperhistory> doExamHistory = e.getDoExamHistory(user);
        for (Exampaperhistory eh : doExamHistory) {
            System.out.println(eh);
        }
    }

    @Test
    public void getDoExamHistoryTest2() {
        User user = new User();
        user.setId(1);
        user.setUsername("小明");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ExampaperhistoryviewDao e = (ExampaperhistoryviewDao) applicationContext.getBean("exampaperhistoryviewDao");
        List<Exampaperhistory> doPaperHistory = e.getDoPaperHistory(user);
        for (Exampaperhistory eh : doPaperHistory) {
            System.out.println(eh);
        }
    }
}
