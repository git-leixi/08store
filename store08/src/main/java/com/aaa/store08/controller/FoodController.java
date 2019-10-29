package com.aaa.store08.controller;

import com.aaa.store08.entity.*;
import com.aaa.store08.service.AreaService;
import com.aaa.store08.service.FoodService;
import com.aaa.store08.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Food")
public class FoodController {
    @Autowired
    private FoodService fs;
    @Autowired
    private AreaService as;
    @Autowired
    private KindService ks;

    @ResponseBody
    @RequestMapping("SelFood")
    public Object SelFood(PageVo pageVo) {
        DataGrid dg = new DataGrid();
        int count = fs.findCount();
        List<Map> maps = fs.SelFoodAll(pageVo);
        dg.setCode(0);
        dg.setCount(count);
        dg.setData(maps);
        dg.setMsg("");
        return dg;

    }
    @RequestMapping("aaa")
    public String aaa(){
        return "page/Food-Manage/Food-index";
    }


        //按编号删除
    @RequestMapping("DelFood")
    public String DelStu(Integer mId){
        int i = fs.DelFood(mId);
        System.out.println(i);
        return "redirect:Food/SelFood";
    }

    @RequestMapping("ToAddFood")
    public String ToAddFood(Area area, Kind kind, Model model){
        List<Area> areas = as.SelArea();
        List<Kind> kinds = ks.SelKind();
        model.addAttribute("as",areas);
        model.addAttribute("ks",kinds);
        return "page/Food-Manage/Food-Add";
    }

    @RequestMapping("Add")
    public  String Add(){
        return "page/Food-Manage/Food-Add";
    }

    @RequestMapping("InsertFood")
    public String InsertFood(MultipartFile upload, Food food, Area area, Kind kind){
        System.out.println("进来了");
        System.out.println(food.getmPrice()+food.getmName()+food.getmImg()+food.getmArea()+food.getmKind());
        String filePath="E:\\app-git\\08store\\store08\\src\\main\\resources\\templates\\common\\image\\img\\"; //定义上传文件的存放位置
        System.out.println(filePath);
        String fileName = food.getmImg();//获取上传文件的名字
        System.out.println("名字"+fileName);
        //判断文件夹是否存在    不存在则创建
        String fileName1="../common/image/img/"+fileName;
        food.setmImg(fileName1);
        System.out.println("新对象"+food);
        File file = new File(filePath);
        if(file.exists()){
            file.mkdirs();
        }
        //新文件路径
        String newFilePath =filePath+fileName;
        System.out.println("新的"+newFilePath);
        System.out.println(food.getmPrice()+food.getmName()+food.getmImg()+food.getmArea()+food.getmKind());
        fs.InsertFood(food);


        System.out.println(food.getmName()+food.getmImg());
        return "redirect:aaa";
    }

    @RequestMapping("ToUpdateFood")
    public String ToUpdateFood(Area area, Kind kind, Model model,Integer mId){
        Food food = fs.UpdFoodId(mId);
        List<Area> areas = as.SelArea();
        List<Kind> kinds = ks.SelKind();
        model.addAttribute("upd",food);
        model.addAttribute("as",areas);
        model.addAttribute("ks",kinds);
        return "page/Food-Manage/Food-Update";
    }


    //修改
    @RequestMapping("Upd")
    public String Upd(Food food,MultipartFile upload){
        System.out.println(food.getmName()+food.getmPrice()+food.getmKind()+food.getmArea()+food.getmId()+food.getmImg());
        fs.UpdateFood(food);
        return "redirect:aaa";
    }
}
