package com.htl.dao;

import com.htl.pojo.domain.Classexampaperview;
import com.htl.pojo.domain.ClassexampaperviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassexampaperviewDao {
    long countByExample(ClassexampaperviewExample example);

    int deleteByExample(ClassexampaperviewExample example);

    int insert(Classexampaperview record);

    int insertSelective(Classexampaperview record);

    List<Classexampaperview> selectByExample(ClassexampaperviewExample example);

    int updateByExampleSelective(@Param("record") Classexampaperview record, @Param("example") ClassexampaperviewExample example);

    int updateByExample(@Param("record") Classexampaperview record, @Param("example") ClassexampaperviewExample example);
}