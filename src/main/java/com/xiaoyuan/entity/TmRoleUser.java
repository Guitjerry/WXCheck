package com.xiaoyuan.entity;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 角色用户关联表
 */
public class TmRoleUser {
    @Id
    @Column(name = "ID")
    private  Integer id;
    @Column(name = "TEACHER_ID")
    private Integer teacherid;//用户Id
    @Column(name = "ROLE_ID")
    private Integer roleid;//角色id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}
