package com.xiaoyuan.entity;

import javax.persistence.*;

/**
 * 学生
 */
@Entity
@Table(name = "TM_STUDENT")
public class TmStudent {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "USERCODE")
    private String usercode;//学生编号
    @Column(name = "BANJIID")
    private Integer banjiid;//班级号
    @Column(name = "NIANJIID")
    private String nianjiid;//年级
    @Column(name = "STATUS")
    private Integer status;//是否有效 0有效 1无效
    @Column(name = "AGE")
    private Integer age;//年龄
    @Column(name = "SEX")
    private String sex;//性别
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "banjiname")
    private String banjiname;//班级名称

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public Integer getBanjiid() {
        return banjiid;
    }

    public void setBanjiid(Integer banjiid) {
        this.banjiid = banjiid;
    }

    public String getNianjiid() {
        return nianjiid;
    }

    public void setNianjiid(String nianjiid) {
        this.nianjiid = nianjiid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBanjiname() {
        return banjiname;
    }

    public void setBanjiname(String banjiname) {
        this.banjiname = banjiname;
    }
}
