package com.xiaoyuan.service;

import com.xiaoyuan.entity.ZuoyeVo;

import java.util.List;

/**
 * Created by dnys on 2017/9/21.
 */
public interface TmZuoyeService {
    public List<ZuoyeVo> listAllZuoye(String kemuname,String banjiname,Integer userid);
    public ZuoyeVo listAllZuoyeById(Integer zuoyeid);

    /**
     * 根据学生编码查询布置的作业
     * @param usercode
     * @return
     */
    public  List<ZuoyeVo> listAllZuoyeById(String usercode);
    public List<ZuoyeVo> listAllZuoyeByAdmin(String kemuname,String banjiname,Integer userid);
}
