package com.htl.dao;

import com.htl.pojo.domain.Myexamview;
import com.htl.pojo.domain.MyexamviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyexamviewDao {
    long countByExample(MyexamviewExample example);

    int deleteByExample(MyexamviewExample example);

    int insert(Myexamview record);

    int insertSelective(Myexamview record);

    List<Myexamview> selectByExample(MyexamviewExample example);

    int updateByExampleSelective(@Param("record") Myexamview record, @Param("example") MyexamviewExample example);

    int updateByExample(@Param("record") Myexamview record, @Param("example") MyexamviewExample example);
}