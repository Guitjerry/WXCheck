package com.xiaoyuan.entity;

import javax.persistence.*;

/**
 * 操作日志
 */
@Entity
@Table(name = "TM_OPERATION_LOG")
public class TmOperationLog {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "USER_ID")
    private Integer userid;
    @Column(name = "USER_COUNT")
    private Integer usercount;
    @Column(name = "USER_NAME")
    private String username;
    @Column(name = "RESOURCE_NAME")
    private String resourcename;//操作资源
    @Column(name = "CONTENT")
    private String content;//操作内容
    @Column(name = "LOGINDATE")
    private String logindate;//登陆时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLogindate() {
        return logindate;
    }

    public void setLogindate(String logindate) {
        this.logindate = logindate;
    }

    public Integer getUsercount() {
        return usercount;
    }

    public void setUsercount(Integer usercount) {
        this.usercount = usercount;
    }
}
