package com.xiaoyuan.entity;

import javax.persistence.*;

/**
 * Created by dnys on 2017/9/21.
 */
@Entity
@Table(name = "TM_ZUOYE")
public class TmZuoYe {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "KEMU_ID")
    private Integer kemuid;
    @Column(name = "BANJI_ID")
    private Integer banjiid;
    @Column(name = "TASK")
    private String task;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getKemuid() {
        return kemuid;
    }

    public void setKemuid(Integer kemuid) {
        this.kemuid = kemuid;
    }

    public Integer getBanjiid() {
        return banjiid;
    }

    public void setBanjiid(Integer banjiid) {
        this.banjiid = banjiid;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
