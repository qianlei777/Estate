package com.kgc.estate.service.query;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.estate.dao.EstateMapper;
import com.kgc.estate.pojo.Estate;
import com.kgc.estate.pojo.EstateExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EstateServiceImpl implements EstateService {
    @Resource
    EstateMapper estateMapper;

    //分页查询
    public PageInfo<Estate> getEstateList(String val, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("buildTime");
        EstateExample example = new EstateExample();

        example.createCriteria().andUidLike("%" + val + "%");

        List<Estate> estateList = estateMapper.selectByExample(example);
        PageInfo<Estate> pageInfo = new PageInfo<Estate>(estateList);
        return pageInfo;
    }
}
