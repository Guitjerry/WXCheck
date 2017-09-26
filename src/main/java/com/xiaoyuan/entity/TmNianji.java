package com.xiaoyuan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 年级
 */
@Entity(name = "TM_NIANJI")
@Table
public class TmNianji {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;

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
}
