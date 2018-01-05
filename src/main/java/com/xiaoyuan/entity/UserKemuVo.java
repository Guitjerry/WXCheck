package com.xiaoyuan.entity;

/**
 * Created by dnys on 2018/1/3.
 */
public class UserKemuVo {
    private Integer kemuId;
    private Integer classId;
    private String kemuName;
    private String className;

    public UserKemuVo(Integer kemuId, Integer classId, String kemuName, String className) {
        this.kemuId = kemuId;
        this.classId = classId;
        this.kemuName = kemuName;
        this.className = className;
    }

    public Integer getKemuId() {
        return kemuId;
    }

    public void setKemuId(Integer kemuId) {
        this.kemuId = kemuId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getKemuName() {
        return kemuName;
    }

    public void setKemuName(String kemuName) {
        this.kemuName = kemuName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
