package com.xiaoyuan.entity;

import javax.persistence.*;

/**
 * 上课纪律
 */
@Entity
@Table(name = "TM_CLASS_JILV")
public class TmClassJiLv {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;//名称
    @Column(name = "TYPE")
    private int type;//类型  1班级属性 班级卫生，班容班貌，学生违纪  2学生属性

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
