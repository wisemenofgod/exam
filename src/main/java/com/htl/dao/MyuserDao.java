package com.htl.dao;

import com.htl.pojo.domain.Myuser;
import com.htl.pojo.domain.MyuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyuserDao {
    long countByExample(MyuserExample example);

    int deleteByExample(MyuserExample example);

    int insert(Myuser record);

    int insertSelective(Myuser record);

    List<Myuser> selectByExample(MyuserExample example);

    int updateByExampleSelective(@Param("record") Myuser record, @Param("example") MyuserExample example);

    int updateByExample(@Param("record") Myuser record, @Param("example") MyuserExample example);
}