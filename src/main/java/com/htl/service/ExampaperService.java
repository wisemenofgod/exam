package com.htl.service;

import com.htl.pojo.Exampaper;
import com.htl.pojo.Question;
import com.htl.pojo.User;
import com.htl.pojo.domain.ExampaperQuestionKeyKey;
import com.htl.pojo.domain.Exampaperquestionview;
import com.htl.pojo.domain.Myexamview;
import com.htl.pojo.domain.Mypaperview;

import java.util.List;

/**
 * @author hehehe
 * @ClassName StudentService
 * @Description TODO
 * @date 2022/4/16 0016 0:45
 * @Version 1.0
 */
public interface ExampaperService {
    List<Exampaper> getPaper(User user);

    List<Exampaper> getExamOrPaperID(Exampaper exampaper);

    List<Exampaper> getExam(User user);

    List<Mypaperview> searchPaper(String name, String creatPerson);

    int updExamOrPaper(Exampaper exampaper);

    List<Myexamview> getExamByUidLimit(User user, long begin, int num);

    List<Mypaperview> getPaperByUidLimit(User user, long begin, int num);

    int addExamOrPaper(Exampaper exampaper);

    long countPaperByUid(User user);

    long countExamByUid(User user);

    List<Exampaperquestionview> loadPaperQuestion(Exampaper exampaper);

    int delExamPaperById(Exampaper exampaper);

    List<Myexamview> searchExam(User user);
}
