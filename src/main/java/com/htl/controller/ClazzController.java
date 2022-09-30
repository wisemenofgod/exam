package com.htl.controller;

import com.htl.pojo.Clazz;
import com.htl.pojo.User;
import com.htl.pojo.domain.Classexampaperview;
import com.htl.pojo.domain.ClazzUserKeyKey;
import com.htl.pojo.domain.Myclassview;
import com.htl.service.CUKService;
import com.htl.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hehehe
 * @ClassName ClazzController
 * @Description TODO
 * @date 2022/4/17 0017 20:25
 * @Version 1.0
 */

@Controller
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private CUKService cukService;


    @RequestMapping("loadClass")
    @ResponseBody
    public Map<String, Object> loadClass(User user, long begin, int num) {
        Map<String, Object> resultMap = new HashMap<>();
        if (user.getId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        List<Myclassview> clazzes = clazzService.getClazzByUidLimit(user, begin, num);
        if (clazzes != null && clazzes.size() > 0) {
            resultMap.put("result", true);
            resultMap.put("clazzes", clazzes);
            if (begin == 0) {
                long i = clazzService.countClassByUid(user);
                resultMap.put("countClass", i);
            }
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }

    @RequestMapping("searchClass")
    @ResponseBody
    public Map<String, Object> searchClass(User user) {
        Map<String, Object> resultMap = new HashMap<>();
        if (user.getId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        List<Myclassview> clazzes = clazzService.searchClass(user);
        if (clazzes != null && clazzes.size() > 0) {
            resultMap.put("result", true);
            resultMap.put("clazzes", clazzes);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }

    @RequestMapping("loadclassDetail")
    @ResponseBody
    public Map<String, Object> loadclassDetail(Clazz clazz) {
        Map<String, Object> resultMap = new HashMap<>();
        if (clazz.getId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        List<Myclassview> clazzes = clazzService.getClazzByCid(clazz);
        if (clazzes != null && clazzes.size() > 0) {
            resultMap.put("result", true);
            resultMap.put("clazzes", clazzes);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }

    @RequestMapping("loadClassExampaper")
    @ResponseBody
    public Map<String, Object> loadClassExampaper(Clazz clazz) {
        Map<String, Object> resultMap = new HashMap<>();
        if (clazz.getId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        List<Classexampaperview> clazzes = clazzService.getClazzExampaperByCid(clazz);
        if (clazzes != null && clazzes.size() > 0) {
            resultMap.put("result", true);
            resultMap.put("clazzes", clazzes);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }

    @RequestMapping("delClass")
    @ResponseBody
    public Map<String, Object> delClazz(Clazz clazz) {
        Map<String, Object> resultMap = new HashMap<>();
        if (clazz.getId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        ClazzUserKeyKey clazzUserKeyKey = new ClazzUserKeyKey();
        clazzUserKeyKey.setcId(clazz.getId());
        clazzUserKeyKey.setuId(clazz.getCreatperson());
        cukService.delStudent(clazzUserKeyKey);
        int i = clazzService.delClazzById(clazz);
        if (i != 0) {
            resultMap.put("result", true);
        } else {
            resultMap.put("result", false);
            resultMap.put("msg", "班级不存在！");
        }
        return resultMap;
    }

    @RequestMapping("addClass")
    @ResponseBody
    public Map<String, Object> addClazz(Clazz clazz) {
        Map<String, Object> resultMap = new HashMap<>();
        int i = clazzService.addClazz(clazz);
        ClazzUserKeyKey clazzUserKeyKey = new ClazzUserKeyKey();
        clazzUserKeyKey.setcId(clazz.getId());
        clazzUserKeyKey.setuId(clazz.getCreatperson());
        cukService.joinClass(clazzUserKeyKey);
        if (i != 0) {
            resultMap.put("result", true);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }

    @RequestMapping("updClass")
    @ResponseBody
    public Map<String, Object> updClazz(Clazz clazz) {
        Map<String, Object> resultMap = new HashMap<>();
        if (clazz.getId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        int i = clazzService.updClazz(clazz);
        if (i != 0) {
            resultMap.put("result", true);
        } else {
            resultMap.put("result", false);
            resultMap.put("msg", "班级不存在！");
        }
        return resultMap;
    }


}

