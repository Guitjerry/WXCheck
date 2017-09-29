package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmStudent;

import java.util.List;

/**
 * Created by dnys on 2017/9/28.
 */
public interface TmStudentService {
    /**
     * 查询所有数据包括班级名称
     * @return
     */
    public List<TmStudent> findAllStudent();
}
