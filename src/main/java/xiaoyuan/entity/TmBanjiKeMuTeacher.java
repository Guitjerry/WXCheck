package com.xiaoyuan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by dnys on 2017/9/7.
 */
@Entity
@Table(name = "Tm_BanjiKemuTeacher")
public class TmBanjiKeMuTeacher {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name="BANJI_ID")
    private Integer banjiid;//班级
    @Column(name = "TEACHER_ID")
    private Integer teacherid;//老师
    @Column(name="KEMU_ID")
    private Integer kemuid;//科目
    @Column(name = "STATUS")
    private Integer status;//有效性 0有效 1无效

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBanjiid() {
        return banjiid;
    }

    public void setBanjiid(Integer banjiid) {
        this.banjiid = banjiid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getKemuid() {
        return kemuid;
    }

    public void setKemuid(Integer kemuid) {
        this.kemuid = kemuid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
