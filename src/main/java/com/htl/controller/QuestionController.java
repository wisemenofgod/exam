package com.htl.controller;

import com.htl.pojo.Clazz;
import com.htl.pojo.Question;
import com.htl.pojo.User;
import com.htl.pojo.domain.Myquestionview;
import com.htl.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hehehe
 * @ClassName QuestionController
 * @Description TODO
 * @date 2022/4/17 0017 22:36
 * @Version 1.0
 */

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping("getQuestionById")
    @ResponseBody
    public Map<String, Object> getQuestionById(Question question) {
        Map<String, Object> resultMap = new HashMap<>();
        if (question.getId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        Myquestionview  question2 = questionService.getQuestionById(question);
        if (question2 != null ) {
            resultMap.put("result", true);
            resultMap.put("question", question2);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }
    @RequestMapping("loadQuestion")
    @ResponseBody
    public Map<String, Object> loadClass(User user, long begin, int num) {
        Map<String, Object> resultMap = new HashMap<>();
        if (user.getId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        List<Myquestionview> questions = questionService.getQuestionByLimit(user, begin, num);
        if (questions != null && questions.size() > 0) {
            resultMap.put("result", true);
            resultMap.put("questions", questions);
            if (begin == 0) {
                long l = questionService.countQuestionByUid(user);
                resultMap.put("countQuestion",l);
            }
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }
@RequestMapping("searchQuestion")
    @ResponseBody
    public Map<String, Object> searchQuestion(User user) {
        Map<String, Object> resultMap = new HashMap<>();
        if (user.getId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        List<Myquestionview> questions = questionService.searchQuestion(user);
        if (questions != null && questions.size() > 0) {
            resultMap.put("result", true);
            resultMap.put("questions", questions);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }

    @RequestMapping("delQuestion")
    @ResponseBody
    public Map<String, Object> delQuestion(Question question) {
        Map<String, Object> resultMap = new HashMap<>();
        if (question.getId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        int i = questionService.delQuestionById(question);
        if (i != 0) {
            resultMap.put("result", true);
        } else {
            resultMap.put("result", false);
            resultMap.put("msg", "题目不存在！");
        }
        return resultMap;
    }

    @RequestMapping("updQuestion")
    @ResponseBody
    public Map<String, Object> updQuestion(Question question) {
        Map<String, Object> resultMap = new HashMap<>();
        if (question.getId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        int i = questionService.updQuestion(question);
        if (i != 0) {
            resultMap.put("result", true);
        } else {
            resultMap.put("result", false);
            resultMap.put("msg", "题目不存在！");
        }
        return resultMap;
    }

    @RequestMapping("addQuestion")
    @ResponseBody
    public Map<String, Object> addQuestion(Question question) {
        Map<String, Object> resultMap = new HashMap<>();
        int i = questionService.addQuestion(question);
        if (i != 0) {
            resultMap.put("result", true);
        } else {
            resultMap.put("result", false);
            resultMap.put("msg", "题目不存在！");
        }
        return resultMap;
    }

    @RequestMapping("countQuestion")
    @ResponseBody
    public Map<String, Object> countQuestion(User user) {
        Map<String, Object> resultMap = new HashMap<>();
        if (user.getId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        long i = questionService.countQuestionByUid(user);
        resultMap.put("result", true);
        resultMap.put("count", i);
        return resultMap;
    }
}
