package com.xiaoyuan.entity;

/**
 * Created by dnys on 2017/9/21.
 */
public class ZuoyeVo {
    private int kemuid;
    private int zuoyeid;
    private int banjiid;
    private String task;
    private String kemuname;
    private String banjiname;

    public int getKemuid() {
        return kemuid;
    }

    public void setKemuid(int kemuid) {
        this.kemuid = kemuid;
    }

    public int getZuoyeid() {
        return zuoyeid;
    }

    public void setZuoyeid(int zuoyeid) {
        this.zuoyeid = zuoyeid;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getKemuname() {
        return kemuname;
    }

    public void setKemuname(String kemuname) {
        this.kemuname = kemuname;
    }

    public String getBanjiname() {
        return banjiname;
    }

    public void setBanjiname(String banjiname) {
        this.banjiname = banjiname;
    }

    public int getBanjiid() {
        return banjiid;
    }

    public void setBanjiid(int banjiid) {
        this.banjiid = banjiid;
    }

    public ZuoyeVo(int kemuid, int zuoyeid, int banjiid, String task, String kemuname, String banjiname) {
        this.kemuid = kemuid;
        this.zuoyeid = zuoyeid;
        this.banjiid = banjiid;
        this.task = task;
        this.kemuname = kemuname;
        this.banjiname = banjiname;
    }

    public ZuoyeVo() {
    }
}
