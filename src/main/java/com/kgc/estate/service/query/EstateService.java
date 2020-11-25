package com.kgc.estate.service.query;

import com.github.pagehelper.PageInfo;
import com.kgc.estate.pojo.Estate;

public interface EstateService {
    //分页查询
    PageInfo<Estate> getEstateList( String val, Integer pageNum, Integer pageSize);
}
