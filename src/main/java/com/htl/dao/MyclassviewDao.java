package com.htl.dao;

import com.htl.pojo.domain.Myclassview;
import com.htl.pojo.domain.MyclassviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyclassviewDao {
    long countByExample(MyclassviewExample example);

    int deleteByExample(MyclassviewExample example);

    int insert(Myclassview record);

    int insertSelective(Myclassview record);

    List<Myclassview> selectByExample(MyclassviewExample example);

    int updateByExampleSelective(@Param("record") Myclassview record, @Param("example") MyclassviewExample example);

    int updateByExample(@Param("record") Myclassview record, @Param("example") MyclassviewExample example);
}