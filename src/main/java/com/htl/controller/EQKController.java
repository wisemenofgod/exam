package com.htl.controller;

import com.htl.pojo.domain.ExampaperQuestionKeyKey;
import com.htl.service.EQKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hehehe
 * @ClassName EQKController
 * @Description TODO
 * @date 2022/4/19 0019 16:18
 * @Version 1.0
 */

@Controller
public class EQKController {
    @Autowired
    private EQKService eqkService;

    @RequestMapping("addQuestionToExampaper")
    @ResponseBody
    public Map<String, Object> addQuestionToExampaper(@RequestBody Map<String, Object> map) {
        Map<String, Object> resultMap = new HashMap<>();
        if (map.get("id") == null || map.get("arr") == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        int i = eqkService.addQuestiontoExamOrPaper(map);
        if (i != 0) {
            resultMap.put("result", true);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }

    @RequestMapping("delQuestionFromExamPaper")
    @ResponseBody
    public Map<String, Object> delQuestionFromExamPaper(ExampaperQuestionKeyKey key) {
        Map<String, Object> resultMap = new HashMap<>();
        if (key.geteId() == null || key.getqId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        int i = eqkService.delQuestionFromExamPaper(key);
        if (i != 0) {
            resultMap.put("result", true);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }

}
