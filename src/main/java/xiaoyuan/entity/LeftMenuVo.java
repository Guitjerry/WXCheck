package com.xiaoyuan.entity;

import java.util.List;

/**
 * 左侧菜单vo
 */
public class LeftMenuVo {
    private  String parentdiv;//主菜单
    private String  childreli;//子菜单
    private List<TmResource> parentResource;
    private List<TmResource> childResource;//子级

    public String getParentdiv() {
        return parentdiv;
    }

    public void setParentdiv(String parentdiv) {
        this.parentdiv = parentdiv;
    }

    public String getChildreli() {
        return childreli;
    }

    public void setChildreli(String childreli) {
        this.childreli = childreli;
    }

    public List<TmResource> getParentResource() {
        return parentResource;
    }

    public void setParentResource(List<TmResource> parentResource) {
        this.parentResource = parentResource;
    }

    public List<TmResource> getChildResource() {
        return childResource;
    }

    public void setChildResource(List<TmResource> childResource) {
        this.childResource = childResource;
    }
}
