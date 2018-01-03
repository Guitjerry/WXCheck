package com.xiaoyuan.controller;

import com.xiaoyuan.entity.TmBanJi;
import com.xiaoyuan.entity.TmRole;
import com.xiaoyuan.entity.TmStudent;
import com.xiaoyuan.entity.TmUser;
import com.xiaoyuan.pager.PageBean;
import com.xiaoyuan.pager.PageShow;
import com.xiaoyuan.respository.TmBanjiRepository;
import com.xiaoyuan.respository.TmStudentRepository;
import com.xiaoyuan.service.TmStudentService;
import com.xiaoyuan.service.TmUserRoleService;
import com.xiaoyuan.util.Const;
import com.xiaoyuan.util.JsonUtilTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/student")
public class TmStudentMainController {
    @Autowired
    private TmStudentRepository tmStudentRepository;
    @Autowired
    private TmStudentService tmStudentService;
    @Autowired
    private TmBanjiRepository tmBanjiRepository;
    private TmUserRoleService tmUserRoleService;

    @SuppressWarnings("unchecked")
    /**
     *  学生列表
     */
    @RequestMapping("/studentList")
    private String userList(HttpServletRequest request, String msg, Integer pageNo, String txt_search_name,String usercode){
        request.setAttribute("msg",msg);
        request.setAttribute("txt_search_name",txt_search_name);
        request.setAttribute("usercode",usercode);
        //获取当前用户权限
        Boolean flag = (Boolean) request.getSession().getAttribute("adminRole");
        String userid = request.getSession().getAttribute("userid").toString();
        pageNo=pageNo==null?1:pageNo;
//        if(flag){
//
//
//            //根据当前页，每页显示数量返回bean
//            PageBean<TmStudent> tmStudentPageBean = tmStudentService.findAllStudent(pageNo,Const.PAGE_SIZE,txt_search_name,usercode);
//            if(tmStudentPageBean!=null){
//                List<TmStudent> tmStudents = tmStudentPageBean.getList();
//                request.setAttribute("tmStudents",tmStudents);
//                request.setAttribute("pageShow",tmStudentPageBean);
//            }
//            return "student/list";
//        }
        Pageable pageable = new PageRequest(pageNo,Const.PAGE_SIZE);
        Long counts =0L;
        if(flag){
            counts = tmStudentRepository.count();
        }else{
            counts = tmStudentService.findAllCountByUserid(txt_search_name,usercode,Integer.valueOf(userid));
        }

        List<TmStudent> tmStudents = tmStudentService.findAllStudentByName(pageable,txt_search_name,usercode,Integer.valueOf(userid),flag);
        request.setAttribute("tmStudents",tmStudents);
        request.setAttribute("counts",counts);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pagesize",Const.PAGE_SIZE);
        return "student/list";
    }
    @RequestMapping("addStudent")
    private String addStudent(HttpServletResponse response,HttpServletRequest request){
       List<TmBanJi> tmBanJis = tmBanjiRepository.findAll();
        request.setAttribute("tmBanJis",tmBanJis);
        //查询班级信息
        return "student/addStudent";
    }

    @RequestMapping("addStudentSure")
    private void addBanjiSure(HttpServletResponse response, TmStudent tmStudent){
        if(tmStudent!=null){
            tmStudentRepository.save(tmStudent);
        }
        if(tmStudent!=null&&tmStudent.getId()>0){
            JsonUtilTemp.returnSucessJson(response,"保存成功");
        }
    }
    @RequestMapping("editStudent")
    private String editBanji(HttpServletResponse response,HttpServletRequest request,Integer studentid){
        List<TmBanJi> tmBanJis = tmBanjiRepository.findAll();
        request.setAttribute("tmBanJis",tmBanJis);
        TmStudent tmStudent = tmStudentRepository.findOne(studentid);
        request.setAttribute("student",tmStudent);
        return "student/editStudent";
    }
    @RequestMapping("editStudentSure")
    private void editBanjiSure(HttpServletResponse response, TmStudent tmStudent){
        if(tmStudent!=null&&tmStudent.getId()>0){
            tmStudentRepository.saveAndFlush(tmStudent);
            JsonUtilTemp.returnSucessJson(response,"更新班级成功");
        }
    }
    @RequestMapping("deleteStudent")
    private void deleteBanji(HttpServletResponse response, Integer studentid){
        if(studentid!=null&&studentid>0){
            TmStudent tmStudent = tmStudentRepository.findOne(studentid);
            tmStudentRepository.delete(tmStudent);
            JsonUtilTemp.returnSucessJson(response,"删除班级成功");
        }
    }

}
