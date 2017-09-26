package com.xiaoyuan.controller;

import com.xiaoyuan.entity.TmKemu;
import com.xiaoyuan.respository.TmKemuRepository;
import com.xiaoyuan.util.JsonUtilTemp;
import org.springframework.beans.factory.annotation.Autowired;
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
    /**
     *  学生列表
     */
    @RequestMapping("/kemuList")
    private String kemuList(HttpServletRequest request, String msg){
        request.setAttribute("msg",msg);
        List<TmKemu> tmKemus = tmKemuRepository.findAll();
        request.setAttribute("tmKemus",tmKemus);
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
            JsonUtilTemp.returnSucessJson(response,"保存成功");
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
            JsonUtilTemp.returnSucessJson(response,"更新班级成功");
        }
    }
    @RequestMapping("deleteKemu")
    private void deleteBanji(HttpServletResponse response, Integer kemuid){
        if(kemuid!=null&&kemuid>0){
            TmKemu tmKemu = tmKemuRepository.findOne(kemuid);
            tmKemuRepository.delete(tmKemu);
            JsonUtilTemp.returnSucessJson(response,"删除班级成功");
        }
    }

}
