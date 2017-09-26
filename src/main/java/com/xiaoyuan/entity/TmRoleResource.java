package com.xiaoyuan.entity;

import javax.persistence.*;

/**
 * 角色资源关联表
 */
@Entity
@Table(name = "TM_ROLE_RESOURCE")
public class TmRoleResource {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ROLE_ID")
    private Integer roleid;
    @Column(name = "RESOURCE_ID")
    private Integer resourceid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getResourceid() {
        return resourceid;
    }

    public void setResourceid(Integer resourceid) {
        this.resourceid = resourceid;
    }
}
