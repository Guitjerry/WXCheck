package com.xiaoyuan.controller.wx;

import com.xiaoyuan.entity.TmStudent;
import com.xiaoyuan.entity.TmUserScore;
import com.xiaoyuan.entity.ZuoyeVo;
import com.xiaoyuan.service.TmStudentService;
import com.xiaoyuan.service.TmUserScoreService;
import com.xiaoyuan.service.TmZuoyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dnys on 2017/10/17.
 */
@Controller
@RequestMapping(value="/weixin")
public class WxInitController {
    @Autowired
    private TmZuoyeService tmZuoyeService;
    @Autowired
    private TmUserScoreService tmUserScoreService;
    @Autowired
    private TmStudentService tmStudentService;
    @RequestMapping(value = "/checkZuoye")
    public String checkZuoye(HttpServletRequest request) {
        return "weixin/checkZuoye";
    }
    @RequestMapping(value = "/login/main")
    public String login(HttpServletRequest request) {
        return "weixin/login/main";
    }

    /**
     * 查看学生成绩
     * @param request
     * @return
     */
    @RequestMapping(value = "/checkCJ")
    public String checkCJ(HttpServletRequest request) {
        return "weixin/checkCJ";
    }
    @RequestMapping(value = "/checkZuoyeList")
    public String checkZuoyeList(HttpServletRequest request,String usercode) {
        List<ZuoyeVo> zuoyeVoList = tmZuoyeService.listAllZuoyeById(usercode);
        request.setAttribute("zuoyeVoList",zuoyeVoList);
        return "weixin/checkZuoyeList";
    }
    @RequestMapping(value = "/checkCJList")
    public String checkCJList(HttpServletRequest request,String usercode) {
        List<TmUserScore> tmUserScores =  tmUserScoreService.findAllByNameOrStudentCode(usercode);
        List<TmUserScore> alltmUserScores =  new ArrayList<>();
         List<String> scorebanjiindex = tmUserScoreService.findBanjiIndex(usercode);
         List<String> scorenianjiindex = tmUserScoreService.findNianjiIndex(usercode);
         for(int i=0;i<tmUserScores.size();i++){
             TmUserScore tmUserScore = tmUserScores.get(i);
             tmUserScore.setBanjiindexs(String.valueOf(scorebanjiindex.get(i)));
             tmUserScore.setNianjiindexs(String.valueOf(scorenianjiindex.get(i)));
             alltmUserScores.add(tmUserScore);
         }
        request.setAttribute("tmUserScores",alltmUserScores);
        return "weixin/checkCJList";
    }
    @RequestMapping(value = "/checkLogin")
    public @ResponseBody Map<String,Object> checkLogin(HttpServletRequest request, String usercode, String password) {
        Map<String,Object> resultMap = new HashMap<>();
        List<TmStudent> tmStudents =  tmStudentService.findStudentByUserCodeAndPassword(usercode,password);
       if(tmStudents.size()>0){
           resultMap.put("successmsg","登录成功");
       }else{
           resultMap.put("errormsg","登录失败,用户名或密码不正确");
       }
       return  resultMap;
    }
    /**
     * 作业明细以及上传
     * @param request
     * @return
     */
    @RequestMapping(value = "/zuoyeListUpload")
    public String ZuoyeListUpload(HttpServletRequest request,Integer zuoyeid) {
//        List<ZuoyeVo> zuoyeVoList = tmZuoyeService.listAllZuoyeById(usercode);
        //request.setAttribute("zuoyeVoList",zuoyeVoList);
        ZuoyeVo zuoyeVo = tmZuoyeService.listAllZuoyeById(zuoyeid);
        request.setAttribute("zuoyeVo",zuoyeVo);
        return "weixin/zuoyeListUpload";
    }
}
