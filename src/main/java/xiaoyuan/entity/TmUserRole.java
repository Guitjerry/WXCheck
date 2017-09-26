package com.xiaoyuan.entity;

import javax.persistence.*;

/**
 * 用户角色对应表
 */
@Entity
@Table(name = "TM_USER_ROLE")
public class TmUserRole {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "USER_ID")
    private int userid;
    @Column(name = "ROLE_ID")
    private int roleid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }
}
