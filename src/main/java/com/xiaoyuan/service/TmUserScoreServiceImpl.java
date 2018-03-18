package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmRole;
import com.xiaoyuan.entity.TmUserScore;
import com.xiaoyuan.util.Const;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dnys on 2017/10/24.
 */
@Service(value = "tmUserScoreService")
public class TmUserScoreServiceImpl implements TmUserScoreService {
    @PersistenceContext
    protected EntityManager em;
    @Override
    public Integer findAllCountByNameAndBanji(String name, String banji, String testname,String kemu) {
       StringBuffer hql = new StringBuffer(" from TmUserScore where 1=1 ");
        if(!StringUtils.isEmpty(name)){
            hql.append(" and name=?1");
        }
        if(!StringUtils.isEmpty(banji)){
            hql.append(" and schoolClass=?2");
        }
        if(!StringUtils.isEmpty(testname)){
            hql.append(" and schoolTest=?3");
        }
        if(!StringUtils.isEmpty(kemu)){
            hql.append(" and kemu=?4");
        }
        Query query = em.createQuery(hql.toString());

        if(!StringUtils.isEmpty(name)){
            query.setParameter(1,name);
        }
        if(!StringUtils.isEmpty(banji)){
            query.setParameter(2,banji);
        }
        if(!StringUtils.isEmpty(testname)){
            query.setParameter(3,testname);
        }
        if(!StringUtils.isEmpty(kemu)){
            query.setParameter(4,kemu);
        }
        return query.getResultList().size();
    }

    /**
     * 查询班级所有成绩
     * @param studentcode
     * @return
     */
    public List<TmUserScore> findBanjiScorce(String studentcode){
        StringBuffer hql = new StringBuffer("select * from  tm_user_score a,tm_user_score b where a.school_class=b.school_class and a.studentcode=?1");
        Query query = em.createNativeQuery(hql.toString(),TmUserScore.class);
        query.setParameter(1,studentcode);
        return  query.getResultList();
    }

    /**
     * 查询年级所有成绩
     * @param studentcode
     * @return
     */
    public List<TmUserScore> findNianjiScorce(String studentcode){
        StringBuffer hql = new StringBuffer("select * from  tm_user_score a,tm_user_score b where a.school_grade=b.school_grade and a.studentcode=?1");
        Query query = em.createNativeQuery(hql.toString(),TmUserScore.class);
        query.setParameter(1,studentcode);
        return  query.getResultList();
    }
    /**
     * 获取班级排名
     * @param studentcode
     * @return
     */
    public List<String> findBanjiIndex(String studentcode){
        Query query = em.createNativeQuery("{call banjiindex(?1,@a)}");
        query.setParameter(1, studentcode);
        List<String> results = query.getResultList();
        return results;

    }
    /**
     * 获取年级排名
     * @param studentcode
     * @return
     */
    public List<String> findNianjiIndex(String studentcode){
        Query query = em.createNativeQuery("{call nianjiindex(?1,@a)}");
        query.setParameter(1, studentcode);
        List<String> results = query.getResultList();
        return results;

    }
    @Override
    public List<TmUserScore> findAllByNameOrStudentCode(String param) {
        StringBuffer hql = new StringBuffer(" from TmUserScore where 1=1 ");
        if(!StringUtils.isEmpty(param)){
            hql.append(" and (name=?1 or studentcode=?1)");
        }


        Query query = em.createQuery(hql.toString());


        if(!StringUtils.isEmpty(param)){
            query.setParameter(1,param);
        }

        return query.getResultList();
    }

    @Override
    public List<TmUserScore> findAllByNameAndStudentcodeAndSchoolClass(String name, String studentcode, String schoolclass,Integer userId) {
        StringBuffer hql = new StringBuffer(" select a.id,a.name,a.school_class,a.school_test,a.studentcode,a.dili,a.huaxue,a.lishi,a.shengwu,a.shixiang,a.shuxue,a.waiyu,a.wuli,a.yuwen,a.sum_count,school_grade  from tm_user_score a where 1=1 ");
        if(!StringUtils.isEmpty(name)){
            hql.append(" and name=?1");
        }
        if(!StringUtils.isEmpty(studentcode)){
            hql.append(" and studentcode=?2");
        }
        if(!StringUtils.isEmpty(schoolclass)){
            hql.append(" and school_class=?3");
        }
        hql.append("  order by sum_count desc");
        Query query = em.createNativeQuery(hql.toString(),TmUserScore.class);


        if(!StringUtils.isEmpty(name)){
            query.setParameter(1,name);
        }
        if(!StringUtils.isEmpty(studentcode)){
            query.setParameter(2,studentcode);
        }
        if(!StringUtils.isEmpty(schoolclass)){
            query.setParameter(3,schoolclass);
        }
        return query.getResultList();
    }

    @Override
    public List<TmUserScore> findAllByNameAndStudentcodeAndSchoolClassByRole(String name, String studentcode, String schoolclass, Integer userid) {
       StringBuffer hql = new StringBuffer("select distinct a.id,a.name,a.school_class,a.school_test,a.studentcode,a.dili,a.huaxue,a.lishi,a.shengwu,a.shixiang,a.shuxue,a.waiyu,a.wuli,a.yuwen,a.sum_count,a.school_grade  from  tm_user_score a  ");
        hql.append("INNER JOIN tm_banji e on a.school_class = e.name ");
        hql.append("INNER JOIN TM_STUDENT s on s.BANJIID = e.ID ");
        if(!StringUtils.isEmpty(name)){
            hql.append(" and s.NAME=?1 ");
        }
        if(!StringUtils.isEmpty(studentcode)){
            hql.append(" and s.USERCODE=?2 ");
        }
        if(!StringUtils.isEmpty(schoolclass)){
            hql.append(" and s.banjiname=?3 ");
        }
        hql.append("INNER JOIN tm_user_class_kemu f on e.id=f.class_id and f.kemu_id=0 ");
        hql.append("INNER JOIN tm_user u on u.id=f.user_id and u.id=?4 ");
        hql.append("INNER JOIN tm_user_role c on f.user_id=c.user_id ");
        hql.append("INNER JOIN tm_role d on c.role_id =d.id order by a.sum_count desc");

        Query query = em.createNativeQuery(hql.toString(),TmUserScore.class);
        if(!StringUtils.isEmpty(name)){
           query.setParameter(1,name);
        }
        if(!StringUtils.isEmpty(studentcode)){
            query.setParameter(2,studentcode);
        }
        if(!StringUtils.isEmpty(schoolclass)){
            query.setParameter(3,schoolclass);
        }

        if(userid!=null){
           query.setParameter(4,userid);
        }
        return query.getResultList();
    }
}
