package com.xiaoyuan.controller;

import com.xiaoyuan.entity.TmRoleResource;
import com.xiaoyuan.respository.TmRoleResourceRepository;
import com.xiaoyuan.util.JsonUtilTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by dnys on 2017/9/19.
 */
@Controller
@RequestMapping("/roleToResource")
public class TmRoleToSourceController {
    @Autowired
    private TmRoleResourceRepository tmRoleResourceRepository;
    @RequestMapping("add")
    private void add(HttpServletResponse response,Integer roleid,@RequestParam(value = "resourceids[]")String[] resourceids){

        if(resourceids==null||resourceids.length==0){
            JsonUtilTemp.returnFailJson(response,"至少需要选择一个资源");
        }
        //根据roleid查找数据，删除在添加
       List<TmRoleResource> existRoleResources = tmRoleResourceRepository.findAllByroleid(roleid);
        for(TmRoleResource tmRoleResource:existRoleResources){
            tmRoleResourceRepository.delete(tmRoleResource);
        }
        try{
            if(resourceids!=null&&resourceids.length>0){
                for(String resourceid:resourceids){
                    TmRoleResource tmRoleResource = new TmRoleResource();
                    tmRoleResource.setResourceid(Integer.valueOf(resourceid));
                    tmRoleResource.setRoleid(roleid);
                    tmRoleResourceRepository.save(tmRoleResource);
                }
                JsonUtilTemp.returnSucessJson(response,"分配资源成功");
            }

        }catch (Exception e){
            JsonUtilTemp.returnFailJson(response,e.getMessage());
        }


    }
}
