package com.xiaoyuan.controller;

import com.xiaoyuan.entity.TmBanJi;
import com.xiaoyuan.entity.TmStudent;
import com.xiaoyuan.respository.TmBanjiRepository;
import com.xiaoyuan.respository.TmStudentRepository;
import com.xiaoyuan.service.TmStudentService;
import com.xiaoyuan.util.JsonUtilTemp;
import org.springframework.beans.factory.annotation.Autowired;
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
    /**
     *  学生列表
     */
    @RequestMapping("/studentList")
    private String userList(HttpServletRequest request, String msg){
        request.setAttribute("msg",msg);
        List<TmStudent> tmStudents = tmStudentService.findAllStudent();

        request.setAttribute("tmStudents",tmStudents);
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
