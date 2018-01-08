package com.xiaoyuan.controller;

import com.xiaoyuan.entity.TmClassJiLv;
import com.xiaoyuan.entity.TmKemu;
import com.xiaoyuan.pager.PageBean;
import com.xiaoyuan.respository.TmClassJiLvRepository;
import com.xiaoyuan.util.Const;
import com.xiaoyuan.util.JsonUtilTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 纪律管理
 */
@Controller
@RequestMapping("/jilv")
public class TmClassJiLvController {
    @Autowired
    private TmClassJiLvRepository tmClassJiLvRepository;
    /**
     *  科目列表
     */
    @RequestMapping("/jilvList")
    private String jilvList(HttpServletRequest request, String msg, Integer pageNo){
        request.setAttribute("msg",msg);
        List<TmClassJiLv> tmClassJiLvs = tmClassJiLvRepository.findAll();
        //分页
        request.setAttribute("tmClassJiLvs",tmClassJiLvs);
        return "jilv/list";
    }
    @RequestMapping("addJilv")
    private String addJilv(HttpServletResponse response){

        return "jilv/addJilv";
    }

    @RequestMapping("addJilvSure")
    private void addJilvSure(HttpServletResponse response, TmClassJiLv tmClassJiLv){
        if(tmClassJiLv!=null){
            tmClassJiLvRepository.save(tmClassJiLv);
        }
        if(tmClassJiLv!=null&&tmClassJiLv.getId()>0){
            JsonUtilTemp.returnSucessJson(response,"保存纪律成功");
        }
    }
    @RequestMapping("editJilv")
    private String editJilv(HttpServletResponse response,HttpServletRequest request,Integer jilvId){
        TmClassJiLv tmClassJiLv = tmClassJiLvRepository.findOne(jilvId);
        request.setAttribute("tmClassJiLv",tmClassJiLv);
        return "jilv/editJilv";
    }
    @RequestMapping("editJilvSure")
    private void editBanjiSure(HttpServletResponse response, TmClassJiLv tmClassJiLv){
        if(tmClassJiLv!=null&&tmClassJiLv.getId()>0){
            tmClassJiLvRepository.saveAndFlush(tmClassJiLv);
            JsonUtilTemp.returnSucessJson(response,"更新纪律成功");
        }
    }
    @RequestMapping("deleteJilv")
    private void deleteJilv(HttpServletResponse response, Integer jilvId){
        if(jilvId!=null&&jilvId>0){
            TmClassJiLv tmClassJiLv = tmClassJiLvRepository.findOne(jilvId);
            tmClassJiLvRepository.delete(tmClassJiLv);
            JsonUtilTemp.returnSucessJson(response,"删除纪律成功");
        }
    }
}
