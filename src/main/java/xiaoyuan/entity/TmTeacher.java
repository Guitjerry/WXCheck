package com.xiaoyuan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 老师(也用作登录)
 */
@Entity
@Table(name = "TM_TEACHER")
public class TmTeacher {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "Login_CODE")
    private String login_code;
    @Column(name = "PASSWORD")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin_code() {
        return login_code;
    }

    public void setLogin_code(String login_code) {
        this.login_code = login_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

