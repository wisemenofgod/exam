package com.htl.service;


import com.htl.pojo.domain.ClazzExampaperKeyKey;

import java.util.Map;

public interface CEKService {

    int delExamFromClass(ClazzExampaperKeyKey key);

    int addExamToClass(Map<String, Object> map);
}
