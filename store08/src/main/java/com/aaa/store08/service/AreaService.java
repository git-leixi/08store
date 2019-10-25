package com.aaa.store08.service;

import com.aaa.store08.entity.AreaVo;
import com.aaa.store08.entity.PageVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
public interface AreaService {
    public List<AreaVo> findArea();
    public int findCount();

    public List<Map> SelDeskAll(PageVo pageVo);

    public int AddDesk(AreaVo areaVo);

    public int DelDesk(Integer dId);

    public int UpdDsort(AreaVo areaVo);

    public int UpdDesk(AreaVo areaVo);
}
