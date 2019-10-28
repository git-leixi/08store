package com.aaa.store08.controller;

import com.aaa.store08.entity.AreaVo;
import com.aaa.store08.entity.DataGrid;
import com.aaa.store08.entity.PageVo;
import com.aaa.store08.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Area")
public class AreaController {
    @Autowired
    private AreaService as;
    @RequestMapping("toArea")
    public String toArea(AreaVo areaVo,Model model) {
        List<AreaVo> area=as.findArea();
        model.addAttribute("area",area);
        return "page/area/Area";
    }
    @RequestMapping("AreaSelect")
    @ResponseBody
    public Object SelFood(PageVo pageVo,String aName) {
        DataGrid dg = new DataGrid();
        System.out.println(aName);
        AreaVo areaVo=new AreaVo();
        areaVo.setaName(aName);
        int count = as.findCount(areaVo);
        System.out.println(aName+"--"+count);
        List<Map> maps = as.SelDeskAll(pageVo,aName);
        dg.setCode(0);
        dg.setCount(count);
        dg.setData(maps);
        dg.setMsg("");
        return dg;
    }
    @RequestMapping("toAreaAdd")
    public String toAreaAdd(AreaVo areaVo,Model model) {
        List<AreaVo> area=as.findArea();
        model.addAttribute("area",area);
        return "page/area/AreaAdd";
    }
    @RequestMapping("AreaAdd")
    public String AreaAdd(String aName,String dName) {
        AreaVo areaVo=new AreaVo();
        System.out.println("添加事件");
        areaVo.setaName(aName);
        areaVo.setdName(dName);
        System.out.println(areaVo);
        as.AddDesk(areaVo);
        return "page/area/Area";
    }
    @RequestMapping("AreaDel")
    public String AreaDel(Integer dId) {
        System.out.println(dId);
        as.DelDesk(dId);
        return "page/area/Area";
    }
    @RequestMapping("AreaUpdDsort")
    public String AreaUpdDsort(Integer dId,String dsort) {
        System.out.println(dId);
        AreaVo areaVo=new AreaVo();
        areaVo.setdId(dId);
        areaVo.setDsort(dsort);
        as.UpdDsort(areaVo);
        return "page/area/Area";
    }
    @RequestMapping("AreaUpd")
    public String AreaUpd(Integer dId,String dName) {
        System.out.println(dId);
        AreaVo areaVo=new AreaVo();
        areaVo.setdId(dId);
        areaVo.setdName(dName);
        as.UpdDesk(areaVo);
        return "page/area/Area";
    }


}
