package com.xiaoyuan.controller;

import com.xiaoyuan.entity.*;
import com.xiaoyuan.respository.*;
import com.xiaoyuan.service.TmResourceService;
import com.xiaoyuan.service.TmUserRoleService;
import com.xiaoyuan.service.TmUserService;
import com.xiaoyuan.util.ExcelConfig;
import com.xiaoyuan.util.JsonUtilTemp;
import com.xiaoyuan.util.JxlExcelUtil;
import com.xiaoyuan.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 初始化数据
 */
@Controller
@RequestMapping(value="/init")
public class InitController {
    @Autowired
    private TmBanjiRepository tmBanjiRepository;
    @Autowired
    private TmNianjiRepository tmNianjiRepository;
    @Autowired
    private TmStudentRepository tmStudentRepository;
    @Autowired
    private TmKemuRepository tmKemuRepository;
    @Autowired
    private TmTeacherRepository tmTeacherRepository;
    @Autowired
    private TmResourceService tmResourceService;
    @Autowired
    private TmUserRepository tmUserRepository;
    @Autowired
    private TmUserService tmUserService;
    @Autowired
    private TmUserRoleService tmUserRoleService;
    public List<Object> commonImportBack(InputStream in,String filename,String configxml,String tablename,Object target){
        List<Object> reportExcelDatas = new ArrayList<Object>();

        //反射解析得到相应的对象集合
        try{
            //解析对应配置文件，封装到对象
            String filePath = InitController.class.getClassLoader().getResource(configxml).getPath();

            ExcelConfig excelConfig = new JxlExcelUtil().combineExcelConfig(filePath,tablename);
            //反射解析得到相应的对象集合
            List<List<Object>> listob = new JxlExcelUtil().getBankListByJXLExcel(in,null, target,filePath,excelConfig);
            if(listob!=null&&listob.size()>0){
                for(List<Object> mainobj:listob){
                    for(Object obj:mainobj){
                        reportExcelDatas.add( target.getClass().cast(obj));
                    }
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return reportExcelDatas;
    }
    @RequestMapping(value = "/initicon")
    public String initicon(HttpServletRequest request){
        return "init/icon";
    }
    /**
     * 初始化班级数据
     */
    @RequestMapping(value = "/initbanji")
    public void initBanji(HttpServletRequest request, HttpServletResponse response){
        try {
           File file = ResourceUtils.getFile("classpath:banji.xls");
            InputStream in = new FileInputStream(file);
            List<Object> objects = commonImportBack(in,"upfile","excelConfig.xml","TM_BANJI",new TmBanJi());
            for(Object object:objects){
                TmBanJi tmBanJi = (TmBanJi) object;
                TmBanJi tmBan = tmBanjiRepository.findOne(tmBanJi.getID());
                if(tmBan==null) {
                    tmBanjiRepository.save(tmBanJi);
                }
            }
            JsonUtilTemp.returnSucessJson(response,"导入数据成功");

        } catch (Exception e) {
            e.printStackTrace();
            JsonUtilTemp.returnExceptionJson(response,e.getMessage());
        }


    }
    /**
     * 初始化年级数据
     */
    @RequestMapping(value = "/initnianji")
    public void initNianji(HttpServletRequest request, HttpServletResponse response){
        try {
            File file = ResourceUtils.getFile("classpath:nianji.xls");
            InputStream in = new FileInputStream(file);
            List<Object> objects = commonImportBack(in,"upfile","excelConfig.xml","TM_NIANJI",new TmNianji());
            for(Object object:objects){
                TmNianji tmNianji = (TmNianji) object;
                TmNianji tmNian = tmNianjiRepository.findOne(tmNianji.getId());
                if(tmNian==null){
                    tmNianjiRepository.save(tmNianji);
                }
            }
            JsonUtilTemp.returnSucessJson(response,"导入数据成功");

        } catch (Exception e) {
            e.printStackTrace();
            JsonUtilTemp.returnExceptionJson(response,e.getMessage());
        }


    }
    /**
     * 初始化学生数据
     */
    @RequestMapping(value = "/initStudent")
    public void initStudent(HttpServletRequest request, HttpServletResponse response){
        try {
            File file = ResourceUtils.getFile("classpath:student.xls");
            InputStream in = new FileInputStream(file);
            List<Object> objects = commonImportBack(in,"upfile","excelConfig.xml","TM_STUDENT",new TmStudent());
            for(Object object:objects){
                TmStudent tmStudent = (TmStudent) object;
                tmStudent.setStatus(0);
                TmStudent student = tmStudentRepository.findOne(tmStudent.getId());
                if(student==null) {
                    tmStudentRepository.save(tmStudent);
                }
            }
            JsonUtilTemp.returnSucessJson(response,"导入数据成功");

        } catch (Exception e) {
            e.printStackTrace();
            JsonUtilTemp.returnExceptionJson(response,e.getMessage());
        }


    }
    /**
     * 初始化学生数据
     */
    @RequestMapping(value = "/initKemu")
    public void initKemu(HttpServletRequest request, HttpServletResponse response){
        try {
            File file = ResourceUtils.getFile("classpath:kemu.xls");
            InputStream in = new FileInputStream(file);
            List<Object> objects = commonImportBack(in,"upfile","excelConfig.xml","TM_KEMU",new TmKemu());
            for(Object object:objects){
                TmKemu tmKemu = (TmKemu) object;
                TmKemu kemu = tmKemuRepository.findOne(tmKemu.getId());
                if(kemu==null) {
                    tmKemuRepository.save(tmKemu);
                }
            }
            JsonUtilTemp.returnSucessJson(response,"导入数据成功");

        } catch (Exception e) {
            e.printStackTrace();
            JsonUtilTemp.returnExceptionJson(response,e.getMessage());
        }


    }

    /**
     * 初始化学生数据
     */
    @RequestMapping(value = "/initTeacher")
    public void initTeacher(HttpServletRequest request, HttpServletResponse response){
        try {
            File file = ResourceUtils.getFile("classpath:techer.xls");
            InputStream in = new FileInputStream(file);
            List<Object> objects = commonImportBack(in,"upfile","excelConfig.xml","TM_TEACHER",new TmTeacher());
            for(Object object:objects){
                TmTeacher tmTeacher = (TmTeacher) object;
                TmTeacher teacher = tmTeacherRepository.findOne(tmTeacher.getId());
                if(teacher==null) {
                    tmTeacherRepository.save(tmTeacher);
                }
            }
            JsonUtilTemp.returnSucessJson(response,"导入数据成功");

        } catch (Exception e) {
            e.printStackTrace();
            JsonUtilTemp.returnExceptionJson(response,e.getMessage());
        }


    }

    /**
     * 登出
     * @param request
     * @param response
     */
    @RequestMapping(value = "/logout")
    public void logout(HttpServletRequest request,HttpServletResponse response){
        try {
            Enumeration em = request.getSession().getAttributeNames();
            while(em.hasMoreElements()){
                request.getSession().removeAttribute(em.nextElement().toString());
            }
            response.sendRedirect(request.getContextPath()+"/wxCheck/init/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 登出
     * @param request
     * @param response
     */
    @RequestMapping(value = "/resetPassword")
    public String resetPassword(HttpServletRequest request,HttpServletResponse response,String userid){
        String url = request.getContextPath();
        return "init/resetPassword";
    }
    @RequestMapping(value = "/resetPasswordSure")
    public void resetPasswordSure(HttpServletRequest request,HttpServletResponse response,Integer userid,String oldpassword,String newpassword){
        try{
            if(StringUtils.isEmpty(oldpassword)){
                JsonUtilTemp.returnFailJson(response,"请输入原始密码");
            }

            if(StringUtils.isEmpty(newpassword)){
                JsonUtilTemp.returnFailJson(response,"请输入新密码");
            }
            TmUser user = tmUserRepository.findOne(userid);
            if(!user.getPassword().equals(MD5Util.string2MD5(oldpassword))){
                JsonUtilTemp.returnFailJson(response,"输入的原始密码不正确");
            }else{
                user.setPassword(MD5Util.string2MD5(newpassword));
                tmUserRepository.saveAndFlush(user);
                JsonUtilTemp.returnSucessJson(response,"重置密码成功");
            }

        }catch (Exception e){
            e.printStackTrace();
            JsonUtilTemp.returnFailJson(response,e.getMessage());
        }

    }
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request){

        return  "init/login";
    }
    @RequestMapping(value = "/loginsure")
    public void loginsure(HttpServletRequest request,HttpServletResponse response,String account,String password){

        if(StringUtils.isEmpty(account)){
            JsonUtilTemp.returnFailJson(response,"账户不能为空!");
            return;
        }
        if(StringUtils.isEmpty(password)){
            JsonUtilTemp.returnFailJson(response,"密码不能为空!");
            return;
        }

        if(StringUtils.isEmpty(account)){
            JsonUtilTemp.returnSucessJson(response,"账户名不能为空");
        }
        if(StringUtils.isEmpty(password)){
            JsonUtilTemp.returnSucessJson(response,"密码不能为空");
        }
       List<TmUser> tmUsers =  tmUserService.findAllByaccountAndpassword(account,password);
       if(tmUsers!=null&&tmUsers.size()>0){
           request.getSession().setAttribute("username",tmUsers.get(0).getName());
           request.getSession().setAttribute("userid",tmUsers.get(0).getId());
           boolean flag = false;
           List<TmRole> tmRoles = tmUserRoleService.findAllRoleByUserId(tmUsers.get(0).getId());
           for(TmRole tmRole:tmRoles) {
               if ("admin".equals(tmRole.getCode())||"manager".equals(tmRole.getCode())) {
                   flag = true;
               }
           }
           request.getSession().setAttribute("adminRole",flag);//纪录是否admin权限账户登录
           JsonUtilTemp.returnSucessJson(response,"成功登录系统");
       }else{
           JsonUtilTemp.returnFailJson(response,"账户或者密码错误!");
       }
    }
    @RequestMapping(value = "/leftinit")
    public void leftinit(HttpServletRequest request,HttpServletResponse response,Integer userid){
        //查找所有父级菜单
        List<TmResource> parnetresources =tmResourceService.findAllParentByUserId(userid);
        //查找所以子级
        List<TmResource> resources =tmResourceService.findAllByUserId(userid);
        LeftMenuVo leftMenuVo = new LeftMenuVo();
        leftMenuVo.setParentResource(parnetresources);
        leftMenuVo.setChildResource(resources);
        JsonUtilTemp.returnJson(leftMenuVo,response);

    }
    @RequestMapping(value = "/welcome")
    public String welcome(HttpServletRequest request){
        return "/init/welcome";
    }

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request,String msg){

        //查找所有父级菜单
        List<TmResource> resources =tmResourceService.findAllParent();
        String parentdiv = "";

        List<LeftMenuVo> leftMenuVos = new ArrayList<>();
        //得到相应子级菜单
        for(TmResource resource:resources){
            LeftMenuVo leftMenuVo = new LeftMenuVo();
            List<TmResource> childrenResources = tmResourceService.findAllByParentid(resource.getId());
            parentdiv = "<div class=\"link\">"+"<i class='"+resource.getIcon()+"'"+"></i>"+resource.getName()+"</div>";
//            <li><a href="#">班级管理</a></li>
            String childrenli="";
            for(TmResource childrenResource:childrenResources){
                String link = childrenResource.getLink();
                String linkmsg = "";
                String limsg = "";
                if(!StringUtils.isEmpty(link)&&link.indexOf("?")>-1){
                   linkmsg = link.substring(link.indexOf("?"));
                    limsg = link.substring(link.indexOf("?")+1);
                }
                childrenli += "<li "+linkmsg+">"+" <a href="+childrenResource.getLink()+">"+childrenResource.getName()+"</a></li>";
            }
            if(childrenResources.size()>0){
                childrenli = "<ul class=\"submenu\">"+childrenli+"</ul> ";
            }

            leftMenuVo.setParentdiv(parentdiv);
            leftMenuVo.setChildreli(childrenli);
            leftMenuVos.add(leftMenuVo);

        }
        request.setAttribute("leftmenus",leftMenuVos);
        return "init/index";

    }
}
