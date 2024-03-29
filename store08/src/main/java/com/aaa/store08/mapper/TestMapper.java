package com.aaa.store08.mapper;

import com.aaa.store08.entity.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface TestMapper {
    public List<Map> findArea();
    public Map findTest(Test test);
    public List<Map> findOrders(String payment);
    public List<Map> findMonth();  //月收入
    public List<Map> monthly();  //每月
    public List<Map> MonthTest();  //每月的日期
    public Test OpriceTest(String oDate);  //每天的收入

}
