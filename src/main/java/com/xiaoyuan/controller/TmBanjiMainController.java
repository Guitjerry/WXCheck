package com.xiaoyuan.controller;

import com.xiaoyuan.entity.*;
import com.xiaoyuan.pager.PageBean;
import com.xiaoyuan.respository.*;
import com.xiaoyuan.service.TmBanJiService;
import com.xiaoyuan.service.TmStudentService;
import com.xiaoyuan.service.TmUserRoleService;
import com.xiaoyuan.service.TmUserScoreService;
import com.xiaoyuan.util.Const;
import com.xiaoyuan.util.ExcelConfig;
import com.xiaoyuan.util.JsonUtilTemp;
import com.xiaoyuan.util.JxlExcelUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dnys on 2017/9/20.
 */
@Controller
@RequestMapping("/banji")
public class TmBanjiMainController {
    private Logger logger = Logger.getLogger(TmBanjiMainController.class);
    @Autowired
    private TmBanjiRepository tmBanjiRepository;
    @Autowired
    private TmKemuRepository tmKemuRepository;
    @Autowired
    private TmBanjiKemuRepository tmBanjiKemuRepository;
    @Autowired
    private TmStudentRepository tmStudentRepository;
    @Autowired
    private TmStudentService tmStudentService;
    @Autowired
    private TmUserScoreService tmUserScoreService;
    @Autowired
    private TmUserScoreRepository tmUserScoreRepository;
    @Autowired
    private TmUserRoleService tmUserRoleService;
    @Autowired
    private TmBanJiService tmBanJiService;

    /**
     * 班级分配学生
     * @param request
     * @param msg
     */
    @RequestMapping("/banjiFp")
    private void banjiFp(HttpServletRequest request, String msg,String[] studentids,Integer banjiid,HttpServletResponse response){
        try{
            if(studentids!=null&&studentids.length>0){
                for(int i=0;i<studentids.length;i++){
                    String studentid = studentids[i];
                    //分配班级
                    TmStudent tmStudent = tmStudentRepository.findOne(Integer.valueOf(studentid));
                    tmStudent.setBanjiid(banjiid);
                    tmStudentRepository.saveAndFlush(tmStudent);
                }
                JsonUtilTemp.returnSucessJson(response,"分配学生成功");
            }else{
                JsonUtilTemp.returnFailJson(response,"请至少选择一个学生");
            }

        }catch (Exception e){
            e.printStackTrace();
            logger.error("分配学生失败"+e.getMessage());
            JsonUtilTemp.returnExceptionJson(response,"分配学生异常"+e.getMessage());
        }

    }

    /**
     * 班级列表
     */
    @RequestMapping("/banjiList")
    private String userList(HttpServletRequest request, String msg,String txt_search_name,Integer pageNo){
        request.setAttribute("msg",msg);
        pageNo = pageNo==null?1:pageNo;
        int userid = Integer.valueOf(request.getSession().getAttribute("userid").toString());
        //获取当前用户权限
        Boolean role = (Boolean) request.getSession().getAttribute("adminRole");
        long counts =  tmBanjiRepository.count();
        if(role){
            Pageable pageable = new PageRequest(pageNo-1,Const.PAGE_SIZE);
            Page<TmBanJi> pageBean = tmBanjiRepository.findAll(pageable);
            request.setAttribute("pageNo",pageNo);
            request.setAttribute("counts",counts);
            request.setAttribute("tmBanJis",pageBean.getContent());
            request.setAttribute("txt_search_name",txt_search_name);
            return "banji/list";
        }
        List<TmBanJi> tmBanJis = tmBanJiService.findAllBanjiByUserId(userid);
        request.setAttribute("tmBanJis",tmBanJis);
        request.setAttribute("nopage",true);
        return "banji/list";
    }
    @RequestMapping("addBanji")
    private String addBanji(HttpServletResponse response){

        return "banji/addBanji";
    }
    @RequestMapping("fpStudentdiv")
    private String fpStudentdiv(HttpServletResponse response,HttpServletRequest request,Integer banjiid){
        List<TmStudent> tmStudents = tmStudentService.findAllStudent(null,null);
        request.setAttribute("tmStudents",tmStudents);
        request.setAttribute("banjiid",banjiid);
        //查询班级信息
        return "banji/fpStudentdiv";
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
          tmBanJi.setName(tmBanJi.getName().trim());
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
     * 成绩导入
     * @param request
     * @param response
     * @param banjiid
     * @return
     */
    @RequestMapping(value = "fpStudentScoreSure")
    private String fpStudentScoreSure(MultipartHttpServletRequest request, HttpServletResponse response,Integer banjiid){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        MultipartFile file = request.getFile("filename");
        List<TtScorceImportVo> ttScorceImportVos = new ArrayList<>();//相同的学生数据
//        List<TmUserScore> tmUserScores = new ArrayList<>();
        try{
            InputStream in = file.getInputStream();
            List<Object> objects = commonImportBack(in,"excelConfig.xml","TM_USER_SCORE",new TmUserScore());
            //根据姓名与班级查询重复记录
            for(Object obj:objects){
                TmUserScore tmUserScore = (TmUserScore) obj;
                TmUserScore resultScore = new TmUserScore();
                TtScorceImportVo ttScorceImportVo = new TtScorceImportVo();//记录导入信息
                String errornote = null;
                if(StringUtils.isEmpty(tmUserScore.getName())){
                    errornote = "学生姓名不能为空";
                }
                if(StringUtils.isEmpty(tmUserScore.getSchoolClass())){
                    errornote = "班级不能为空";
                }

                if(StringUtils.isEmpty(tmUserScore.getSchoolTest())){
                    errornote = "考试名称不能为空";
                }


                ttScorceImportVo.setName(tmUserScore.getName());
                ttScorceImportVo.setSchoolclass(tmUserScore.getSchoolClass());

                if(!StringUtils.isEmpty(errornote)){
                    ttScorceImportVo.setNote(errornote);
                    ttScorceImportVos.add(ttScorceImportVo);
                }else{
                    Integer counts =  tmUserScoreService.findAllCountByNameAndBanji(tmUserScore.getName(),tmUserScore.getSchoolClass(),tmUserScore.getSchoolTest(),null);
                    //大于0则已经导入过
                    if(counts>0){
                        errornote = "该学生成绩已经导入";
                        ttScorceImportVo.setNote(errornote);

                    }else{
                        errornote = "导入成绩成功";
                        ttScorceImportVo.setNote(errornote);
                            Double sumcount = StringUtils.isEmpty(tmUserScore.getYuwen())?0.0:Integer.valueOf(tmUserScore.getYuwen());
                            sumcount = StringUtils.isEmpty(tmUserScore.getShuxue())?sumcount:sumcount+Integer.valueOf(tmUserScore.getShuxue());
                            sumcount = StringUtils.isEmpty(tmUserScore.getWaiyu())?sumcount:sumcount+Integer.valueOf(tmUserScore.getWaiyu());
                            sumcount = StringUtils.isEmpty(tmUserScore.getWuli())?sumcount:sumcount+Integer.valueOf(tmUserScore.getWuli());
                            sumcount = StringUtils.isEmpty(tmUserScore.getHuaxue())?sumcount:sumcount+Integer.valueOf(tmUserScore.getHuaxue());
                            sumcount = StringUtils.isEmpty(tmUserScore.getShengwu())?sumcount:sumcount+Integer.valueOf(tmUserScore.getShengwu());
                            sumcount = StringUtils.isEmpty(tmUserScore.getDili())?sumcount:sumcount+Integer.valueOf(tmUserScore.getDili());
                            sumcount = StringUtils.isEmpty(tmUserScore.getLishi())?sumcount:sumcount+Integer.valueOf(tmUserScore.getLishi());
                            sumcount = StringUtils.isEmpty(tmUserScore.getShixiang())?sumcount:sumcount+Integer.valueOf(tmUserScore.getShixiang());

                        tmUserScore.setSumCount(sumcount);
                        tmUserScoreRepository.save(tmUserScore);
                    }
                }


                ttScorceImportVos.add(ttScorceImportVo);

            }

        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        request.setAttribute("ttScorceImportVos",ttScorceImportVos);
//        request.setAttribute("insertcount",insertStudents.size());
//        request.setAttribute("sameStudents",sameStudents);
//        request.setAttribute("samecount",sameStudents.size());
//        request.setAttribute("errorStudents",errorStudents);
//        request.setAttribute("errorcount",errorStudents.size());
        return "banji/importScoreList";
    }

    /**
     * 分配学生
     * @param request
     * @param response
     */
    @RequestMapping(value = "fpStudentSure")
    private String fpStudentSure(MultipartHttpServletRequest request, HttpServletResponse response,Integer banjiid){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        MultipartFile file = request.getFile("filename");
        List<TmStudent> sameStudents = new ArrayList<>();//相同的学生数据
        List<TmStudent> insertStudents = new ArrayList<>();//插入的学生数据
        List<TmStudent> errorStudents = new ArrayList<>();
        try{
            InputStream in = file.getInputStream();
            List<Object> objects = commonImportBack(in,"excelConfig.xml","TM_STUDENT",new TmStudent());
            TmBanJi tmBanJi = tmBanjiRepository.findOne(banjiid);//班级
            for(Object object:objects){
                //excel对象的对象
                TmStudent tmStudent = (TmStudent) object;
                if(StringUtils.isEmpty(tmStudent.getUsercode())){
                    errorStudents.add(tmStudent);
                }
                //不存在的插入，数据库查出
                List<TmStudent> tmStudentList = tmStudentRepository.findAllByusercode(tmStudent.getUsercode());
                if(tmStudentList!=null&&tmStudentList.size()==0) {
                    tmStudent.setBanjiid(banjiid);
                    tmStudent.setBanjiname(tmBanJi.getName());
                    tmStudentRepository.save(tmStudent);
                    if(tmStudent.getId()>0){
                        insertStudents.add(tmStudent);

                    }

                }else{
                    //数据库根据编码查出的学生数据
                    TmStudent sametmstudent = tmStudentList.get(0);
                    sametmstudent.setName(tmStudent.getName());
                    sametmstudent.setUsercode(tmStudent.getUsercode());
                    sametmstudent.setBanjiid(banjiid);
                    sametmstudent.setBanjiname(tmBanJi.getName());
                    tmStudentRepository.saveAndFlush(sametmstudent);
                    sameStudents.add(sametmstudent);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        request.setAttribute("insertStudents",insertStudents);
        request.setAttribute("insertcount",insertStudents.size());
        request.setAttribute("sameStudents",sameStudents);
        request.setAttribute("samecount",sameStudents.size());
        request.setAttribute("errorStudents",errorStudents);
        request.setAttribute("errorcount",errorStudents.size());
        return "banji/importList";
//        request.setAttribute("banjiid",banjiid);
    }

    public List<Object> commonImportBack(InputStream in,String configxml,String tablename,Object target){
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
    /**
     * 分配学生
     */
    @RequestMapping("fpStudent")
    private String fpStudent(HttpServletRequest request,Integer banjiid){
        request.setAttribute("banjiid",banjiid);
        return "banji/fpStudent";
    }
    /**
     * 成绩导入
     */
    @RequestMapping("fpStudentScore")
    private String fpStudentScore(HttpServletRequest request,Integer banjiid){
        request.setAttribute("banjiid",banjiid);
        return "banji/fpStudentScore";
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
