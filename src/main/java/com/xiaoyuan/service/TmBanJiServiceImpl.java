package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmBanJi;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by dnys on 2018/1/2.
 */
@Service
public class TmBanJiServiceImpl implements TmBanJiService {
    @PersistenceContext
    protected EntityManager em;
    @Override
    public List<TmBanJi> findAllBanjiByUserId(Integer userid) {
        StringBuffer hql = new StringBuffer("select a.* from TM_BANJI a,TM_USER_CLASS_KEMU b where a.id=b.class_Id and b.user_Id=?1 and b.Kemu_id=0");
        Query query = em.createNativeQuery(hql.toString(),TmBanJi.class);
        query.setParameter(1,userid);
        return query.getResultList();
    }
}
