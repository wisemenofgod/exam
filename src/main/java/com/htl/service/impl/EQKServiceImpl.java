package com.htl.service.impl;

import com.htl.dao.ExampaperQuestionKeyDao;
import com.htl.pojo.Exampaper;
import com.htl.pojo.Question;
import com.htl.pojo.domain.ExampaperQuestionKeyKey;
import com.htl.service.EQKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author hehehe
 * @ClassName EQKServiceImpl
 * @Description TODO
 * @date 2022/4/19 0019 16:19
 * @Version 1.0
 */

@Service
@Transactional
public class EQKServiceImpl implements EQKService {

    @Autowired
    private ExampaperQuestionKeyDao exampaperQuestionKeyDao;

    @Override
    public int addQuestiontoExamOrPaper(Map<String, Object> map) {
        ExampaperQuestionKeyKey eqKey = new ExampaperQuestionKeyKey();
        eqKey.seteId(Integer.parseInt((String) map.get("id")));
        int ans = 0;
        for (String i : (ArrayList<String>) map.get("arr")) {
            eqKey.setqId(Integer.parseInt(i));
            try {
                ans = ans + exampaperQuestionKeyDao.insertSelective(eqKey);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return ans;
    }

    @Override
    public int delQuestionFromExamPaper(ExampaperQuestionKeyKey key) {
        return exampaperQuestionKeyDao.deleteByPrimaryKey(key);
    }
}
