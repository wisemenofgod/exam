package com.htl.dao;

import com.htl.pojo.domain.ClazzUserKeyExample;
import com.htl.pojo.domain.ClazzUserKeyKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClazzUserKeyDao {
    long countByExample(ClazzUserKeyExample example);

    int deleteByExample(ClazzUserKeyExample example);

    int deleteByPrimaryKey(ClazzUserKeyKey key);

    int insert(ClazzUserKeyKey record);

    int insertSelective(ClazzUserKeyKey record);

    List<ClazzUserKeyKey> selectByExample(ClazzUserKeyExample example);

    int updateByExampleSelective(@Param("record") ClazzUserKeyKey record, @Param("example") ClazzUserKeyExample example);

    int updateByExample(@Param("record") ClazzUserKeyKey record, @Param("example") ClazzUserKeyExample example);
}