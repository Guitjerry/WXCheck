package com.xiaoyuan.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户班级科目表
 */
@Table(name = "TM_USER_CLASS_KEMU")
@Entity
public class TmUserClassKemu {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "USER_ID")
    private int userId;
    @Column(name = "CLASS_ID")
    private int classId;
    @Column(name = "KEMU_ID")
    private int kemuId;
    @Column(name = "CREATEDATE")
    private Date creatdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getKemuId() {
        return kemuId;
    }

    public void setKemuId(int kemuId) {
        this.kemuId = kemuId;
    }

    public Date getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Date creatdate) {
        this.creatdate = creatdate;
    }
}
