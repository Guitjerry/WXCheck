package com.xiaoyuan.controller;

import com.xiaoyuan.entity.TmBanJi;
import com.xiaoyuan.entity.TmKemu;
import com.xiaoyuan.entity.TmZuoYe;
import com.xiaoyuan.entity.ZuoyeVo;
import com.xiaoyuan.respository.TmBanjiRepository;
import com.xiaoyuan.respository.TmKemuRepository;
import com.xiaoyuan.respository.TmZuoYeRepository;
import com.xiaoyuan.service.TmKemuService;
import com.xiaoyuan.service.TmZuoyeService;
import com.xiaoyuan.util.JsonUtilTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/zuoye")
public class TmZuoYeController {
    @Autowired
    private TmBanjiRepository tmBanjiRepository;
    @Autowired
    private TmKemuRepository tmKemuRepository;
    @Autowired
    private TmKemuService tmKemuService;
    @Autowired
    private TmZuoYeRepository tmZuoYeRepository;
    @Autowired
    private TmZuoyeService tmZuoyeService;
    @RequestMapping(value = "index")
    public String index(HttpServletRequest request,String msg){
        List<TmBanJi> tmBanJiList = tmBanjiRepository.findAll();
        request.setAttribute("tmBanJiList",tmBanJiList);
        request.setAttribute("msg",msg);
        return "zuoye/index";
    }

    @RequestMapping(value = "savezuoye")
    public void savezuoye(HttpServletResponse response, String msg, TmZuoYe tmZuoYe){
        try{
            tmZuoYeRepository.save(tmZuoYe);
            JsonUtilTemp.returnSucessJson(response,"布置作业成功");
        }catch (Exception e){
            e.printStackTrace();
        }



    }
    @RequestMapping(value = "selectKemuByBanji")
    public void selectKemuByBanji(HttpServletRequest request, HttpServletResponse response,String msg, Integer banjiid){
        List<TmKemu> tmKemus = tmKemuService.selectKemuByBanji(banjiid);
        JsonUtilTemp.returnJson(tmKemus,response);
    }

    /**
     * 班级列表
     */
    @RequestMapping("/zuoyeList")
    private String userList(HttpServletRequest request, String msg){
        request.setAttribute("msg",msg);
//        List<TmZuoYe> tmZuoYes = tmZuoYeRepository.findAll();
//        request.setAttribute("tmZuoYes",tmZuoYes);
        List<ZuoyeVo> zuoyeVos =  tmZuoyeService.listAllZuoye();
        request.setAttribute("zuoyeVos",zuoyeVos);
        return "zuoye/list";
    }
    @RequestMapping("addZuoye")
    private String addBanji(HttpServletResponse response,HttpServletRequest request){
        List<TmBanJi> tmBanJiList = tmBanjiRepository.findAll();
        request.setAttribute("tmBanJiList",tmBanJiList);
        return "zuoye/addZuoye";
    }

    @RequestMapping("addBanjiSure")
    private void addBanjiSure(HttpServletResponse response, TmZuoYe tmZuoYe){
        if(tmZuoYe!=null){
            tmZuoYeRepository.save(tmZuoYe);
        }
        if(tmZuoYe!=null&&tmZuoYe.getId()>0){
            JsonUtilTemp.returnSucessJson(response,"保存成功");
        }
    }


}