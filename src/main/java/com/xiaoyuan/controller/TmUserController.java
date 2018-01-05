package com.xiaoyuan.controller;

import com.xiaoyuan.entity.*;
import com.xiaoyuan.respository.*;
import com.xiaoyuan.service.TmResourceService;
import com.xiaoyuan.service.TmUserClassKemuService;
import com.xiaoyuan.service.TmUserRoleService;
import com.xiaoyuan.service.TmUserService;
import com.xiaoyuan.util.Const;
import com.xiaoyuan.util.JsonUtilTemp;
import com.xiaoyuan.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dnys on 2017/9/18.
 */
@Controller
@RequestMapping("/user")
public class TmUserController {
    @Autowired
    private TmUserRepository tmUserRepository;
    @Autowired
    private TmResourceService tmResourceService;
    @Autowired
    private TmUserRoleRepository tmUserRoleRepository;
    @Autowired
    private TmRoleRepository tmRoleRepository;
    @Autowired
    private TmUserService tmUserService;
    @Autowired
    private TmUserRoleService tmUserRoleService;
    @Autowired
    private TmBanjiRepository tmBanjiRepository;
    @Autowired
    private TmUserClassKemuService tmUserClassKemuService;
    @Autowired
    private TmUserClassKemuRepository tmUserClassKemuRepository;
    @Autowired
    private TmKemuRepository tmKemuRepository;
    @RequestMapping("addUser")
    private String addUser(HttpServletResponse response){

        return "user/addUser";
    }
    @RequestMapping("addUserSure")
    private void addUserSure(HttpServletResponse response, TmUser tmuser){
        if(tmuser!=null){
            if(!StringUtils.isEmpty(tmuser.getPassword())){
                tmuser.setPassword(MD5Util.string2MD5(tmuser.getPassword()));
            }
            tmUserRepository.save(tmuser);
        }
        if(tmuser!=null&&tmuser.getId()>0){
            JsonUtilTemp.returnSucessJson(response,"保存成功");
        }
    }

    /**
     * 编辑用户
     */
    @RequestMapping("editUser")
    private String editUser(Integer userid,HttpServletRequest request){
        if(userid!=null){
            TmUser tmUser = tmUserRepository.findOne(userid);
            request.setAttribute("user",tmUser);
        }
        return "user/editUser";
    }
    @RequestMapping("deleteUser")
    private void deleteUser(Integer userid,HttpServletRequest request,HttpServletResponse response){
        if(userid!=null){
            tmUserRepository.delete(userid);
            JsonUtilTemp.returnSucessJson(response,"数据删除成功");
        }
    }

    /**
     * 编辑用户确定
     */
    @RequestMapping("editUserSure")
    private void editUserSure(TmUser tmUser,HttpServletRequest request,HttpServletResponse response){
        if(tmUser!=null&&tmUser.getId()>0){
//            tmUser.setPassword(MD5Util.string2MD5(tmUser.getPassword()));
            tmUserRepository.saveAndFlush(tmUser);
            JsonUtilTemp.returnSucessJson(response,"数据更新成功");
        }


    }
    /**
     * 用户列表
     */
    @RequestMapping("/userList")
    private String userList(HttpServletRequest request,String msg,String txt_search_account,String txt_search_name,String txt_search_phone,Integer pageNo){
        request.setAttribute("msg",msg);
        int userid = Integer.valueOf(request.getSession().getAttribute("userid").toString());
        List<TmRole> tmRoles = tmUserRoleService.findAllRoleByUserId(userid);
        for(TmRole tmRole:tmRoles){
            if("admin".equals(tmRole.getCode())){
                request.setAttribute("admin","yes");
            }
        }
        pageNo= pageNo==null?1:pageNo;
          long counts =  tmUserRepository.count();
          Pageable pageable = new PageRequest(pageNo-1, Const.PAGE_SIZE);
//        Page<TmUser> pageBean = tmUserRepository.findAll(pageable);

        List<TmUser> tmUsers = tmUserService.findAllByaccountAndNameAndPhone(txt_search_account,txt_search_name,txt_search_phone,pageable,pageNo);
        request.setAttribute("tmUsers",tmUsers);
        request.setAttribute("counts",counts);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pagesize",Const.PAGE_SIZE);
        request.setAttribute("txt_search_account",txt_search_account);
        request.setAttribute("txt_search_name",txt_search_name);
        request.setAttribute("txt_search_phone",txt_search_phone);
//        leftCommon(request);
        return "user/list";
    }
//    public void leftCommon(HttpServletRequest request){
//
//        //查找所有父级菜单
//        List<TmResource> resources =tmResourceService.findAllParent();
//        String parentdiv = "";
//
//        List<LeftMenuVo> leftMenuVos = new ArrayList<>();
//        //得到相应子级菜单
//        for(TmResource resource:resources){
//            LeftMenuVo leftMenuVo = new LeftMenuVo();
//            List<TmResource> childrenResources = tmResourceService.findAllByParentid(resource.getId());
//            parentdiv = "<div class=\"link\">"+"<i class='"+resource.getIcon()+"'"+"></i>"+resource.getName()+"</div>";
////            <li><a href="#">班级管理</a></li>
//            String childrenli="";
//            for(TmResource childrenResource:childrenResources){
//                String link = childrenResource.getLink();
//                String linkmsg = "";
//                String limsg = "";
//                if(!StringUtils.isEmpty(link)&&link.indexOf("?")>-1){
//                    linkmsg = link.substring(link.indexOf("?"));
//                    limsg = link.substring(link.indexOf("?")+1);
//                }
//                childrenli += "<li "+limsg+">"+" <a href="+childrenResource.getLink()+">"+childrenResource.getName()+"</a></li>";
//            }
//            if(childrenResources.size()>0){
//                childrenli = "<ul class=\"submenu\">"+childrenli+"</ul> ";
//            }
//
//            leftMenuVo.setParentdiv(parentdiv);
//            leftMenuVo.setChildreli(childrenli);
//            leftMenuVos.add(leftMenuVo);
//
//        }
//        request.setAttribute("leftmenus",leftMenuVos);
//    }
    /**
     * 分配角色
     */
    @RequestMapping("fpRole")
    private String fpRole(HttpServletRequest request,Integer userid){
        List<TmRole> roles =  tmRoleRepository.findAll();
        request.setAttribute("roles",roles);
        request.setAttribute("userid",userid);
        List<TmUserRole> tmUserRoles =  tmUserRoleRepository.findAllByuserid(userid);
        request.setAttribute("selectrole",tmUserRoles);
        return "user/fpRole";
    }
    /**
     * 分配班级
     */
    @RequestMapping("fpbanji")
    private String fpbanji(HttpServletRequest request,Integer userid){

        List<TmBanJi> tmBanJis = tmBanjiRepository.findAll();
       List<TmBanJi> selectbanji = tmUserClassKemuService.findAllByUserId(userid);
        request.setAttribute("tmBanJis",tmBanJis);
        request.setAttribute("selectbanji",selectbanji);
        request.setAttribute("userid",userid);
        return "user/fpbanji";
    }
    /**
     * 分配科目
     */
    @RequestMapping("fpkemu")
    private String fpkemu(HttpServletRequest request,Integer userid){
        List<TmUserClassKemu> tmUserClassKemus = tmUserClassKemuRepository.findAllByUserId(userid);
        if(tmUserClassKemus.size()==0){
            request.setAttribute("noclass",true);
            return "user/fpkemu";
        }
        //所有的科目
        List<TmKemu> tmKemus = tmKemuRepository.findAll();
        request.setAttribute("tmKemus",tmKemus);
        request.setAttribute("userid",userid);

        //分配的班级
//        List<TmBanJi> tmBanJis =  tmUserClassKemuService.findAllByUserId(userid);
        List<TmBanJi> tmBanJis =  tmBanjiRepository.findAll();
        request.setAttribute("tmBanJis",tmBanJis);

        StringBuffer bindKemu = new StringBuffer();
        List<UserKemuVo> userKemuVos = tmUserClassKemuService.findAllVoByUserId(userid,null);
        for(UserKemuVo userKemuVo:userKemuVos){
            bindKemu.append("班级:"+userKemuVo.getClassName()+", 科目:"+userKemuVo.getKemuName()+"\n");
        }
        request.setAttribute("bindKemu",bindKemu);

//        //选中的科目
//        List<TmUserClassKemu> selectTmkemus = new ArrayList<>();
//        for(TmUserClassKemu tmUserClassKemu:tmUserClassKemus){
//            if(tmUserClassKemu.getKemuId()>0){
//                selectTmkemus.add(tmUserClassKemu);
//            }
//        }
//        request.setAttribute("selectTmkemus",selectTmkemus);


        return "user/fpKemu";
    }

    @RequestMapping("userToRole")
    private void userToRole(HttpServletResponse response,Integer userid,@RequestParam(value = "roleids[]")String[] roleids){

        if(roleids==null||roleids.length==0){
            JsonUtilTemp.returnFailJson(response,"至少需要选择一个角色");
        }
        //根据roleid查找数据，删除在添加
        List<TmUserRole> existUserRoles = tmUserRoleRepository.findAllByuserid(userid);
        for(TmUserRole tmUserRole:existUserRoles){
            tmUserRoleRepository.delete(tmUserRole);
        }
        try{
            if(roleids!=null&&roleids.length>0){
                for(String roleid:roleids){
                    TmUserRole tmUserRolesingle = new TmUserRole();
                    tmUserRolesingle.setRoleid(Integer.valueOf(roleid));
                    tmUserRolesingle.setUserid(userid);
                    tmUserRoleRepository.save(tmUserRolesingle);
                }
                JsonUtilTemp.returnSucessJson(response,"分配角色成功");
            }

        }catch (Exception e){
            JsonUtilTemp.returnFailJson(response,e.getMessage());
        }


    }


    @RequestMapping("userToKemu")
    private void userToKemu(HttpServletResponse response,Integer userid,Integer kemuid,Integer banjiid){

        if(StringUtils.isEmpty(kemuid)){
            JsonUtilTemp.returnFailJson(response,"至少需要选择一个科目");
        }
        //根据userid,kemuid查找数据，删除在添加
        List<Integer> banjiIds = new ArrayList<>();
        List<TmUserClassKemu> existsKemu = tmUserClassKemuService.findAllByUserIdAndKemuId(userid,kemuid,banjiid);
        for(TmUserClassKemu tmUserClassKemu:existsKemu){
            tmUserClassKemuRepository.delete(tmUserClassKemu);

        }
        try{
            if(StringUtils.isEmpty(banjiid)){
                JsonUtilTemp.returnFailJson(response,"请选择一个班级");
            }
            if(StringUtils.isEmpty(kemuid)){
                JsonUtilTemp.returnFailJson(response,"请选择一个科目");
            }
            TmUserClassKemu tmUserClassKemu = new TmUserClassKemu();
            tmUserClassKemu.setClassId(banjiid);
            tmUserClassKemu.setCreatdate(new Date());
            tmUserClassKemu.setKemuId(kemuid);
            tmUserClassKemu.setUserId(userid);
            tmUserClassKemuRepository.save(tmUserClassKemu);
            JsonUtilTemp.returnSucessJson(response,"分配科目成功");

        }catch (Exception e){
            JsonUtilTemp.returnFailJson(response,"分配科目失败:"+e.getMessage());
        }


    }



    @RequestMapping("userToBanji")
    private void userToBanji(HttpServletResponse response,Integer userid,@RequestParam(value = "banjiids[]")String[] banjiids){

        if(banjiids==null||banjiids.length==0){
            JsonUtilTemp.returnFailJson(response,"至少需要选择一个班级");
        }
        //根据roleid查找数据，删除在添加
        List<TmUserClassKemu> exists = tmUserClassKemuRepository.findAllByUserId(userid);
        for(TmUserClassKemu tmUserClassKemu:exists){
            tmUserClassKemuRepository.delete(tmUserClassKemu);
        }
        try{
            if(banjiids!=null&&banjiids.length>0){
                for(String banjiid:banjiids){
                   TmUserClassKemu tmUserClassKemu = new TmUserClassKemu();
                   tmUserClassKemu.setClassId(Integer.valueOf(banjiid));
                    tmUserClassKemu.setCreatdate(new Date());
                    tmUserClassKemu.setUserId(userid);
                    tmUserClassKemuRepository.save(tmUserClassKemu);
                }
                JsonUtilTemp.returnSucessJson(response,"分配班级成功");
            }

        }catch (Exception e){
            JsonUtilTemp.returnFailJson(response,e.getMessage());
        }


    }


}
