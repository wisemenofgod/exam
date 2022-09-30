package com.htl.dao;

import com.htl.pojo.Examquestiondetail;
import com.htl.pojo.ExamquestiondetailExample;
import com.htl.pojo.ExamquestiondetailKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamquestiondetailDao {
    long countByExample(ExamquestiondetailExample example);

    int deleteByExample(ExamquestiondetailExample example);

    int deleteByPrimaryKey(ExamquestiondetailKey key);

    int insert(Examquestiondetail record);

    int insertSelective(Examquestiondetail record);

    List<Examquestiondetail> selectByExample(ExamquestiondetailExample example);

    Examquestiondetail selectByPrimaryKey(ExamquestiondetailKey key);

    int updateByExampleSelective(@Param("record") Examquestiondetail record, @Param("example") ExamquestiondetailExample example);

    int updateByExample(@Param("record") Examquestiondetail record, @Param("example") ExamquestiondetailExample example);

    int updateByPrimaryKeySelective(Examquestiondetail record);

    int updateByPrimaryKey(Examquestiondetail record);
}