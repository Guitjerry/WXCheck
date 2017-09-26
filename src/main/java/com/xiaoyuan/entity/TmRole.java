package com.xiaoyuan.entity;

import javax.persistence.*;

/**
 *角色
 */
@Entity
@Table(name = "TM_ROLE")
public class TmRole {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CODE")
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
