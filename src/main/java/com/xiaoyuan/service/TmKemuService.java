package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmKemu;

import java.util.List;

/**
 *根据班级查找科目
 */
public interface TmKemuService {
    public List<TmKemu> selectKemuByBanji(Integer banjidi);
}
