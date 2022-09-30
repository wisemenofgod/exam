package com.htl.service;

import com.htl.pojo.Examquestiondetail;
import com.htl.pojo.User;
import com.htl.pojo.domain.Exampaperhistory;
import com.htl.pojo.domain.Exampaperhistoryview;

import java.util.List;

/**
 * @author hehehe
 * @ClassName EQDService
 * @Description TODO
 * @date 2022/5/4 0004 16:27
 * @Version 1.0
 */

public interface EQDService {
    int addExamquestiondetail(Examquestiondetail eqd);

    Examquestiondetail getExamquestiondetailByIds(Examquestiondetail eqd);

    int updExamquestiondetail(Examquestiondetail eqd);

    List<Exampaperhistory> getDoPaperHistory(User user);

    List<Exampaperhistory> getDoExamHistory(User user);

    List<Exampaperhistoryview> loadExamHistoryList(Exampaperhistoryview e);
}
