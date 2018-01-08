package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmStudentClassJiLv;

import java.util.List;

/**
 * 学生纪律
 */
public interface TmStudentClassJiLvService {
    public List<TmStudentClassJiLv> findAll();
    public List<TmStudentClassJiLv> findAllByRole(Integer userId);
}
