package com.htl.service.impl;

import com.htl.dao.ExampaperhistoryviewDao;
import com.htl.dao.ExamquestiondetailDao;
import com.htl.pojo.Examquestiondetail;
import com.htl.pojo.User;
import com.htl.pojo.domain.Exampaperhistory;
import com.htl.pojo.domain.Exampaperhistoryview;
import com.htl.pojo.domain.ExampaperhistoryviewExample;
import com.htl.service.EQDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author hehehe
 * @ClassName EQDServiceImpl
 * @Description TODO
 * @date 2022/5/4 0004 16:28
 * @Version 1.0
 */
@Service
@Transactional
public class EQDServiceImpl implements EQDService {
    @Autowired
    public ExamquestiondetailDao examquestiondetailDao;
    @Autowired
    public ExampaperhistoryviewDao exampaperhistoryviewDao;

    @Override
    public int addExamquestiondetail(Examquestiondetail eqd) {
        eqd.setTime(new Date());
        return examquestiondetailDao.insertSelective(eqd);
    }

    @Override
    public Examquestiondetail getExamquestiondetailByIds(Examquestiondetail eqd) {
        return examquestiondetailDao.selectByPrimaryKey(eqd);
    }

    @Override
    public int updExamquestiondetail(Examquestiondetail eqd) {
        eqd.setTime(new Date());
        return examquestiondetailDao.updateByPrimaryKeySelective(eqd);
    }

    @Override
    public List<Exampaperhistory> getDoPaperHistory(User user) {
        return exampaperhistoryviewDao.getDoPaperHistory(user);
    }

    @Override
    public List<Exampaperhistory> getDoExamHistory(User user) {
        return exampaperhistoryviewDao.getDoExamHistory(user);
    }

    @Override
    public List<Exampaperhistoryview> loadExamHistoryList(Exampaperhistoryview e) {
        ExampaperhistoryviewExample example=new ExampaperhistoryviewExample();
        ExampaperhistoryviewExample.Criteria criteria = example.createCriteria();
        criteria.andEidEqualTo(e.getEid());
        criteria.andUidEqualTo(e.getUid());
        return  exampaperhistoryviewDao.selectByExample(example);
    }
}
