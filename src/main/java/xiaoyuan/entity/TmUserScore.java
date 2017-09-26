package com.xiaoyuan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学生成绩导入
 */
@Entity
@Table(name = "TM_USER_SCORE")
public class TmUserScore {
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name="SCHOOL_GRADE")
    private String schoolgrade;//年级
    @Column(name="SCHOOL_CLASS")
    private String schoolclass;//班级
    @Column(name="SCHOOL_TEACHER")
    private String schoolteacher;//任课老师
    @Column(name="KEMU")
    private String kemu;//科目
    @Column(name="SCHOOL_TEST")
    private String schooltest;//考试名称
    @Column(name="SCHOOL_SCORE")
    private Double schoolscore;//分数
    @Column(name = "SCORE_TYPE")
    private Integer scoretype;//分数等级
    @Column(name="NAME")
    private String name;//学生姓名


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolgrade() {
        return schoolgrade;
    }

    public void setSchoolgrade(String schoolgrade) {
        this.schoolgrade = schoolgrade;
    }

    public String getSchoolclass() {
        return schoolclass;
    }

    public void setSchoolclass(String schoolclass) {
        this.schoolclass = schoolclass;
    }

    public String getSchoolteacher() {
        return schoolteacher;
    }

    public void setSchoolteacher(String schoolteacher) {
        this.schoolteacher = schoolteacher;
    }

    public String getKemu() {
        return kemu;
    }

    public void setKemu(String kemu) {
        this.kemu = kemu;
    }

    public String getSchooltest() {
        return schooltest;
    }

    public void setSchooltest(String schooltest) {
        this.schooltest = schooltest;
    }

    public Double getSchoolscore() {
        return schoolscore;
    }

    public void setSchoolscore(Double schoolscore) {
        this.schoolscore = schoolscore;
    }

    public Integer getScoretype() {
        return scoretype;
    }

    public void setScoretype(Integer scoretype) {
        this.scoretype = scoretype;
    }
}
