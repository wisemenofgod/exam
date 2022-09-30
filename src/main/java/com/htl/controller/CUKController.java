package com.htl.controller;

import com.htl.pojo.Clazz;
import com.htl.pojo.Exampaper;
import com.htl.pojo.Question;
import com.htl.pojo.User;
import com.htl.pojo.domain.ClazzUserKeyKey;
import com.htl.service.CUKService;
import com.htl.service.EQKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class CUKController {
    @Autowired
    private CUKService cukService;

    @RequestMapping("joinClass")
    @ResponseBody
    public Map<String, Object> joinClass(ClazzUserKeyKey clazzUserKeyKey) {
        Map<String, Object> resultMap = new HashMap<>();
        if (clazzUserKeyKey.getcId() == null || clazzUserKeyKey.getuId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        int i = cukService.joinClass(clazzUserKeyKey);
        if (i == 1) {
            resultMap.put("result", true);
        }else{
            resultMap.put("result", false);
        }
        return resultMap;
    }

    @RequestMapping("delStudent")
    @ResponseBody
    public Map<String, Object> delStudent(ClazzUserKeyKey clazzUserKeyKey) {
        Map<String, Object> resultMap = new HashMap<>();
        if (clazzUserKeyKey.getcId() == null || clazzUserKeyKey.getuId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        int i = cukService.delStudent(clazzUserKeyKey);
        if (i == 1) {
            resultMap.put("result", true);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }

}
