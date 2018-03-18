package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmStudent;
import com.xiaoyuan.pager.PageBean;
import com.xiaoyuan.util.Const;
import com.xiaoyuan.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dnys on 2017/9/28.
 */
@Service(value = "tmStudentService")
public class TmStudentServiceImpl implements TmStudentService{
    @PersistenceContext
    protected EntityManager em;
    @Override
    public List<TmStudent> findAllStudent(String studentname,String usercode) {
        List<TmStudent> tmStudents = new ArrayList<>();
        StringBuffer hql = new StringBuffer(" select u.NAME,u.USERCODE,u.PHONE,u.AGE,u.BANJIID,b.NAME as banjiname,u.id from TM_STUDENT u left join TM_BANJI b on u.banjiid=b.ID where 1=1 ");
        if(!StringUtils.isEmpty(studentname)){
            hql.append(" and u.name =?1");
        }
        if(!StringUtils.isEmpty(usercode)){
            hql.append(" and u.usercode =?2");
        }
        Query query = em.createNativeQuery(hql.toString());
        if(!StringUtils.isEmpty(studentname)){
            query.setParameter(1,studentname);
        }
        if(!StringUtils.isEmpty(usercode)){
            query.setParameter(2,usercode);
        }
        List<Object[]> objects = query.getResultList();
        for(Object[] tmstudent:objects){
            TmStudent tmStudent = new TmStudent();

            String name = tmstudent[0]==null?"":String.valueOf(tmstudent[0]);
            String code = tmstudent[1]==null?"":String.valueOf(tmstudent[1]);
            String phone = tmstudent[2]==null?"":String.valueOf(tmstudent[2]);
            String age = tmstudent[3]==null?null:String.valueOf(tmstudent[3]);
            String banjiid = tmstudent[4]==null?null:String.valueOf(tmstudent[4]);
            String banjiname = tmstudent[5]==null?"":String.valueOf(tmstudent[5]);
            String id = tmstudent[6]==null?"":String.valueOf(tmstudent[6]);
            tmStudent.setName(name);
            tmStudent.setUsercode(code);
            tmStudent.setPhone(phone);

            if(!StringUtils.isEmpty(age)){
                tmStudent.setAge(Integer.valueOf(age));
            }
            if(!StringUtils.isEmpty(banjiid)){
                tmStudent.setBanjiid(Integer.valueOf(banjiid));
            }
            if(!StringUtils.isEmpty(id)){
                tmStudent.setId(Integer.valueOf(id));
            }
            tmStudent.setBanjiname(banjiname);
            tmStudents.add(tmStudent);
        }
        return tmStudents;
    }

    /**
     *
     * @param currentPage 当前页
     * @param pagecount 每页显示的条数
     * @return
     */
    public PageBean<TmStudent> findAllStudent(int currentPage,int pagecount,String name,String usercode){
        //总数
        List<TmStudent> allstudents = findAllStudent(name,usercode);
        List<TmStudent> tmStudents = new ArrayList<>();
        StringBuffer hql = new StringBuffer(" select u.NAME,u.USERCODE,u.PHONE,u.AGE,u.BANJIID,b.NAME as banjiname,u.id from TM_STUDENT u left join TM_BANJI b on u.banjiid=b.ID where 1=1 ");

        if(!StringUtils.isEmpty(name)){
            hql.append(" and u.name =?1");
        }
        if(!StringUtils.isEmpty(usercode)){
            hql.append(" and u.usercode = ?2");
        }
        Query query = em.createNativeQuery(hql.toString());

        if(!StringUtils.isEmpty(name)){
            query.setParameter(1,name);
        }
        if(!StringUtils.isEmpty(usercode)){
            query.setParameter(2,usercode);
        }
        //总条数要比每页页的条数多
        if(allstudents.size()>pagecount){
            query.setFirstResult((currentPage-1)*pagecount);
            query.setMaxResults(pagecount);
        }

        List<Object[]> objects = query.getResultList();
        for(Object[] tmstudent:objects){
            TmStudent tmStudent = new TmStudent();

            String studentname = tmstudent[0]==null?"":String.valueOf(tmstudent[0]);
            String code = tmstudent[1]==null?"":String.valueOf(tmstudent[1]);
            String phone = tmstudent[2]==null?"":String.valueOf(tmstudent[2]);
            String age = tmstudent[3]==null?null:String.valueOf(tmstudent[3]);
            String banjiid = tmstudent[4]==null?null:String.valueOf(tmstudent[4]);
            String banjiname = tmstudent[5]==null?"":String.valueOf(tmstudent[5]);
            String id = tmstudent[6]==null?"":String.valueOf(tmstudent[6]);
            tmStudent.setName(studentname);
            tmStudent.setUsercode(code);
            tmStudent.setPhone(phone);
            if(!StringUtils.isEmpty(age)){
                tmStudent.setAge(Integer.valueOf(age));
            }
            if(!StringUtils.isEmpty(banjiid)){
                tmStudent.setBanjiid(Integer.valueOf(banjiid));
            }
            if(!StringUtils.isEmpty(id)){
                tmStudent.setId(Integer.valueOf(id));
            }
            tmStudent.setBanjiname(banjiname);
            tmStudents.add(tmStudent);
        }


        PageBean<TmStudent> pageBean = new PageBean<>();
        pageBean.setPageIndex(currentPage);//设置当前页数
        pageBean.setPageCount(pagecount);//设置一页显示多少条
        pageBean.setCount(allstudents.size());//设置总条数
        pageBean.setList(tmStudents);
        return pageBean;
    }
    /**
     * 根据账号密码查询登录
     * @param usercode
     * @param password
     * @return
     */
    @Override
    public  List<TmStudent> findStudentByUserCodeAndPassword(String usercode, String password) {
        StringBuffer hql = new StringBuffer(" from  TmStudent where usercode=?1 and password=?2");
        Query query = em.createQuery(hql.toString());
        query.setParameter(1,usercode);
        query.setParameter(2,password);
        List<TmStudent> tmStudents =  query.getResultList();
        return tmStudents;
    }
    public Long findAllCountByUserid(String name, String usercode,Integer userid){
        StringBuffer sql = new StringBuffer("select count(*) from TM_STUDENT u,TM_USER_CLASS_KEMU c where  u.BANJIID=c.CLASS_ID and c.KEMU_ID=0");
        if(userid!=null&&userid>0){
            sql.append(" and c.USER_ID=?1");
        }
        Query query = em.createNativeQuery(sql.toString());
        if(userid!=null&&userid>0){
            query.setParameter(1,userid);
        }
        return Long.valueOf(query.getSingleResult().toString());
    }

    @Override
    public List<TmStudent> findAllStudentByName(Pageable pageable, String name, String usercode,Integer userid,Boolean flag) {
        List<TmStudent> tmStudents = new ArrayList<>();
        StringBuffer hql = new StringBuffer("select u.* from TM_STUDENT u,TM_USER_CLASS_KEMU c where  u.BANJIID=c.CLASS_ID AND C.KEMU_ID=0");
        //admin去除权限限制
        if(!flag){
            if(userid!=null&&userid>0){
                hql.append(" and c.USER_ID=?1");
            }
        }
        //admin角色
        if(flag){
            hql = new StringBuffer(" select * from TM_STUDENT u where 1=1");
        }

        if(!StringUtils.isEmpty(name)){
            hql.append(" and u.name =?2");
        }
        if(!StringUtils.isEmpty(usercode)){
            hql.append(" and u.usercode =?3");
        }
        Query query = em.createNativeQuery(hql.toString(),TmStudent.class);

        if(!StringUtils.isEmpty(name)){
            query.setParameter(2,name);
        }
        if(!StringUtils.isEmpty(usercode)){
            query.setParameter(3,usercode);
        }
        if(!flag){
            if(userid!=null&&userid>0){
                query.setParameter(1,userid);
            }
        }
        if(pageable!=null){
            query.setFirstResult((pageable.getPageNumber()-1)*(pageable.getPageSize()));
            query.setMaxResults(pageable.getPageSize());
        }

        return query.getResultList();
    }


}
