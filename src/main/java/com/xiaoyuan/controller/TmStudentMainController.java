package com.xiaoyuan.controller;

import com.xiaoyuan.entity.TmBanJi;
import com.xiaoyuan.entity.TmStudent;
import com.xiaoyuan.entity.TmUser;
import com.xiaoyuan.pager.PageBean;
import com.xiaoyuan.pager.PageShow;
import com.xiaoyuan.respository.TmBanjiRepository;
import com.xiaoyuan.respository.TmStudentRepository;
import com.xiaoyuan.service.TmStudentService;
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
    /**
     * 分页查询
     * @param currentPage 当前页号：现在显示的页数
     * @param pageSize 每页显示的记录条数
     * @return 封闭了分页信息(包括记录集list)的Bean
     * */
//    public Page queryForPage(int currentPage, int pageSize) {
//        // TODO Auto-generated method stub
//
//        PageBean<TmStudent> page =new PageBean<>();
//        page.init();
//        //总记录数
//        int allRow = page.getCount();
//        //当前页开始记录
//        int offset =page.getPageSize();
////        //分页查询结果集
////        List<Course> list = courseDao.queryForPage(offset, pageSize);
//
//        page.setPageIndex(currentPage);
//        page.setPageSize(pageSize);
//        page.setTotalRecords(allRow);
//        page.setList(list);
//
//        return page;
//    }

    @SuppressWarnings("unchecked")
    /**
     *  学生列表
     */
    @RequestMapping("/studentList")
    private String userList(HttpServletRequest request, String msg, Integer pageNo, String txt_search_name,String usercode){
        request.setAttribute("msg",msg);
        request.setAttribute("txt_search_name",txt_search_name);
        request.setAttribute("usercode",usercode);
        //初始化pageable
        pageNo=pageNo==null?1:pageNo;
        //根据当前页，每页显示数量返回bean
        PageBean<TmStudent> tmStudentPageBean = tmStudentService.findAllStudent(pageNo,Const.PAGE_SIZE,txt_search_name,usercode);
        if(tmStudentPageBean!=null){
            List<TmStudent> tmStudents = tmStudentPageBean.getList();
            request.setAttribute("tmStudents",tmStudents);
            request.setAttribute("pageShow",tmStudentPageBean);
        }

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
