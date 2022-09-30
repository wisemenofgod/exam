package com.htl.service;

import com.htl.pojo.Clazz;
import com.htl.pojo.User;
import com.htl.pojo.domain.Classexampaperview;
import com.htl.pojo.domain.Myclassview;

import java.util.List;

/**
 * @author hehehe
 * @ClassName ClazzService
 * @Description TODO
 * @date 2022/4/17 0017 20:31
 * @Version 1.0
 */

public interface ClazzService  {
    List<Clazz> getClazz(User user);

    List<Myclassview> getClazzByUidLimit(User user, long begin, int num);

    int delClazzById(Clazz clazz);

    int addClazz(Clazz clazz);

    int updClazz(Clazz clazz);

    long countClassByUid(User user);

    List<Myclassview> getClazzByCid(Clazz clazz);

    List<Classexampaperview> getClazzExampaperByCid(Clazz clazz);

    List<Myclassview> searchClass(User user);
}
