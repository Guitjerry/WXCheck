package com.xiaoyuan.entity;

import javax.persistence.*;

@Entity
@Table(name = "TM_RESOURCE")
public class TmResource {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DEPTH")
    private Integer depth;//菜单级次 0主菜单  1次级菜单
    @Column(name = "PARENT_ID")
    private Integer parentid;
    @Column(name = "LINK")
    private String link;//连接地址
    @Column(name = "ICON")
    private String icon;//图标
    @Column(name = "IFCHECKED")
    private Integer ifchecked;//是否选中 0未选中 1选中
    @Transient
    private String parentname;//父资源名称
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getIfchecked() {
        return ifchecked;
    }

    public void setIfchecked(Integer ifchecked) {
        this.ifchecked = ifchecked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public TmResource(String name, Integer depth, Integer parentid, String link, String icon, Integer ifchecked, String parentname) {
        this.name = name;
        this.depth = depth;
        this.parentid = parentid;
        this.link = link;
        this.icon = icon;
        this.ifchecked = ifchecked;
        this.parentname = parentname;
    }

    public TmResource() {
    }

    public TmResource(String name, Integer depth, Integer parentid, String link, String icon, Integer ifchecked) {
        this.name = name;
        this.depth = depth;
        this.parentid = parentid;
        this.link = link;
        this.icon = icon;
        this.ifchecked = ifchecked;
    }
}