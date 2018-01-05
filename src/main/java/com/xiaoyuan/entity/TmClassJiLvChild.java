package com.xiaoyuan.entity;

import javax.persistence.*;

/**
 * 纪律子项
 */
@Entity
@Table(name = "TM_CLASS_JILV_CHILD")
public class TmClassJiLvChild {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;//名称
    @Column(name = "JL_ID")
    private int JLId;//主项id

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

    public int getJLId() {
        return JLId;
    }

    public void setJLId(int JLId) {
        this.JLId = JLId;
    }
}
