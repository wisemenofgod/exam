package com.htl.controller;

import com.htl.pojo.Examquestiondetail;
import com.htl.pojo.User;
import com.htl.pojo.domain.Exampaperhistory;
import com.htl.pojo.domain.Exampaperhistoryview;
import com.htl.service.EQDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hehehe
 * @ClassName EQDController
 * @Description TODO
 * @date 2022/5/4 0004 16:25
 * @Version 1.0
 */


@Controller
public class EQDController {

    @Autowired
    public EQDService eqdService;

    @RequestMapping("doExamCommit")
    @ResponseBody
    public Map<String, Object> doExamCommit(Examquestiondetail eqd) {
        Map<String, Object> resultMap = new HashMap<>();
        if (eqd.geteId() == null || eqd.getqId() == null || eqd.getuId() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        Examquestiondetail examquestiondetail = eqdService.getExamquestiondetailByIds(eqd);
        int i = 0;
        if (examquestiondetail == null) {
            i = eqdService.addExamquestiondetail(eqd);
        } else {
            i = eqdService.updExamquestiondetail(eqd);
        }
        if (i != 0) {
            resultMap.put("result", true);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }

    @RequestMapping("getDoExamHistory")
    @ResponseBody
    public Map<String, Object> getDoExamHistory(User user) {
        Map<String, Object> resultMap = new HashMap<>();
        if (user.getId() == null || user.getUsername() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        List<Exampaperhistory> exampaperhistorys = eqdService.getDoExamHistory(user);
        if (exampaperhistorys.size() > 0) {
            resultMap.put("result", true);
            resultMap.put("examhistorys", exampaperhistorys);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }
    @RequestMapping("getDoPaperHistory")
    @ResponseBody
    public Map<String, Object> getDoPaperHistory(User user) {
        Map<String, Object> resultMap = new HashMap<>();
        if (user.getId() == null || user.getUsername() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        List<Exampaperhistory> exampaperhistorys = eqdService.getDoPaperHistory(user);
        if (exampaperhistorys.size() > 0) {
            resultMap.put("result", true);
            resultMap.put("paperhistorys", exampaperhistorys);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }
    @RequestMapping("loadExamHistoryList")
    @ResponseBody
    public Map<String, Object> loadExamHistoryList(Exampaperhistoryview e) {
        Map<String, Object> resultMap = new HashMap<>();
        if (e.getEid() == null || e.getUid() == null) {
            resultMap.put("result", false);
            return resultMap;
        }
        List<Exampaperhistoryview> exampaperhistoryviews = eqdService.loadExamHistoryList(e);
        if (exampaperhistoryviews.size() > 0) {
            resultMap.put("result", true);
            resultMap.put("exampaperhistorys", exampaperhistoryviews);
        } else {
            resultMap.put("result", false);
        }
        return resultMap;
    }
}
