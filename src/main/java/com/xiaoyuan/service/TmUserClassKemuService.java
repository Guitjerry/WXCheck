package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmBanJi;

import java.util.List;

public interface TmUserClassKemuService {
    /**
     * 根据用户id查找班级
     * @param userId
     * @return
     */
    public List<TmBanJi> findAllByUserId(Integer userId);
}
