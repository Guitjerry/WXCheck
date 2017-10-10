package com.xiaoyuan.service;

import com.xiaoyuan.entity.ZuoyeVo;

import java.util.List;

/**
 * Created by dnys on 2017/9/21.
 */
public interface TmZuoyeService {
    public List<ZuoyeVo> listAllZuoye(String kemuname,String banjiname);
    public ZuoyeVo listAllZuoyeById(Integer zuoyeid);
}
