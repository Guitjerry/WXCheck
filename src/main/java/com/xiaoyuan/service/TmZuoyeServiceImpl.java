package com.xiaoyuan.service;

import com.xiaoyuan.entity.ZuoyeVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public List<ZuoyeVo> listAllZuoye(String kemuname,String banjiname) {
        List<ZuoyeVo> zuoyeVos = null;
        StringBuffer hql = new StringBuffer(" select new com.xiaoyuan.entity.ZuoyeVo(d.kemuid,d.id as zuoyeid,a.ID as banjiid, d.task,b.name as kemuname,a.name as banjiname) from  TmBanJi a, TmKemu b,TmBanjiKemu c,TmZuoYe d where a.id=c.banjiid and b.id=c.kemuid and a.id=d.banjiid and b.id=d.kemuid");
        if(!StringUtils.isEmpty(kemuname)){
            hql.append(" and b.name=?1");
        }
        if(!StringUtils.isEmpty(banjiname)){
            hql.append(" and a.name=?2");
        }
        Query query = em.createQuery(hql.toString());
        if(!StringUtils.isEmpty(kemuname)){
            query.setParameter(1,kemuname);
        }
        if(!StringUtils.isEmpty(banjiname)){
            query.setParameter(2,banjiname);
        }
        zuoyeVos = query.getResultList();
        return zuoyeVos;
    }
    public ZuoyeVo listAllZuoyeById(Integer zuoyeid){
        List<ZuoyeVo> zuoyeVos = null;
        StringBuffer hql = new StringBuffer(" select new com.xiaoyuan.entity.ZuoyeVo(d.kemuid,d.id as zuoyeid,a.ID as banjiid, d.task,b.name as kemuname,a.name as banjiname) from  TmBanJi a, TmKemu b,TmBanjiKemu c,TmZuoYe d where a.id=c.banjiid and b.id=c.kemuid and a.id=d.banjiid and b.id=d.kemuid");

        if(zuoyeid>0){
           hql.append(" and d.id=?1");
       }
        Query query =em.createQuery(hql.toString());
        if(zuoyeid>0){
            query.setParameter(1,zuoyeid);
        }
        List<ZuoyeVo> zuoyeVoList = query.getResultList();
        if(zuoyeVoList!=null&&zuoyeVoList.size()>0){
            return zuoyeVoList.get(0);
        }else {
            return null;
        }

    }
}
