package com.htl.service;

import com.htl.pojo.Exampaper;
import com.htl.pojo.Question;
import com.htl.pojo.domain.ExampaperQuestionKeyKey;

import java.util.Map;

public interface EQKService {
    int addQuestiontoExamOrPaper(Map<String, Object> map);

    int delQuestionFromExamPaper(ExampaperQuestionKeyKey key);
}
