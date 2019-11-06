package com.aaa.store08.service;

import com.aaa.store08.entity.Test;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TestService {
    public List<Map> findArea();
    public Map findTest(Test test);
    public List<Map> findOrders(String payment);
    public List<Map> findMonth();  //月
    public List<Map> monthly();  //每月
    public List<Map> MonthTest();  //每月的日期
    public Test OpriceTest(String oDate);  //每天的收入
}
