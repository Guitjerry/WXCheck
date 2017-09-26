package com.xiaoyuan.service;

import com.xiaoyuan.entity.ZuoyeVo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by dnys on 2017/9/21.
 */
@Service(value = "tmZuoyeService")
public class TmZuoyeServiceImpl implements TmZuoyeService {
    @PersistenceContext
    protected EntityManager em;
    @Override
    public List<ZuoyeVo> listAllZuoye() {
        List<ZuoyeVo> zuoyeVos = null;
        String hql = " select new com.xiaoyuan.entity.ZuoyeVo(d.kemuid,d.id as zuoyeid,a.ID as banjiid, d.task,b.name as kemuname,a.name as banjiname) from  TmBanJi a, TmKemu b,TmBanjiKemu c,TmZuoYe d where a.id=c.banjiid and b.id=c.kemuid and a.id=d.banjiid and b.id=d.kemuid";
        Query query = em.createQuery(hql);
        zuoyeVos = query.getResultList();

        return zuoyeVos;
    }
}
