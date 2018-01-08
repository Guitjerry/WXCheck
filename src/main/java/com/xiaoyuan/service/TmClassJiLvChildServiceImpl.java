package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmClassJiLvChild;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by dnys on 2018/1/8.
 */
@Service(value = "tmClassJiLvChildService")
public class TmClassJiLvChildServiceImpl implements TmClassJiLvChildService {
    @PersistenceContext
    protected EntityManager em;
    @Override
    public List<TmClassJiLvChild> findAll() {
        String hql = " select new com.xiaoyuan.entity.TmClassJiLvChild(b.id,b.name,b.JLId,a.type,a.name as parentname) from TmClassJiLv a,TmClassJiLvChild b where a.id=b.JLId ";
        Query query = em.createQuery(hql,TmClassJiLvChild.class);
        return query.getResultList();
    }
    public List<TmClassJiLvChild> findAllByType() {
        String hql = " select new com.xiaoyuan.entity.TmClassJiLvChild(b.id,b.name,b.JLId,a.type,a.name as parentname) from TmClassJiLv a,TmClassJiLvChild b where a.id=b.JLId and a.type=1 ";
        Query query = em.createQuery(hql,TmClassJiLvChild.class);
        return query.getResultList();
    }
}
