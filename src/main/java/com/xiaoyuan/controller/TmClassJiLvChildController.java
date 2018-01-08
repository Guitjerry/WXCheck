package com.xiaoyuan.controller;

import com.xiaoyuan.entity.TmClassJiLv;
import com.xiaoyuan.entity.TmClassJiLvChild;
import com.xiaoyuan.respository.TmClassJiLvChildRepository;
import com.xiaoyuan.respository.TmClassJiLvRepository;
import com.xiaoyuan.service.TmClassJiLvChildService;
import com.xiaoyuan.util.JsonUtilTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 新增明细纪律
 */
@Controller
@RequestMapping("/jilvChild")
public class TmClassJiLvChildController {
    @Autowired
    private TmClassJiLvChildRepository tmClassJiLvChildRepository;
    @Autowired
    private TmClassJiLvRepository tmClassJiLvRepository;
    @Autowired
    private TmClassJiLvChildService tmClassJiLvChildService;
    /**
     *  明细纪律列表
     */
    @RequestMapping("/jilvChildList")
    private String kemuList(HttpServletRequest request, String msg, Integer pageNo){
        request.setAttribute("msg",msg);
        List<TmClassJiLvChild> tmClassJiLvChildList = tmClassJiLvChildService.findAll();
        //分页
        request.setAttribute("tmClassJiLvChildList",tmClassJiLvChildList);
        return "jilvChild/list";
    }

    /**
     * 新增明细纪律
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("addJilvChild")
    private String addJilv(HttpServletResponse response,HttpServletRequest request){
        List<TmClassJiLv> tmClassJiLvs = tmClassJiLvRepository.findAll();

        request.setAttribute("tmClassJiLvs",tmClassJiLvs);
        return "jilvChild/addJilv";
    }

    @RequestMapping("addJilvChildSure")
    private void addJilvChildSure(HttpServletResponse response, TmClassJiLvChild tmClassJiLv){
        if(tmClassJiLv!=null){
            tmClassJiLvChildRepository.save(tmClassJiLv);
        }
        if(tmClassJiLv!=null&&tmClassJiLv.getId()>0){
            JsonUtilTemp.returnSucessJson(response,"保存明细纪律成功");
        }
    }
    @RequestMapping("editJilvChild")
    private String editJilv(HttpServletResponse response,HttpServletRequest request,Integer jilvId){
        TmClassJiLvChild tmClassJiLv = tmClassJiLvChildRepository.findOne(jilvId);
        request.setAttribute("tmClassJiLv",tmClassJiLv);
        return "jilvChild/editJilv";
    }
    @RequestMapping("editJilvSure")
    private void editBanjiSure(HttpServletResponse response, TmClassJiLvChild tmClassJiLv){
        if(tmClassJiLv!=null&&tmClassJiLv.getId()>0){
            tmClassJiLvChildRepository.saveAndFlush(tmClassJiLv);
            JsonUtilTemp.returnSucessJson(response,"更新明细纪律成功");
        }
    }
    @RequestMapping("deleteJilvChild")
    private void deleteJilvChild(HttpServletResponse response, Integer jilvId){
        if(jilvId!=null&&jilvId>0){
            TmClassJiLvChild tmClassJiLv = tmClassJiLvChildRepository.findOne(jilvId);
            tmClassJiLvChildRepository.delete(tmClassJiLv);
            JsonUtilTemp.returnSucessJson(response,"删除明细纪律成功");
        }
    }
}
