package com.xiaoyuan.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tm_user_score", schema = "xj19900923")
public class TmUserScore {
    private int id;
    private String name;
    private String schoolClass;
    private String schoolTest;
    private String studentcode;
    private String dili;
    private String huaxue;
    private String lishi;
    private String shengwu;
    private String shixiang;
    private String shuxue;
    private String waiyu;
    private String wuli;
    private String yuwen;
    private Double sumCount;
    private String schoolGrade;
    @Transient
    private String banjiindexs;
    @Transient
    private String nianjiindexs;
    @Transient
    public String getBanjiindexs() {
        return banjiindexs;
    }

    public void setBanjiindexs(String banjiindexs) {
        this.banjiindexs = banjiindexs;
    }
    @Transient
    public String getNianjiindexs() {
        return nianjiindexs;
    }

    public void setNianjiindexs(String nianjiindexs) {
        this.nianjiindexs = nianjiindexs;
    }

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Basic
    @Column(name = "SCHOOL_GRADE")
    public String getSchool_grade() {
        return schoolGrade;
    }

    public void setSchool_grade(String schoolGrade) {
        this.schoolGrade = schoolGrade;
    }

    @Basic
    @Column(name = "SUM_COUNT")
    public Double getSumCount() {
        return sumCount;
    }

    public void setSumCount(Double sumCount) {
        this.sumCount = sumCount;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "school_class")
    public String getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(String schoolClass) {
        this.schoolClass = schoolClass;
    }





    @Basic
    @Column(name = "school_test")
    public String getSchoolTest() {
        return schoolTest;
    }

    public void setSchoolTest(String schoolTest) {
        this.schoolTest = schoolTest;
    }


    @Basic
    @Column(name = "studentcode")
    public String getStudentcode() {
        return studentcode;
    }

    public void setStudentcode(String studentcode) {
        this.studentcode = studentcode;
    }

    @Basic
    @Column(name = "dili")
    public String getDili() {
        return dili;
    }

    public void setDili(String dili) {
        this.dili = dili;
    }

    @Basic
    @Column(name = "huaxue")
    public String getHuaxue() {
        return huaxue;
    }

    public void setHuaxue(String huaxue) {
        this.huaxue = huaxue;
    }

    @Basic
    @Column(name = "lishi")
    public String getLishi() {
        return lishi;
    }

    public void setLishi(String lishi) {
        this.lishi = lishi;
    }

    @Basic
    @Column(name = "shengwu")
    public String getShengwu() {
        return shengwu;
    }

    public void setShengwu(String shengwu) {
        this.shengwu = shengwu;
    }

    @Basic
    @Column(name = "shixiang")
    public String getShixiang() {
        return shixiang;
    }

    public void setShixiang(String shixiang) {
        this.shixiang = shixiang;
    }

    @Basic
    @Column(name = "shuxue")
    public String getShuxue() {
        return shuxue;
    }

    public void setShuxue(String shuxue) {
        this.shuxue = shuxue;
    }

    @Basic
    @Column(name = "waiyu")
    public String getWaiyu() {
        return waiyu;
    }

    public void setWaiyu(String waiyu) {
        this.waiyu = waiyu;
    }

    @Basic
    @Column(name = "wuli")
    public String getWuli() {
        return wuli;
    }

    public void setWuli(String wuli) {
        this.wuli = wuli;
    }

    @Basic
    @Column(name = "yuwen")
    public String getYuwen() {
        return yuwen;
    }

    public void setYuwen(String yuwen) {
        this.yuwen = yuwen;
    }



}
