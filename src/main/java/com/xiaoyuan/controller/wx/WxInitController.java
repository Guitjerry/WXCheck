package com.xiaoyuan.controller.wx;

import com.xiaoyuan.entity.ZuoyeVo;
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
@RequestMapping(value="/wx")
public class WxInitController {
    @Autowired
    private TmZuoyeService tmZuoyeService;
    @RequestMapping(value = "/checkZuoye")
    public String checkZuoye(HttpServletRequest request) {
        return "wx/checkZuoye";
    }
    @RequestMapping(value = "/checkZuoyeList")
    public String checkZuoyeList(HttpServletRequest request,String usercode) {
        List<ZuoyeVo> zuoyeVoList = tmZuoyeService.listAllZuoyeById(usercode);
        request.setAttribute("zuoyeVoList",zuoyeVoList);
        return "wx/checkZuoyeList";
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
        return "wx/zuoyeListUpload";
    }
}
