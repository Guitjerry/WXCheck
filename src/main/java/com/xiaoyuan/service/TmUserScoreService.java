package com.xiaoyuan.service;

/**
 * 学生成绩查询
 */
public interface TmUserScoreService {
    /**
     * 根据班级，学生姓名，对应考试名称查询是否导入过该数据
     * @param name
     * @param banji
     * @param testname
     * @return
     */
    public Integer findAllCountByNameAndBanji(String name, String banji, String testname);
}
