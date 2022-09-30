package com.htl.dao;

import com.htl.pojo.User;
import com.htl.pojo.domain.Exampaperhistory;
import com.htl.pojo.domain.Exampaperhistoryview;
import com.htl.pojo.domain.ExampaperhistoryviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExampaperhistoryviewDao {
    long countByExample(ExampaperhistoryviewExample example);

    int deleteByExample(ExampaperhistoryviewExample example);

    int insert(Exampaperhistoryview record);

    int insertSelective(Exampaperhistoryview record);

    List<Exampaperhistoryview> selectByExample(ExampaperhistoryviewExample example);

    int updateByExampleSelective(@Param("record") Exampaperhistoryview record, @Param("example") ExampaperhistoryviewExample example);

    int updateByExample(@Param("record") Exampaperhistoryview record, @Param("example") ExampaperhistoryviewExample example);

    List<Exampaperhistory> getDoPaperHistory(User user);

    List<Exampaperhistory> getDoExamHistory(User user);
}