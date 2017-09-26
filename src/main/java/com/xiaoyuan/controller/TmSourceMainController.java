package com.xiaoyuan.controller;


import com.xiaoyuan.entity.TmResource;
import com.xiaoyuan.respository.TmResourceRepository;
import com.xiaoyuan.service.TmResourceService;
import com.xiaoyuan.util.JsonUtilTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 资源管理控制类
 */
@Controller
@RequestMapping("/resource")
public class TmSourceMainController {
    @Autowired
    private TmResourceRepository tmResourceRepository;
    @Autowired
    private TmResourceService tmResourceService;
    /**
     * 添加资源
     */
    @RequestMapping("addResource")
    private String addResource(HttpServletRequest request){

        //查找所以父类菜单
        List<TmResource> resources = tmResourceService.findAllParent();
        request.setAttribute("parentList",resources);
        return "resource/addResource";
    }
    /**
     * 添加资源
     */
    @RequestMapping("addResourceSure")
    private void addResourceSure(HttpServletRequest request, HttpServletResponse response, TmResource resource){
        if(resource!=null){
            tmResourceRepository.save(resource);

        }
        if(resource!=null&&resource.getId()>0){
            JsonUtilTemp.returnSucessJson(response,"保存成功");
        }
    }
    /**
     * 编辑资源
     */
    @RequestMapping("editResource")
    private String editResource(HttpServletRequest request,Integer resourceid){
        if(resourceid!=null&&resourceid>0){
            TmResource tmResource = tmResourceRepository.findOne(resourceid);
            request.setAttribute("resource",tmResource);
        }
        //查找所以父类菜单
        List<TmResource> resources = tmResourceService.findAllParent();
        request.setAttribute("parentList",resources);
        return "resource/editResource";
    }
    /**
     * 编辑二级资源
     */
    @RequestMapping("editChildrenResource")
    private String editChildrenResource(HttpServletRequest request,Integer resourceid,Integer parentid){
        if(resourceid!=null&&resourceid>0){
            TmResource tmResource = tmResourceRepository.findOne(resourceid);
            request.setAttribute("resource",tmResource);
        }
        if(parentid!=null&&parentid>0){
            TmResource tmparentResource = tmResourceRepository.findOne(parentid);
            request.setAttribute("parentresource",tmparentResource);
        }
        //查找所以父类菜单
        List<TmResource> resources = tmResourceService.findAllParent();
        request.setAttribute("parentList",resources);
        return "resource/editChildrenResource";
    }
    @RequestMapping("addChildrenResource")
    private String addChildrenResource(HttpServletRequest request,Integer parentid){

        if(parentid!=null&&parentid>0){
            TmResource tmparentResource = tmResourceRepository.findOne(parentid);
            request.setAttribute("resource",tmparentResource);
        }
        return "resource/addChildrenResource";
    }
    @RequestMapping("addChildrenResourceSure")
    private void addChildrenResourceSure(HttpServletRequest request,HttpServletResponse response,TmResource tmResource){

       if(tmResource!=null){
           tmResourceRepository.save(tmResource);
       }
       if(tmResource!=null&&tmResource.getId()>0){
           JsonUtilTemp.returnSucessJson(response,"保存成功");
       }
    }
    /**
     * 编辑资源确定
     */
    @RequestMapping("editResourceSure")
    private void editResourceSure(HttpServletRequest request,HttpServletResponse response,Integer resourceid,TmResource newTmResource){
        if(newTmResource!=null&&newTmResource.getId()>0){
            tmResourceRepository.saveAndFlush(newTmResource);
        }
        if(newTmResource.getId()!=null){
            JsonUtilTemp.returnSucessJson(response,"更新成功");
        }
    }


    /**
     * 子节点列表
     */
    @RequestMapping("listchildrenResource")
    private void  listchildrenResource(Integer parentid, HttpServletRequest request,HttpServletResponse response){

        List<TmResource> resourcechildrenList = tmResourceService.findAllByParentid(parentid);

        JsonUtilTemp.returnObjAndSuccessJson(resourcechildrenList,response);
    }
    @RequestMapping("resourceList")
    private String  resourceList(HttpServletRequest request,String msg){
        List<TmResource> resourceList = tmResourceService.findAllParent();
        request.setAttribute("resourcelist",resourceList);
        request.setAttribute("msg",msg);
        return "resource/list";
    }
    @RequestMapping("resourceListJson")
    private void  resourceListJson(String msg, HttpServletRequest request,HttpServletResponse response){

        List<TmResource> resourceList = tmResourceService.findAllParent();

        JsonUtilTemp.returnJson(resourceList,response);


    }
}
