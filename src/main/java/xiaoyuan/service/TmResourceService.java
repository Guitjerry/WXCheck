package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmResource;

import java.util.List;

/**
 * Created by dnys on 2017/9/13.
 */
public interface TmResourceService {
    //查找所有父类菜单
    public List<TmResource> findAllParent();
    //查找所有子节点
    public List<TmResource> findAllByParentid(Integer parentid);
    //查找所有菜单
    public List<TmResource> findAll();


    public List<TmResource> findResourceByUserid();
    /**
     * 根据用户查找相应的父资源(查角色,以及角色分配的资源的父级别)
     * @return
     */
    public  List<TmResource> findAllParentByUserId(Integer userid);

    public List<TmResource> findAllByUserId(Integer userid);
}
