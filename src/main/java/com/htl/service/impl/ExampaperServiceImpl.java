package com.htl.service.impl;

import com.htl.dao.*;
import com.htl.pojo.Exampaper;
import com.htl.pojo.ExampaperExample;
import com.htl.pojo.User;
import com.htl.pojo.domain.*;
import com.htl.service.ExampaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hehehe
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @date 2022/4/16 0016 0:49
 * @Version 1.0
 */

@Service
@Transactional
public class ExampaperServiceImpl implements ExampaperService {

    @Autowired
    private ExampaperDao exampaperDao;
    @Autowired
    private ExampaperQuestionKeyDao exampaperQuestionKeyDao;
    @Autowired
    private ExampaperUserKeyDao exampaperUserKeyDao;
    @Autowired
    private ClazzExampaperKeyDao clazzExampaperKeyDao;
    @Autowired
    private ClazzUserKeyDao clazzUserKeyDao;
    @Autowired
    private MypaperviewDao mypaperviewDao;
    @Autowired
    private MyexamviewDao myexamviewDao;
    @Autowired
    private ExampaperquestionviewDao exampaperquestionviewDao;


    @Override
    public List<Exampaper> getPaper(User user) {
        ExampaperUserKeyExample example1 = new ExampaperUserKeyExample();
        ExampaperUserKeyExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andUIdEqualTo(user.getId());
        List<ExampaperUserKeyKey> exampaperStudentKeyKeys = exampaperUserKeyDao.selectByExample(example1);
        if (exampaperStudentKeyKeys.isEmpty()) {
            return null;
        }
        ExampaperExample example = new ExampaperExample();
        ExampaperExample.Criteria criteria = example.createCriteria();
        List<Integer> list = new ArrayList<>();
        for (ExampaperUserKeyKey e : exampaperStudentKeyKeys) {
            list.add(e.geteId());
        }
        criteria.andIdIn(list);
        List<Exampaper> exampapers = exampaperDao.selectByExample(example);
        return exampapers.size() > 0 ? exampapers : null;
    }

    @Override
    public List<Mypaperview> getPaperByUidLimit(User user, long begin, int num) {
        MypaperviewExample example = new MypaperviewExample();
        MypaperviewExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(user.getId());
        example.setOffset(begin < 0 ? 0 : begin);
        example.setLimit(num);
        List<Mypaperview> mypaperviews = mypaperviewDao.selectByExample(example);
        return mypaperviews.size() > 0 ? mypaperviews : null;
    }

    @Override
    public int addExamOrPaper(Exampaper exampaper) {
        exampaper.setCreattime(new Date());
        return exampaperDao.insert(exampaper);
    }

    @Override
    public long countPaperByUid(User user) {
        MypaperviewExample example = new MypaperviewExample();
        example.createCriteria().andUidEqualTo(user.getId());
        return mypaperviewDao.countByExample(example);
    }

    @Override
    public long countExamByUid(User user) {
        MyexamviewExample example = new MyexamviewExample();
        example.createCriteria().andUidEqualTo(user.getId());
        return myexamviewDao.countByExample(example);
    }

    @Override
    public List<Exampaperquestionview> loadPaperQuestion(Exampaper exampaper) {
        ExampaperquestionviewExample example = new ExampaperquestionviewExample();
        example.createCriteria().andEidEqualTo(exampaper.getId());
        return exampaperquestionviewDao.selectByExample(example);
    }

    @Override
    public int delExamPaperById(Exampaper exampaper) {
        ExampaperQuestionKeyExample example = new ExampaperQuestionKeyExample();
        example.createCriteria().andEIdEqualTo(exampaper.getId());
        exampaperQuestionKeyDao.deleteByExample(example);
        return exampaperDao.deleteByPrimaryKey(exampaper.getId());
    }

    @Override
    public List<Myexamview> searchExam(User user) {
        MyexamviewExample example = new MyexamviewExample();
        MyexamviewExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(user.getId());
        criteria.andExampapernameLike(user.getUsername());
        List<Myexamview> mypaperviews = myexamviewDao.selectByExample(example);
        return mypaperviews.size() > 0 ? mypaperviews : null;
    }

    @Override
    public List<Mypaperview> searchPaper(String name, String creatPerson) {
        MypaperviewExample example = new MypaperviewExample();
        MypaperviewExample.Criteria criteria = example.createCriteria();
        criteria.andCreatpersonEqualTo(creatPerson);
        criteria.andExampapernameLike(name);
        List<Mypaperview> mypaperviews = mypaperviewDao.selectByExample(example);
        return mypaperviews.size() > 0 ? mypaperviews : null;
    }

    @Override
    public int updExamOrPaper(Exampaper exampaper) {
        return exampaperDao.updateByPrimaryKeySelective(exampaper);
    }

    @Override
    public List<Exampaper> getExamOrPaperID(Exampaper exampaper) {
        ExampaperExample example = new ExampaperExample();
        ExampaperExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(exampaper.getName());
        criteria.andCreatpersonEqualTo(exampaper.getCreatperson());
        return exampaperDao.selectByExample(example);
    }

    @Override
    public List<Myexamview> getExamByUidLimit(User user, long begin, int num) {
        MyexamviewExample example = new MyexamviewExample();
        MyexamviewExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(user.getId());
        example.setOffset(begin);
        example.setLimit(num);
        List<Myexamview> myexamviews = myexamviewDao.selectByExample(example);
        return myexamviews.size() > 0 ? myexamviews : null;
    }

    @Override
    public List<Exampaper> getExam(User user) {
        ClazzUserKeyExample clazzUserKeyExample = new ClazzUserKeyExample();
        ClazzUserKeyExample.Criteria criteria1 = clazzUserKeyExample.createCriteria();
        criteria1.andUIdEqualTo(user.getId());
        List<ClazzUserKeyKey> clazzUserKeyKeys = clazzUserKeyDao.selectByExample(clazzUserKeyExample);
        if (clazzUserKeyKeys.isEmpty()) {
            return null;
        }

        ClazzExampaperKeyExample clazzExampaperKeyExample = new ClazzExampaperKeyExample();
        ClazzExampaperKeyExample.Criteria criteria = clazzExampaperKeyExample.createCriteria();
        List<Integer> list2 = new ArrayList<>();
        for (ClazzUserKeyKey c : clazzUserKeyKeys) {
            list2.add(c.getcId());
        }
        criteria.andCIdIn(list2);
        List<ClazzExampaperKeyKey> clazzExampaperKeyKeys = clazzExampaperKeyDao.selectByExample(clazzExampaperKeyExample);
        if (clazzExampaperKeyKeys.isEmpty()) {
            return null;
        }

        ExampaperExample example = new ExampaperExample();
        ExampaperExample.Criteria criteria2 = example.createCriteria();

        List<Integer> list = new ArrayList<>();
        for (ClazzExampaperKeyKey c : clazzExampaperKeyKeys) {
            list.add(c.geteId());
        }
        criteria2.andIdIn(list);
        List<Exampaper> exampapers = exampaperDao.selectByExample(example);
        return exampapers.size() > 0 ? exampapers : null;
    }

}
