package com.xiaoyuan.entity;

import javax.persistence.*;

/**
 * 班级科目对应表
 */
@Entity
@Table(name = "TM_BANJI_KEMU")
public class TmBanjiKemu {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "BANJIID")
    private int banjiid;
    @Column(name = "KEMUID")
    private int kemuid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBanjiid() {
        return banjiid;
    }

    public void setBanjiid(int banjiid) {
        this.banjiid = banjiid;
    }

    public int getKemuid() {
        return kemuid;
    }

    public void setKemuid(int kemuid) {
        this.kemuid = kemuid;
    }
}
