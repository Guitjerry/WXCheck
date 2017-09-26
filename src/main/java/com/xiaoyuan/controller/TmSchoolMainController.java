package com.xiaoyuan.controller;

import com.xiaoyuan.entity.TmStudent;
import com.xiaoyuan.respository.TmStudentRepository;
import com.xiaoyuan.util.JsonUtilTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *学校管理，分配班级，学生，科目
 */
@Controller
public class TmSchoolMainController {
    @Autowired
    private TmStudentRepository tmStudentRepository;
    /**
     * 后台初始界面
     * @param request
     * @return
     */
    @RequestMapping(value="/index")
    public String index(HttpServletRequest request, HttpServletResponse response,String msg){

       List<TmStudent> tmStudents = tmStudentRepository.findAll();
        request.setAttribute("msg",msg);
//        JsonUtilTemp.returnJson(tmStudents,response);
        return "index";

    }
    @RequestMapping(value="/addUser")
    public void addUser(HttpServletRequest request, HttpServletResponse response,String msg){

       TmStudent student = new TmStudent();
        student.setId(111);
        student.setName("测试");
        tmStudentRepository.save(student);
        JsonUtilTemp.returnJson(student,response);


    }
//    public void
}
