package com.htl.service.impl;

import com.htl.dao.ClassexampaperviewDao;
import com.htl.dao.ClazzDao;
import com.htl.dao.ClazzUserKeyDao;
import com.htl.dao.MyclassviewDao;
import com.htl.pojo.Clazz;
import com.htl.pojo.ClazzExample;
import com.htl.pojo.User;
import com.htl.pojo.domain.*;
import com.htl.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hehehe
 * @ClassName ClazzServiceImpl
 * @Description TODO
 * @date 2022/4/17 0017 20:31
 * @Version 1.0
 */

@Service
@Transactional
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzDao clazzDao;
    @Autowired
    private ClazzUserKeyDao clazzUserKeyDao;
    @Autowired
    private MyclassviewDao myclassviewDao;
 @Autowired
    private ClassexampaperviewDao classexampaperviewDao;

    @Override
    public List<Clazz> getClazz(User user) {
        ClazzUserKeyExample clazzUserKeyExample = new ClazzUserKeyExample();
        ClazzUserKeyExample.Criteria criteria = clazzUserKeyExample.createCriteria();
        criteria.andUIdEqualTo(user.getId());
        List<ClazzUserKeyKey> clazzUserKeyKeys = clazzUserKeyDao.selectByExample(clazzUserKeyExample);
        if (clazzUserKeyKeys.isEmpty()) {
            return null;
        }
        ClazzExample clazzExample = new ClazzExample();
        ClazzExample.Criteria criteria1 = clazzExample.createCriteria();
        List<Integer> list = new ArrayList<>();
        for (ClazzUserKeyKey clazzUserKeyKey : clazzUserKeyKeys) {
            list.add(clazzUserKeyKey.getcId());
        }
        criteria1.andIdIn(list);
        List<Clazz> clazzes = clazzDao.selectByExample(clazzExample);
        return clazzes.size() > 0 ? clazzes : null;
    }

    @Override
    public List<Myclassview> getClazzByUidLimit(User user, long begin, int num) {
        MyclassviewExample example = new MyclassviewExample();
        MyclassviewExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(user.getId());
        example.setOffset(begin < 0 ? 0 : begin);
        example.setLimit(num);
        List<Myclassview> myclassviews = myclassviewDao.selectByExample(example);
        return myclassviews.size() > 0 ? myclassviews : null;
    }

    @Override
    public int delClazzById(Clazz clazz) {
        return clazzDao.deleteByPrimaryKey(clazz.getId());
    }

    @Override
    public int addClazz(Clazz clazz) {
        clazz.setCreattime(new Date());
        return clazzDao.insertSelective(clazz);
    }

    @Override
    public int updClazz(Clazz clazz) {
        int i = 0;
        i = clazzDao.updateByPrimaryKeySelective(clazz);
        return i;
    }

    @Override
    public long countClassByUid(User user) {
        MyclassviewExample example = new MyclassviewExample();
        example.createCriteria().andUidEqualTo(user.getId());
        return myclassviewDao.countByExample(example);
    }

    @Override
    public List<Myclassview> getClazzByCid(Clazz clazz) {
        MyclassviewExample example = new MyclassviewExample();
        example.createCriteria().andCidEqualTo(clazz.getId());
        return myclassviewDao.selectByExample(example);
    }

    @Override
    public List<Classexampaperview> getClazzExampaperByCid(Clazz clazz) {
        ClassexampaperviewExample example=new ClassexampaperviewExample();
        example.createCriteria().andCidEqualTo(clazz.getId());
        return classexampaperviewDao.selectByExample(example);
    }

    @Override
    public List<Myclassview> searchClass(User user) {
        MyclassviewExample example = new MyclassviewExample();
        MyclassviewExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(user.getId());
        criteria.andClassnameLike(user.getUsername());
        List<Myclassview> myclassviews = myclassviewDao.selectByExample(example);
        return myclassviews.size() > 0 ? myclassviews : null;
    }
}
