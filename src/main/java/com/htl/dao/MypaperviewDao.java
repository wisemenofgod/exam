package com.htl.dao;

import com.htl.pojo.domain.Mypaperview;
import com.htl.pojo.domain.MypaperviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MypaperviewDao {
    long countByExample(MypaperviewExample example);

    int deleteByExample(MypaperviewExample example);

    int insert(Mypaperview record);

    int insertSelective(Mypaperview record);

    List<Mypaperview> selectByExample(MypaperviewExample example);

    int updateByExampleSelective(@Param("record") Mypaperview record, @Param("example") MypaperviewExample example);

    int updateByExample(@Param("record") Mypaperview record, @Param("example") MypaperviewExample example);
}