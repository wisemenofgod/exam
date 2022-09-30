package com.htl.dao;

import com.htl.pojo.domain.ExampaperQuestionKeyExample;
import com.htl.pojo.domain.ExampaperQuestionKeyKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExampaperQuestionKeyDao {
    long countByExample(ExampaperQuestionKeyExample example);

    int deleteByExample(ExampaperQuestionKeyExample example);

    int deleteByPrimaryKey(ExampaperQuestionKeyKey key);

    int insert(ExampaperQuestionKeyKey record);

    int insertSelective(ExampaperQuestionKeyKey record);

    List<ExampaperQuestionKeyKey> selectByExample(ExampaperQuestionKeyExample example);

    int updateByExampleSelective(@Param("record") ExampaperQuestionKeyKey record, @Param("example") ExampaperQuestionKeyExample example);

    int updateByExample(@Param("record") ExampaperQuestionKeyKey record, @Param("example") ExampaperQuestionKeyExample example);
}