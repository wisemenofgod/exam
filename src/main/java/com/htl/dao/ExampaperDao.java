package com.htl.dao;

import com.htl.pojo.Exampaper;
import com.htl.pojo.ExampaperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExampaperDao {
    long countByExample(ExampaperExample example);

    int deleteByExample(ExampaperExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Exampaper record);

    int insertSelective(Exampaper record);

    List<Exampaper> selectByExample(ExampaperExample example);

    Exampaper selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Exampaper record, @Param("example") ExampaperExample example);

    int updateByExample(@Param("record") Exampaper record, @Param("example") ExampaperExample example);

    int updateByPrimaryKeySelective(Exampaper record);

    int updateByPrimaryKey(Exampaper record);
}