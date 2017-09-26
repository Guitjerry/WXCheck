package com.xiaoyuan.controller;

import com.xiaoyuan.util.JsonUtilTemp;
import com.xiaoyuan.util.UploadFile;
import com.xiaoyuan.util.UploadResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Controller
@RequestMapping("upload")
public class UploadFileController {
    /**
     * @throws Exception

     *
     *             方法名: upload <br />
     *             描述: 上传文件<br />
     *             参数：<br />
     * @param request
     * @param response
     * <br />
     * @return void <br />
     * @throws
     */
    @RequestMapping(value = "/uploadfile")

    public void uploadfile(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {

        //final String uploadPath = "http://localhost:8080/template"+File.separator+"upload";
        String fullUploadPath=request.getServletContext().getRealPath("upload")+File.separator;

        String fullUploadUrl=request.getContextPath()+File.separator+"upload"+File.separator;

        try{
            UploadFile up = new UploadFile(request, fullUploadPath);

                UploadResultVo vo;
                up.saveFile();
                if (null!=up.saveFile && up.saveFile.exists()) {
                    vo = new UploadResultVo(up.fileName, fullUploadUrl + up.fileName, up.oriName);
                } else {
                    vo = new UploadResultVo(false, "上传失败", "", "");
                }
                JsonUtilTemp.returnJson(vo,response);

        }catch(Exception exp){
            exp.printStackTrace();
            JsonUtilTemp.returnExceptionJson(response, "上传失败"+exp.getMessage());
        }
    }
}
