package com.htl.dao;

import com.htl.pojo.domain.Exampaperquestionview;
import com.htl.pojo.domain.ExampaperquestionviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExampaperquestionviewDao {
    long countByExample(ExampaperquestionviewExample example);

    int deleteByExample(ExampaperquestionviewExample example);

    int insert(Exampaperquestionview record);

    int insertSelective(Exampaperquestionview record);

    List<Exampaperquestionview> selectByExample(ExampaperquestionviewExample example);

    int updateByExampleSelective(@Param("record") Exampaperquestionview record, @Param("example") ExampaperquestionviewExample example);

    int updateByExample(@Param("record") Exampaperquestionview record, @Param("example") ExampaperquestionviewExample example);
}