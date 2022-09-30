package com.htl.controller;

import com.htl.dao.ExampaperQuestionKeyDao;
import com.htl.pojo.Exampaper;
import com.htl.pojo.Question;
import com.htl.pojo.User;
import com.htl.pojo.domain.ExampaperQuestionKeyKey;
import com.htl.pojo.domain.Exampaperquestionview;
import com.htl.pojo.domain.Myexamview;
import com.htl.pojo.domain.Mypaperview;
import com.htl.service.EQKService;
import com.htl.service.ExampaperService;
import com.htl.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hehehe
 * @ClassName UserController
 * @Description TODO
 * @date 2022/4/16 0016 22:38
 * @Version 1.0
 */
@Controller
public class ExampaperController {

    @Autowired
    private ExampaperService exampaperService;


    @RequestMapping("loadPaper")
    @ResponseBody
    public Map<String, Object> paper(User user, long begin, int num) {
        Map<String, Object> resultMap = new HashMap<>();
        if (user.getId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        List<Mypaperview> papers = exampaperService.getPaperByUidLimit(user, begin, num);
        if (papers != null && papers.size() > 0) {
            resultMap.put("result", true);
            resultMap.put("papers", papers);
            if (begin == 0) {
                long l = exampaperService.countPaperByUid(user);
                resultMap.put("countPaper", l);
            }
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }

    @RequestMapping("searchPaper")
    @ResponseBody
    public Map<String, Object> searchPaper(String name, String creatPerson) {
        Map<String, Object> resultMap = new HashMap<>();
        if (name == null || creatPerson == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        List<Mypaperview> papers = exampaperService.searchPaper(name, creatPerson);
        if (papers != null && papers.size() > 0) {
            resultMap.put("result", true);
            resultMap.put("papers", papers);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }
    @RequestMapping("searchExam")
    @ResponseBody
    public Map<String, Object> searchExam(User user) {
        Map<String, Object> resultMap = new HashMap<>();
        if (user.getId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        List<Myexamview> exams = exampaperService.searchExam(user);
        if (exams != null && exams.size() > 0) {
            resultMap.put("result", true);
            resultMap.put("exams", exams);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }

    @RequestMapping("loadExam")
    @ResponseBody
    public Map<String, Object> exam(User user, long begin, int num) {
        Map<String, Object> resultMap = new HashMap<>();
        if (user.getId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        List<Myexamview> exams = exampaperService.getExamByUidLimit(user, begin, num);
        if (exams != null && exams.size() > 0) {
            resultMap.put("result", true);
            resultMap.put("exams", exams);
            if (begin == 0) {
                long l = exampaperService.countExamByUid(user);
                resultMap.put("countExam", l);
            }
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }


    @RequestMapping("addPaper")
    @ResponseBody
    public Map<String, Object> addPaper(Exampaper exampaper) {
        Map<String, Object> resultMap = new HashMap<>();
        if (exampaper.getName() == null || exampaper.getCreatperson() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        int i = exampaperService.addExamOrPaper(exampaper);
        if (i == 1) {
            resultMap.put("result", true);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }

    @RequestMapping("updExamOrPaper")
    @ResponseBody
    public Map<String, Object> updExamOrPaper(Exampaper exampaper) {
        Map<String, Object> resultMap = new HashMap<>();
        if (exampaper.getId() == null) {
            resultMap.put("result", false);
        }
        int i = exampaperService.updExamOrPaper(exampaper);
        if (i == 1) {
            resultMap.put("result", true);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }

    @RequestMapping("loadPaperQuestion")
    @ResponseBody
    public Map<String, Object> loadPaperQuestion(Exampaper exampaper) {
        Map<String, Object> resultMap = new HashMap<>();
        if (exampaper.getId() == null) {
            resultMap.put("result", false);
        }
        List<Exampaperquestionview> questions = exampaperService.loadPaperQuestion(exampaper);
        if (questions.size() > 0) {
            resultMap.put("result", true);
            resultMap.put("questions", questions);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }

    @RequestMapping("delPaperOrExam")
    @ResponseBody
    public Map<String, Object> delPaperOrExam(Exampaper exampaper) {
        Map<String, Object> resultMap = new HashMap<>();
        if (exampaper.getId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        int i = exampaperService.delExamPaperById(exampaper);
        if (i != 0) {
            resultMap.put("result", true);
        } else {
            resultMap.put("result", false);
            resultMap.put("msg", "试卷不存在！");
        }
        return resultMap;
    }

}


