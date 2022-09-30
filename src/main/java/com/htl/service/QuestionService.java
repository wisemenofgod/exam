package com.htl.service;

import com.htl.pojo.Question;
import com.htl.pojo.User;
import com.htl.pojo.domain.Myquestionview;

import java.util.List;

/**
 * @author hehehe
 * @ClassName QuestionService
 * @Description TODO
 * @date 2022/4/17 0017 22:37
 * @Version 1.0
 */

public interface QuestionService {

    List<Myquestionview> getQuestionByLimit(User user, long begin, int num);

    int delQuestionById(Question question);

    int updQuestion(Question question);

    int addQuestion(Question question);

    long countQuestionByUid(User user);

    List<Question> getQuestionID(Question question);

    Myquestionview getQuestionById(Question question);

    List<Myquestionview> searchQuestion(User user);
}
