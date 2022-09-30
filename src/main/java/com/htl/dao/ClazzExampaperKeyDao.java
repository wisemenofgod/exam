package com.htl.dao;

import com.htl.pojo.domain.ClazzExampaperKeyExample;
import com.htl.pojo.domain.ClazzExampaperKeyKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClazzExampaperKeyDao {
    long countByExample(ClazzExampaperKeyExample example);

    int deleteByExample(ClazzExampaperKeyExample example);

    int deleteByPrimaryKey(ClazzExampaperKeyKey key);

    int insert(ClazzExampaperKeyKey record);

    int insertSelective(ClazzExampaperKeyKey record);

    List<ClazzExampaperKeyKey> selectByExample(ClazzExampaperKeyExample example);

    int updateByExampleSelective(@Param("record") ClazzExampaperKeyKey record, @Param("example") ClazzExampaperKeyExample example);

    int updateByExample(@Param("record") ClazzExampaperKeyKey record, @Param("example") ClazzExampaperKeyExample example);
}