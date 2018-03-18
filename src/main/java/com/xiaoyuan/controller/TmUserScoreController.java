package com.xiaoyuan.controller;

import com.xiaoyuan.entity.TmRole;
import com.xiaoyuan.entity.TmUser;
import com.xiaoyuan.entity.TmUserScore;
import com.xiaoyuan.respository.TmUserScoreRepository;
import com.xiaoyuan.service.TmUserRoleService;
import com.xiaoyuan.service.TmUserScoreService;
import com.xiaoyuan.util.Const;
import com.xiaoyuan.util.JsonUtilTemp;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.soap.Addressing;
import java.util.ArrayList;
import java.util.List;

/**
 * 成绩管理
 */
@Controller
@RequestMapping("/score")
public class TmUserScoreController {
    @Autowired
    private TmUserScoreRepository tmUserScoreRepository;
    @Autowired
    private TmUserScoreService tmUserScoreService;
    @Autowired
    private TmUserRoleService tmUserRoleService;
    @RequestMapping("/list")
    private String list(HttpServletRequest request,String msg,String name,String studentcode,String schoolclass,Integer pageNo){
        Integer userid = (Integer) request.getSession().getAttribute("userid");
        List<TmUserScore> tmUserScoreList = null;
        //查询当前用户的角色
        List<TmRole> tmRoles= tmUserRoleService.findAllRoleByUserId(userid);
        pageNo=pageNo==null?1:pageNo;
        Boolean flag = false;
        for(TmRole tmRole:tmRoles){
            if(Const.ROLE_ADMIN.equals( tmRole.getCode())||Const.ROLE_MANAGE.equals(tmRole.getCode())){
                flag = true;
            }
        }
        Integer count=0;
        Pageable pageable = new PageRequest(pageNo,Const.PAGE_SIZE);
        /**
         * 是管理员与校级管理员角色,不做权限控制
         */
        if(flag){
            tmUserScoreList = tmUserScoreService.findAllByNameAndStudentcodeAndSchoolClass(name,studentcode,schoolclass,userid,pageable);
            count = tmUserScoreService.findAllByNameAndStudentcodeAndSchoolClass(name,studentcode,schoolclass,userid,null).size();


        }else{
            tmUserScoreList = tmUserScoreService.findAllByNameAndStudentcodeAndSchoolClassByRole(name,studentcode,schoolclass,userid,pageable);
            count = tmUserScoreService.findAllByNameAndStudentcodeAndSchoolClassByRole(name,studentcode,schoolclass,userid,null).size();
        }
        //其他做权限控制


        request.setAttribute("tmUserScoreList",tmUserScoreList);
        request.setAttribute("msg",msg);
        request.setAttribute("name",name);
        request.setAttribute("studentcode",studentcode);
        request.setAttribute("schoolclass",schoolclass);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pagesize",Const.PAGE_SIZE);
        request.setAttribute("counts",count);
        return "score/list";
    }
    @RequestMapping("/delscore")
    private void delscore(HttpServletRequest request,HttpServletResponse response,Integer scoreid){
        tmUserScoreRepository.delete(scoreid);
        JsonUtilTemp.returnSucessJson(response,"删除成功成功");

    }
}
