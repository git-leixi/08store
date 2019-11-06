package com.aaa.store08.service;

import com.aaa.store08.entity.Area;
import com.aaa.store08.entity.AreaVo;
import com.aaa.store08.entity.PageVo;
import com.aaa.store08.entity.Test;
import com.aaa.store08.mapper.AreaMapper;
import com.aaa.store08.mapper.TestMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TestServiceImpl implements TestService {
    @Resource
    private TestMapper tm;

    @Override
    public List<Map> findArea() {
        return tm.findArea();
    }

    @Override
     public Map findTest(Test test){
        System.out.println("serviceimpl"+test.getaName()+"---"+test.getoDate());
        return tm.findTest(test);
    }

    @Override
    public List<Map> findOrders(String payment) {
        return tm.findOrders(payment);
    }

    @Override
    public List<Map> findMonth() {
        return tm.findMonth();
    }

    @Override
    public List<Map> monthly() {
        return tm.monthly();
    }

    @Override
    public List<Map> MonthTest() {
        return tm.MonthTest();
    }

    @Override
    public Test OpriceTest(String oDate) {
        return tm.OpriceTest(oDate);
    }
}


