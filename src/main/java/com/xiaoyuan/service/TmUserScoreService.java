package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmUserScore;

import java.util.List;

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
    public Integer findAllCountByNameAndBanji(String name, String banji, String testname,String kemu);

    /**
     * 通过学生姓名或者编码查询成绩
     * @param param
     * @return
     */
    public List<TmUserScore> findAllByNameOrStudentCode(String param);

    /**
     * 查询成绩
     * @param name
     * @param studentcode
     * @param schoolclass
     * @param userid
     * @return
     */
    public List<TmUserScore> findAllByNameAndStudentcodeAndSchoolClass(String name,String studentcode,String schoolclass,Integer userid);

    /**
     * 根据权限查询成绩
     * @param name
     * @param studentcode
     * @param schoolclass
     * @param userid
     * @return
     */
    public List<TmUserScore> findAllByNameAndStudentcodeAndSchoolClassByRole(String name, String studentcode, String schoolclass, Integer userid);
    public List<String> findBanjiIndex(String studentcode);
    public List<String> findNianjiIndex(String studentcode);
    public List<TmUserScore> findBanjiScorce(String studentcode);
    public List<TmUserScore> findNianjiScorce(String studentcode);
}
