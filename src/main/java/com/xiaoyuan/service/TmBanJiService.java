package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmBanJi;

import java.util.List;

/**
 * Created by dnys on 2018/1/2.
 */
public interface TmBanJiService {
    /**
     * 根据用户id查询相应班级
     * @param userid
     * @return
     */
    public List<TmBanJi> findAllBanjiByUserId(Integer userid);
}
