package com.xiaoyuan.controller;

import com.xiaoyuan.entity.TmClassJiLv;
import com.xiaoyuan.entity.TmClassJiLvChild;
import com.xiaoyuan.entity.TmStudent;
import com.xiaoyuan.entity.TmStudentClassJiLv;
import com.xiaoyuan.respository.TmStudentClassJiLvRepository;
import com.xiaoyuan.service.TmClassJiLvChildService;

import com.xiaoyuan.service.TmStudentClassJiLvService;
import com.xiaoyuan.service.TmStudentService;
import com.xiaoyuan.util.JsonUtilTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 学生纪律
 */
@Controller
@RequestMapping("/classJilv")
public class TmStudentClassJiLvController {
    @Autowired
    private TmStudentClassJiLvService tmStudentClassJiLvService;
    @Autowired
    private TmStudentService tmStudentService;
    @Autowired
    private TmClassJiLvChildService tmClassJiLvChildService;
    @Autowired
    private TmStudentClassJiLvRepository tmStudentClassJiLvRepository;
    /**
     *  违反纪律内容列表
     */
    @RequestMapping("/classJilvList")
    private String kemuList(HttpServletRequest request, String msg, Integer pageNo){
        request.setAttribute("msg",msg);
        List<TmStudentClassJiLv> tmClassJiLvs = new ArrayList<>();
        //获取当前用户权限
        Boolean flag = (Boolean) request.getSession().getAttribute("adminRole");
        String userid = request.getSession().getAttribute("userid").toString();
        if(flag){
            tmClassJiLvs =   tmStudentClassJiLvService.findAll();
        }else{
            tmClassJiLvs = tmStudentClassJiLvService.findAllByRole(Integer.valueOf(userid));
        }

        request.setAttribute("tmClassJiLvs",tmClassJiLvs);
        return "classJilv/list";
    }

    /**
     * 新增违反纪律
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("/addClassJilv")
    private String addClassJilv(HttpServletResponse response, HttpServletRequest request){
        //选择学生
        //获取当前用户权限
        Boolean flag = (Boolean) request.getSession().getAttribute("adminRole");
        String userid = request.getSession().getAttribute("userid").toString();
        List<TmStudent> tmStudents = tmStudentService.findAllStudentByName(null,null,null,Integer.valueOf(userid),flag);
        request.setAttribute("tmStudents",tmStudents);

        //查找所有学生纪律
        List<TmClassJiLvChild> tmClassJiLvChildList = tmClassJiLvChildService.findAllByType();
        request.setAttribute("tmClassJiLvChildList",tmClassJiLvChildList);

        return "classJilv/addClassJilv";
    }

    /**
     * 搜索学生
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("/searchStudent")
    private void searchStudent(HttpServletResponse response, HttpServletRequest request,String txt_search_name,String usercode){
        //获取当前用户权限
        Boolean flag = (Boolean) request.getSession().getAttribute("adminRole");
        String userid = request.getSession().getAttribute("userid").toString();
        List<TmStudent> tmStudents = tmStudentService.findAllStudentByName(null,txt_search_name,usercode,Integer.valueOf(userid),flag);
        Map<String,Object> maps = new HashMap<String,Object>();
        maps.put("students",tmStudents);
        JsonUtilTemp.returnJson(maps,response);
    }
    @RequestMapping("addStudentJilvSure")
    private void addJilvSure(HttpServletResponse response,HttpServletRequest request,TmStudentClassJiLv tmStudentClassJiLv){
        if(tmStudentClassJiLv!=null){
            tmStudentClassJiLv.setCreateDate(new Date());
            String userid = request.getSession().getAttribute("userid").toString();
            tmStudentClassJiLv.setUserId(Integer.valueOf(userid));
            tmStudentClassJiLvRepository.save(tmStudentClassJiLv);
        }
        if(tmStudentClassJiLv!=null&&tmStudentClassJiLv.getId()>0){
            JsonUtilTemp.returnSucessJson(response,"保存学生违反纪律成功");
        }
    }
    @RequestMapping("delStudentJilv")
    private void delStudentJilv(HttpServletResponse response, Integer jilvId){
        if(jilvId!=null&&jilvId>0){
            TmStudentClassJiLv tmClassJiLv = tmStudentClassJiLvRepository.findOne(jilvId);
            tmStudentClassJiLvRepository.delete(tmClassJiLv);
            JsonUtilTemp.returnSucessJson(response,"删除违反纪律纪录成功");
        }
    }

}
