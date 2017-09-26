package com.xiaoyuan.entity;

import javax.persistence.*;

/**
 * 科目
 */
@Entity
@Table(name = "TM_KEMU")
public class TmKemu {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
