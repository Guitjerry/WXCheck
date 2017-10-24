package com.xiaoyuan.controller.wx;

import com.xiaoyuan.entity.TmUserScore;
import com.xiaoyuan.entity.ZuoyeVo;
import com.xiaoyuan.service.TmUserScoreService;
import com.xiaoyuan.service.TmZuoyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @RequestMapping(value = "/checkZuoye")
    public String checkZuoye(HttpServletRequest request) {
        return "weixin/checkZuoye";
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
        request.setAttribute("tmUserScores",tmUserScores);
        return "weixin/checkCJList";
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
