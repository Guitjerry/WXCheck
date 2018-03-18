package com.xiaoyuan.controller;

import com.xiaoyuan.entity.*;
import com.xiaoyuan.respository.TmBanjiRepository;
import com.xiaoyuan.respository.TmKemuRepository;
import com.xiaoyuan.respository.TmZuoYeRepository;
import com.xiaoyuan.service.TmKemuService;
import com.xiaoyuan.service.TmUserClassKemuService;
import com.xiaoyuan.service.TmZuoyeService;
import com.xiaoyuan.util.JsonUtilTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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
    @Autowired
    private TmUserClassKemuService tmUserClassKemuService;
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
    @RequestMapping(value = "deleteZuoye")
    public void deleteZuoye(HttpServletResponse response, String msg,Integer zuoyeid){
        try{
            if(zuoyeid>0){
                tmZuoYeRepository.delete(zuoyeid);
                JsonUtilTemp.returnSucessJson(response,"删除作业成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            JsonUtilTemp.returnExceptionJson(response,"删除作业异常");
        }



    }

    @RequestMapping(value = "selectKemuByBanji")
    public void selectKemuByBanji(HttpServletRequest request, HttpServletResponse response,String msg, Integer banjiid){
        //获取当前用户权限
        Boolean flag = (Boolean) request.getSession().getAttribute("adminRole");
        String userid = request.getSession().getAttribute("userid").toString();
        List<TmKemu> tmKemus = new ArrayList<>();
        if(flag){
            tmKemus = tmKemuService.selectKemuByBanji(banjiid);
        }else{
            //查询任课教师的科目
            List<UserKemuVo> userKemuVos =  tmUserClassKemuService.findAllVoByUserId(Integer.valueOf(userid),banjiid);
            for(UserKemuVo userKemuVo:userKemuVos){
                TmKemu tmKemu = new TmKemu();
                tmKemu.setId(userKemuVo.getKemuId());
                tmKemu.setName(userKemuVo.getKemuName());
                tmKemus.add(tmKemu);
            }

        }
        JsonUtilTemp.returnJson(tmKemus,response);
    }

    /**
     * 班级列表
     */
    @RequestMapping("/zuoyeList")
    private String zuoyeList(HttpServletRequest request, String msg,String txt_search_kemu,String txt_search_banji){
        request.setAttribute("msg",msg);
//        List<TmZuoYe> tmZuoYes = tmZuoYeRepository.findAll();
//        request.setAttribute("tmZuoYes",tmZuoYes);
        Boolean flag = (Boolean) request.getSession().getAttribute("adminRole");
        String userid = request.getSession().getAttribute("userid").toString();
        List<ZuoyeVo> zuoyeVos = new ArrayList<>();
        //判断是否传userid
        Integer quuserid = flag==true?null:Integer.valueOf(userid);
        if(flag){
            zuoyeVos =  tmZuoyeService.listAllZuoyeByAdmin(txt_search_kemu,txt_search_banji,quuserid);
        }else{
            zuoyeVos =  tmZuoyeService.listAllZuoye(txt_search_kemu,txt_search_banji,quuserid);
        }
        request.setAttribute("zuoyeVos",zuoyeVos);
        request.setAttribute("txt_search_kemu",txt_search_kemu);
        request.setAttribute("txt_search_banji",txt_search_banji);
        return "zuoye/list";
    }

    /**
     * 班级列表
     */
    @RequestMapping("/editZuoye")
    private String editzuoye(HttpServletRequest request, Integer zuoyeid){
       ZuoyeVo zuoyeVo = tmZuoyeService.listAllZuoyeById(zuoyeid);
        request.setAttribute("zuoye",zuoyeVo);
        return "zuoye/editZuoye";
    }
    @RequestMapping("/editZuoyeSure")
    private void editZuoyeSure(HttpServletRequest request, Integer zuoyeid,String task,HttpServletResponse response){
        TmZuoYe tmZuoYe = tmZuoYeRepository.findOne(zuoyeid);
        tmZuoYe.setTask(task);
        tmZuoYeRepository.saveAndFlush(tmZuoYe);
        JsonUtilTemp.returnSucessJson(response,"更新作业成功");
    }
    @RequestMapping("addZuoye")
    private String addZuoye(HttpServletResponse response,HttpServletRequest request){

        //获取当前用户权限
        Boolean flag = (Boolean) request.getSession().getAttribute("adminRole");
        String userid = request.getSession().getAttribute("userid").toString();
        if(flag){
            List<TmBanJi> tmBanJiList = tmBanjiRepository.findAll();
            request.setAttribute("tmBanJiList",tmBanJiList);
            return "zuoye/addZuoye";
        }

        //非admin，查询出相关的科任教师
        List<TmBanJi> tmBanJis =  tmUserClassKemuService.findAllBanjiByUserId(Integer.valueOf(userid));
        request.setAttribute("tmBanJiList",tmBanJis);
        return "zuoye/addZuoye";
    }

    @RequestMapping("addZuoyeSure")
    private void addZuoyeSure(HttpServletResponse response, TmZuoYe tmZuoYe){
        if(tmZuoYe!=null){
            tmZuoYeRepository.save(tmZuoYe);
        }
        if(tmZuoYe!=null&&tmZuoYe.getId()>0){
            JsonUtilTemp.returnSucessJson(response,"保存成功");
        }
    }


}
