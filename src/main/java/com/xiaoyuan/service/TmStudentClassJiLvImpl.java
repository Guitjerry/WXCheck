package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmStudentClassJiLv;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by dnys on 2018/1/8.
 */
@Service
public class TmStudentClassJiLvImpl implements TmStudentClassJiLvService {
    @PersistenceContext
    protected EntityManager em;
    @Override
    public List<TmStudentClassJiLv> findAll() {
        String hql = " select new com.xiaoyuan.entity.TmStudentClassJiLv(a.id,a.content,a.keCheng,a.createDate,a.userId,a.studentId,b.name as studentName,c.name as className) from TmStudentClassJiLv a,TmStudent b,TmBanJi c where a.studentId = b.id and b.banjiid = c.ID";
        Query query = em.createQuery(hql);
        return query.getResultList();
    }
    @Override
    public List<TmStudentClassJiLv> findAllByRole(Integer userId) {
        String hql = " select new com.xiaoyuan.entity.TmStudentClassJiLv(a.id,a.content,a.keCheng,a.createDate,a.userId,a.studentId,b.name as studentName,c.name as className) from TmStudentClassJiLv a,TmStudent b,TmBanJi c,TmUserClassKemu u where a.studentId = b.id and b.banjiid = c.ID and b.banjiid = u.classId and u.kemuId=0 and u.userId=?1 ";
        Query query = em.createQuery(hql);
        query.setParameter(1,userId);
        return query.getResultList();
    }
}
