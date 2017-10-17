package com.xiaoyuan.controller;

import com.xiaoyuan.entity.TmKemu;
import com.xiaoyuan.pager.PageBean;
import com.xiaoyuan.respository.TmKemuRepository;
import com.xiaoyuan.service.TmKemuService;
import com.xiaoyuan.util.Const;
import com.xiaoyuan.util.JsonUtilTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 科目管理
 */
@Controller
@RequestMapping("kemu")
public class TmKeMuMainController {
    @Autowired
    private TmKemuRepository tmKemuRepository;
    @Autowired
    private TmKemuService tmKemuService;
    /**
     *  科目列表
     */
    @RequestMapping("/kemuList")
    private String kemuList(HttpServletRequest request, String msg,Integer pageNo){
        request.setAttribute("msg",msg);


        pageNo=pageNo==null?1:pageNo;
        //所有科目量
        List<TmKemu> alltmKemus = tmKemuRepository.findAll();
        //分页
        PageRequest pageable = new PageRequest(pageNo, Const.PAGE_SIZE);
        List<TmKemu> tmKemus = tmKemuService.findAllTmKemu(pageable);
        PageBean mypage = new PageBean();
        mypage.setPageIndex(pageNo);
        mypage.setCount(alltmKemus.size());
        mypage.setPageCount(Const.PAGE_SIZE);
        request.setAttribute("tmKemus",tmKemus);
        request.setAttribute("pageShow",mypage);
        return "kemu/list";
    }
    @RequestMapping("addKemu")
    private String addKemu(HttpServletResponse response){

        return "kemu/addKemu";
    }

    @RequestMapping("addKemuSure")
    private void addBanjiSure(HttpServletResponse response, TmKemu tmKemu){
        if(tmKemu!=null){
            tmKemuRepository.save(tmKemu);
        }
        if(tmKemu!=null&&tmKemu.getId()>0){
            JsonUtilTemp.returnSucessJson(response,"保存科目成功");
        }
    }
    @RequestMapping("editKemu")
    private String editBanji(HttpServletResponse response,HttpServletRequest request,Integer kemuid){
        TmKemu tmKemu = tmKemuRepository.findOne(kemuid);
        request.setAttribute("tmkemu",tmKemu);
        return "kemu/editKemu";
    }
    @RequestMapping("editKemuSure")
    private void editBanjiSure(HttpServletResponse response, TmKemu tmKemu){
        if(tmKemu!=null&&tmKemu.getId()>0){
            tmKemuRepository.saveAndFlush(tmKemu);
            JsonUtilTemp.returnSucessJson(response,"更新科目成功");
        }
    }
    @RequestMapping("deleteKemu")
    private void deleteBanji(HttpServletResponse response, Integer kemuid){
        if(kemuid!=null&&kemuid>0){
            TmKemu tmKemu = tmKemuRepository.findOne(kemuid);
            tmKemuRepository.delete(tmKemu);
            JsonUtilTemp.returnSucessJson(response,"删除科目成功");
        }
    }

}
