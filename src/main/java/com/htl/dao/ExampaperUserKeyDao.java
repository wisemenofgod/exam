package com.htl.dao;

import com.htl.pojo.domain.ExampaperUserKeyExample;
import com.htl.pojo.domain.ExampaperUserKeyKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExampaperUserKeyDao {
    long countByExample(ExampaperUserKeyExample example);

    int deleteByExample(ExampaperUserKeyExample example);

    int deleteByPrimaryKey(ExampaperUserKeyKey key);

    int insert(ExampaperUserKeyKey record);

    int insertSelective(ExampaperUserKeyKey record);

    List<ExampaperUserKeyKey> selectByExample(ExampaperUserKeyExample example);

    int updateByExampleSelective(@Param("record") ExampaperUserKeyKey record, @Param("example") ExampaperUserKeyExample example);

    int updateByExample(@Param("record") ExampaperUserKeyKey record, @Param("example") ExampaperUserKeyExample example);
}