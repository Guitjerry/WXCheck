package com.xiaoyuan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学生
 */
@Entity
@Table(name = "TM_STUDENT")
public class TmStudent {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "USERCODE")
    private String usercode;//学生编号
    @Column(name = "BANJIID")
    private String banjiid;//班级号
    @Column(name = "NIANJIID")
    private String nianjiid;//年级
    @Column(name = "STATUS")
    private Integer status;//是否有效 0有效 1无效

    public TmStudent(String name) {
        this.name = name;
    }

    public TmStudent(Integer id, String name, String usercode, String banjiid, String nianjiid, Integer status) {
        this.id = id;
        this.name = name;
        this.usercode = usercode;
        this.banjiid = banjiid;
        this.nianjiid = nianjiid;
        this.status = status;
    }

    public TmStudent() {
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

    public String getBanjiid() {
        return banjiid;
    }

    public void setBanjiid(String banjiid) {
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
}
