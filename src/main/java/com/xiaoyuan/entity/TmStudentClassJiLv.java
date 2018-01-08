package com.xiaoyuan.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 学生纪律
 */
@Entity
@Table(name = "TM_STUDENTCLASS_JILV")
public class TmStudentClassJiLv {
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
    @Column(name = "STUDENT_ID")
    private Integer studentId;//学生id
    @Column(name = "CLALSS_ID")
    private Integer classId;//班级Id
    @Transient
    private String studentName;
    @Transient
    private String className;//学生所在班级
    @Transient
    private String jilvClassName;//纪律对应的班级名

    public TmStudentClassJiLv(Integer id, String content, String keCheng, Date createDate, Integer userId, Integer studentId, String studentName, String className) {
        this.id = id;
        this.content = content;
        this.keCheng = keCheng;
        this.createDate = createDate;
        this.userId = userId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.className = className;
    }

    public TmStudentClassJiLv() {
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

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
