package com.kgc.estate.dao;

import com.kgc.estate.pojo.Estate;
import com.kgc.estate.pojo.EstateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EstateMapper {
    int countByExample(EstateExample example);

    int deleteByExample(EstateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Estate record);

    int insertSelective(Estate record);

    List<Estate> selectByExample(EstateExample example);

    Estate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Estate record, @Param("example") EstateExample example);

    int updateByExample(@Param("record") Estate record, @Param("example") EstateExample example);

    int updateByPrimaryKeySelective(Estate record);

    int updateByPrimaryKey(Estate record);
}