package com.xiaoyuan.entity;

import javax.persistence.*;

/**
 * 班级
 */
@Entity
@Table(name = "TM_BANJI")
public class TmBanJi {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer ID;
    @Column(name = "NAME")
    private String name;
    @Column(name = "GRADE")
    private Integer grade;//年级
    @Column(name = "BANJITYPE")
    private Integer banjitype;//班级类别 1普通 2重点 3超重点
    @Column(name = "STUDENTCOUNT")
    private Integer studentCount;//学生数

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getBanjitype() {
        return banjitype;
    }

    public void setBanjitype(Integer banjitype) {
        this.banjitype = banjitype;
    }

    public Integer getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }
}
