package com.xiaoyuan.controller;

import com.xiaoyuan.entity.TmBanJi;
import com.xiaoyuan.entity.TmBanjiKemu;
import com.xiaoyuan.entity.TmKemu;
import com.xiaoyuan.respository.TmBanjiKemuRepository;
import com.xiaoyuan.respository.TmBanjiRepository;
import com.xiaoyuan.respository.TmKemuRepository;
import com.xiaoyuan.util.JsonUtilTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by dnys on 2017/9/20.
 */
@Controller
@RequestMapping("/banji")
public class TmBanjiMainController {
    @Autowired
    private TmBanjiRepository tmBanjiRepository;
    @Autowired
    private TmKemuRepository tmKemuRepository;
    @Autowired
    private TmBanjiKemuRepository tmBanjiKemuRepository;
    /**
     * 班级列表
     */
    @RequestMapping("/banjiList")
    private String userList(HttpServletRequest request, String msg){
        request.setAttribute("msg",msg);
        List<TmBanJi> tmBanJis = tmBanjiRepository.findAll();
        request.setAttribute("tmBanJis",tmBanJis);
        return "banji/list";
    }
    @RequestMapping("addBanji")
    private String addBanji(HttpServletResponse response){

        return "banji/addBanji";
    }

    @RequestMapping("addBanjiSure")
    private void addBanjiSure(HttpServletResponse response, TmBanJi tmBanJi){
        if(tmBanJi!=null){
            tmBanjiRepository.save(tmBanJi);
        }
        if(tmBanJi!=null&&tmBanJi.getID()>0){
            JsonUtilTemp.returnSucessJson(response,"保存成功");
        }
    }
    @RequestMapping("editBanji")
    private String editBanji(HttpServletResponse response,HttpServletRequest request,Integer banjiid){
        TmBanJi tmBanJi = tmBanjiRepository.findOne(banjiid);
        request.setAttribute("banji",tmBanJi);
        return "banji/editBanji";
    }
    @RequestMapping("editBanjiSure")
    private void editBanjiSure(HttpServletResponse response, TmBanJi tmBanJi){
      if(tmBanJi!=null&&tmBanJi.getID()>0){
          tmBanjiRepository.saveAndFlush(tmBanJi);
          JsonUtilTemp.returnSucessJson(response,"更新班级成功");
      }
    }
    @RequestMapping("deleteBanji")
    private void deleteBanji(HttpServletResponse response, Integer banjiid){
        if(banjiid!=null&&banjiid>0){
           TmBanJi tmBanJi = tmBanjiRepository.findOne(banjiid);
            tmBanjiRepository.delete(tmBanJi);
            JsonUtilTemp.returnSucessJson(response,"删除班级成功");
        }
    }

    /**
     * 分配科目
     */
    @RequestMapping("fpKemu")
    private String fpResource(HttpServletRequest request,Integer banjiid){
        List<TmKemu> tmKemus =  tmKemuRepository.findAll();
        request.setAttribute("tmKemus",tmKemus);
        request.setAttribute("banjiid",banjiid);
        List<TmBanjiKemu> tmBanjiKemus =  tmBanjiKemuRepository.findAllBybanjiid(banjiid);
        request.setAttribute("selectkemu",tmBanjiKemus);
        return "banji/fpKemu";
    }
    /**
     * 分配学生
     */
    @RequestMapping("fpStudent")
    private String fpStudent(HttpServletRequest request,Integer banjiid){
        request.setAttribute("banjiid",banjiid);
        return "banji/fpStudent";
    }

    @RequestMapping("banjiToKemu")
    private void banjiToKemu(HttpServletResponse response,Integer banjiid,@RequestParam(value = "kemuids[]")String[] kemuids) {

        if (kemuids == null || kemuids.length == 0) {
            JsonUtilTemp.returnFailJson(response, "至少需要选择一个科目");
        }
        //根据roleid查找数据，删除在添加
        List<TmBanjiKemu> existBanjiKemus = tmBanjiKemuRepository.findAllBybanjiid(banjiid);
        for (TmBanjiKemu tmBanjiKemu : existBanjiKemus) {
            tmBanjiKemuRepository.delete(tmBanjiKemu);
        }
        try {
            if (kemuids != null && kemuids.length > 0) {
                for (String kemuid : kemuids) {
                    TmBanjiKemu tmBanjiKemu = new TmBanjiKemu();
                    tmBanjiKemu.setBanjiid(banjiid);
                    tmBanjiKemu.setKemuid(Integer.valueOf(kemuid));
                    tmBanjiKemuRepository.save(tmBanjiKemu);
                }
                JsonUtilTemp.returnSucessJson(response, "分配科目成功");
            }

        } catch (Exception e) {
            JsonUtilTemp.returnFailJson(response, e.getMessage());
        }
    }
}
