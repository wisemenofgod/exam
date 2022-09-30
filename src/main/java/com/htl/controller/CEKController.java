package com.htl.controller;

import com.htl.pojo.domain.ClazzExampaperKeyKey;
import com.htl.pojo.domain.ExampaperQuestionKeyKey;
import com.htl.service.CEKService;
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
 * @ClassName CEKController
 * @Description TODO
 * @date 2022/4/19 0019 16:18
 * @Version 1.0
 */

@Controller
public class CEKController {
    @Autowired
    private CEKService cekService;


    @RequestMapping("addExamToClass")
    @ResponseBody
    public Map<String, Object> addExamToClass(@RequestBody Map<String, Object> map) {
        Map<String, Object> resultMap = new HashMap<>();
        if (map.get("id") == null || map.get("arr") == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        int i = cekService.addExamToClass(map);
        if (i != 0) {
            resultMap.put("result", true);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }

    @RequestMapping("delExamFromClass")
    @ResponseBody
    public Map<String, Object> delExamFromClass(ClazzExampaperKeyKey key) {
        Map<String, Object> resultMap = new HashMap<>();
        if (key.geteId() == null || key.getcId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        int i = cekService.delExamFromClass(key);
        if (i != 0) {
            resultMap.put("result", true);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }
}
