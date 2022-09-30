package com.htl.dao;

import com.htl.pojo.domain.Myquestionview;
import com.htl.pojo.domain.MyquestionviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyquestionviewDao {
    long countByExample(MyquestionviewExample example);

    int deleteByExample(MyquestionviewExample example);

    int insert(Myquestionview record);

    int insertSelective(Myquestionview record);

    List<Myquestionview> selectByExample(MyquestionviewExample example);

    int updateByExampleSelective(@Param("record") Myquestionview record, @Param("example") MyquestionviewExample example);

    int updateByExample(@Param("record") Myquestionview record, @Param("example") MyquestionviewExample example);
}