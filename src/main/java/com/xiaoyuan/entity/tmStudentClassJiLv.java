package com.xiaoyuan.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 学生纪律
 */
@Entity
@Table(name = "TM_STUDENTCLASS_JILV")
public class tmStudentClassJiLv {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "JV_CHILD_ID")
    private Integer jvChildId;//学生纪律id
    @Column(name = "CONTENT")
    private String content;//详细内容
    @Column(name = "KE_CHENG")
    private String keCheng;//发生具体第几节课   (如:第二节课)
    @Column(name = "CREATE_DATE")
    private Date createDate;//创建时间
    @Column(name = "USER_ID")
    private Integer userId;//记录人

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJvChildId() {
        return jvChildId;
    }

    public void setJvChildId(Integer jvChildId) {
        this.jvChildId = jvChildId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKeCheng() {
        return keCheng;
    }

    public void setKeCheng(String keCheng) {
        this.keCheng = keCheng;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
