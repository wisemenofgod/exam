package com.htl.service.impl;

import com.htl.dao.MyquestionviewDao;
import com.htl.dao.QuestionDao;
import com.htl.pojo.Question;
import com.htl.pojo.QuestionExample;
import com.htl.pojo.User;
import com.htl.pojo.domain.Myquestionview;
import com.htl.pojo.domain.MyquestionviewExample;
import com.htl.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hehehe
 * @ClassName QuestionServiceImpl
 * @Description TODO
 * @date 2022/4/17 0017 22:38
 * @Version 1.0
 */

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private MyquestionviewDao myquestionviewDao;
    @Autowired
    private QuestionDao questionDao;

    @Override
    public List<Myquestionview> getQuestionByLimit(User user, long begin, int num) {
        MyquestionviewExample myquestionviewExample = new MyquestionviewExample();
        MyquestionviewExample.Criteria criteria = myquestionviewExample.createCriteria();
        criteria.andUidEqualTo(user.getId());
        myquestionviewExample.setOffset(begin < 0 ? 0 : begin);
        myquestionviewExample.setLimit(num);
        List<Myquestionview> myquestionviews = myquestionviewDao.selectByExample(myquestionviewExample);
        return myquestionviews.isEmpty() ? null : myquestionviews;
    }

    @Override
    public int delQuestionById(Question question) {
        return questionDao.deleteByPrimaryKey(question.getId());
    }

    @Override
    public int updQuestion(Question question) {
        return questionDao.updateByPrimaryKeySelective(question);
    }

    @Override
    public int addQuestion(Question question) {
        return questionDao.insertSelective(question);
    }

    @Override
    public long countQuestionByUid(User user) {
        MyquestionviewExample myquestionviewExample = new MyquestionviewExample();
        MyquestionviewExample.Criteria criteria = myquestionviewExample.createCriteria();
        criteria.andUidEqualTo(user.getId());
        return myquestionviewDao.countByExample(myquestionviewExample);
    }

    @Override
    public List<Question> getQuestionID(Question question) {
        QuestionExample example = new QuestionExample();
        QuestionExample.Criteria criteria = example.createCriteria();
        criteria.andQNameEqualTo(question.getqName());
        criteria.andQAnsEqualTo(question.getqAns());
        criteria.andQTypeEqualTo(question.getqType());
        criteria.andCreatpersonEqualTo(question.getCreatperson());
        return questionDao.selectByExample(example);
    }

    @Override
    public Myquestionview getQuestionById(Question question) {
        MyquestionviewExample example = new MyquestionviewExample();
        MyquestionviewExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(question.getId());
        return myquestionviewDao.selectByExample(example).get(0);
    }

    @Override
    public List<Myquestionview> searchQuestion(User user) {
        MyquestionviewExample myquestionviewExample = new MyquestionviewExample();
        MyquestionviewExample.Criteria criteria = myquestionviewExample.createCriteria();
        criteria.andUidEqualTo(user.getId());
        criteria.andQuestionLike(user.getUsername());
        List<Myquestionview> myquestionviews = myquestionviewDao.selectByExample(myquestionviewExample);
        return myquestionviews.isEmpty() ? null : myquestionviews;
    }

}
