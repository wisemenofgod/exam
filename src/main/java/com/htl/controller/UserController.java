package com.htl.controller;

import com.htl.pojo.User;
import com.htl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hehehe
 * @ClassName UserController
 * @Description TODO
 * @date 2022/4/16 0016 22:38
 * @Version 1.0
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("userLogin")
    @ResponseBody
    public Map<String, Object> login(User user) {
        Map<String, Object> resultMap = new HashMap<>();
        User loginUser = userService.login(user);
        if (loginUser != null) {
            resultMap.put("result", true);
            resultMap.put("user", loginUser);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }

    @RequestMapping("userRegister")
    @ResponseBody
    public Map<String, Object> register(User user) {
        Map<String, Object> resultMap = new HashMap<>();
        int i = userService.register(user);
        if (i == 1) {
            User user1 = userService.login(user);
            resultMap.put("result", true);
            resultMap.put("user",user1);
        }else if (i==0){
            resultMap.put("result", false);
        }
        return resultMap;
    }

    @RequestMapping("updUser")
    @ResponseBody
    public Map<String, Object> updUser(User user) {
        Map<String, Object> resultMap = new HashMap<>();
        if(user.getId()==null){
            resultMap.put("result", false);
            return resultMap;
        }
        int i = userService.updUser(user);
        if (i == 1) {
            resultMap.put("result", true);
        }else if (i==0){
            resultMap.put("result", false);
        }
        return resultMap;
    }

    @RequestMapping("delUser")
    @ResponseBody
    public Map<String, Object> delUser(User user) {
        Map<String, Object> resultMap = new HashMap<>();
        if(user.getId()==null){
            resultMap.put("result", false);
            return resultMap;
        }
        int i = userService.delUser(user);
        if (i == 1) {
            resultMap.put("result", true);
        }else if (i==0){
            resultMap.put("result", false);
            resultMap.put("msg","用户不存在！");
        }
        return resultMap;
    }


}


