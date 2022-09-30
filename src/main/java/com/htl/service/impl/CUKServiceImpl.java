package com.htl.service.impl;

import com.htl.dao.ClazzUserKeyDao;
import com.htl.dao.ExampaperQuestionKeyDao;
import com.htl.pojo.Clazz;
import com.htl.pojo.Exampaper;
import com.htl.pojo.Question;
import com.htl.pojo.User;
import com.htl.pojo.domain.ClazzUserKeyExample;
import com.htl.pojo.domain.ClazzUserKeyKey;
import com.htl.pojo.domain.ExampaperQuestionKeyKey;
import com.htl.service.CUKService;
import com.htl.service.EQKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hehehe
 * @ClassName CUKServiceImpl
 * @Description TODO
 * @date 2022/4/19 0019 16:19
 * @Version 1.0
 */

@Service
@Transactional
public class CUKServiceImpl implements CUKService {

    @Autowired
    private ClazzUserKeyDao clazzUserKeyDao;

    @Override
    public int joinClass(ClazzUserKeyKey clazzUserKeyKey) {
        return clazzUserKeyDao.insertSelective(clazzUserKeyKey);
    }

    @Override
    public int delStudent(ClazzUserKeyKey clazzUserKeyKey) {
        return clazzUserKeyDao.deleteByPrimaryKey(clazzUserKeyKey);
    }

}
