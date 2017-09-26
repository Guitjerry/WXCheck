package com.xiaoyuan.entity;

/**
 * Created by dnys on 2017/9/19.
 */
public class TmResourceVo {
    private Integer resourceid;
    private Integer parentid;

    private String name;
    private String parentname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getResourceid() {
        return resourceid;
    }

    public void setResourceid(Integer resourceid) {
        this.resourceid = resourceid;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public TmResourceVo(Integer resourceid, Integer parentid, String name, String parentname) {
        this.resourceid = resourceid;
        this.parentid = parentid;
        this.name = name;
        this.parentname = parentname;
    }
}
