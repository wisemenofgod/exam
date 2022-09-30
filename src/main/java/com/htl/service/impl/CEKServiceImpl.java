package com.htl.service.impl;

import com.htl.dao.ClazzExampaperKeyDao;
import com.htl.dao.ExampaperQuestionKeyDao;
import com.htl.pojo.domain.ClazzExampaperKeyKey;
import com.htl.pojo.domain.ExampaperQuestionKeyKey;
import com.htl.service.CEKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author hehehe
 * @ClassName CEKServiceImpl
 * @Description TODO
 * @date 2022/4/19 0019 16:19
 * @Version 1.0
 */

@Service
@Transactional
public class CEKServiceImpl implements CEKService {

    @Autowired
    private ClazzExampaperKeyDao clazzExampaperKeyDao;

    @Override
    public int addExamToClass(Map<String, Object> map) {
        ClazzExampaperKeyKey eqKey = new ClazzExampaperKeyKey();
        eqKey.setcId(Integer.parseInt((String) map.get("id")));
        int ans = 0;
        for (String i : (ArrayList<String>) map.get("arr")) {
            eqKey.seteId(Integer.parseInt(i));
            try {
                ans = ans + clazzExampaperKeyDao.insertSelective(eqKey);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return ans;
    }

    @Override
    public int delExamFromClass(ClazzExampaperKeyKey key) {
        return clazzExampaperKeyDao.deleteByPrimaryKey(key);
    }
}
