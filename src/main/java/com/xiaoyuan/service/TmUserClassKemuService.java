package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmBanJi;
import com.xiaoyuan.entity.TmUserClassKemu;
import com.xiaoyuan.entity.UserKemuVo;

import java.util.List;

public interface TmUserClassKemuService {
    /**
     * 根据用户id查找班级(还未分配科目的,班主任分配班级)
     * @param userId
     * @return
     */
    public List<TmBanJi> findAllByUserId(Integer userId);
    public List<TmUserClassKemu> findAllByUserIdAndKemuId(Integer userId,Integer kemuId,Integer banjiid);
//    public List<UserKemuVo> findAllVoByUserId(Integer userId);
     public List<TmBanJi> findAllBanjiByUserId(Integer userId);
    /**
     * 查出当前用户的班级
     * @param userid
     * @return
     */
    public List<UserKemuVo> findAllVoByUserId(Integer userId,Integer banjiid);
}
