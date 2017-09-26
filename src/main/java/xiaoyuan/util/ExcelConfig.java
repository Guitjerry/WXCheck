package com.xiaoyuan.util;

import org.dom4j.Element;

import java.util.List;

/**
 * Created by heyy on 2017/4/20.
 */
public class ExcelConfig {
    private List<Element> elecloumns;//cloumns
    private List<Element> validatecloumns;//validate
    private List<Element> updatecloumns;//update
    private List<Element> selecterror;//error
    private List<Element> selectsuccess;//error



    public ExcelConfig(List<Element> elecloumns, List<Element> validatecloumns, List<Element> updatecloumns, List<Element> selecterror, List<Element> selectsuccess) {
        this.elecloumns = elecloumns;
        this.validatecloumns = validatecloumns;
        this.updatecloumns = updatecloumns;
        this.selecterror = selecterror;
        this.selectsuccess = selectsuccess;
    }

    public List<Element> getSelectsuccess() {
        return selectsuccess;
    }

    public void setSelectsuccess(List<Element> selectsuccess) {
        this.selectsuccess = selectsuccess;
    }

    public List<Element> getElecloumns() {
        return elecloumns;
    }

    public void setElecloumns(List<Element> elecloumns) {
        this.elecloumns = elecloumns;
    }

    public List<Element> getValidatecloumns() {
        return validatecloumns;
    }

    public void setValidatecloumns(List<Element> validatecloumns) {
        this.validatecloumns = validatecloumns;
    }

    public List<Element> getUpdatecloumns() {
        return updatecloumns;
    }

    public void setUpdatecloumns(List<Element> updatecloumns) {
        this.updatecloumns = updatecloumns;
    }

    public List<Element> getSelecterror() {
        return selecterror;
    }

    public void setSelecterror(List<Element> selecterror) {
        this.selecterror = selecterror;
    }
}
