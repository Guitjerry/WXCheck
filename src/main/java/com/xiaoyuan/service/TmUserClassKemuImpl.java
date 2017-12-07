package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmBanJi;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Service(value = "tmUserClassKemu")
public class TmUserClassKemuImpl implements TmUserClassKemuService {
    @PersistenceContext
    protected EntityManager em;
    @Override
    public List<TmBanJi> findAllByUserId(Integer userId) {

        String hql = " select a.* from TM_BANJI a,TM_USER_CLASS_KEMU b where a.id = b.class_id and b.USER_ID=?1";
        Query query = em.createNativeQuery(hql,TmBanJi.class);
        query.setParameter(1,userId);
        return  query.getResultList();

    }
}
