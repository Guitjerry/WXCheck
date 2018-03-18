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

    public List<ZuoyeVo> listAllZuoyeByAdmin(String kemuname,String banjiname,Integer userid){
        List<ZuoyeVo> zuoyeVos = null;
        StringBuffer hql = new StringBuffer(" select new com.xiaoyuan.entity.ZuoyeVo(d.kemuid,d.id as zuoyeid,a.ID as banjiid, d.task,b.name as kemuname,a.name as banjiname) from  TmBanJi a, TmKemu b,TmZuoYe d where  a.id=d.banjiid and b.id=d.kemuid ");
        if(userid!=null&&userid>0){
            hql.append(" and c.userId=?1");
        }
        if(!StringUtils.isEmpty(kemuname)){
            hql.append(" and b.name=?2");
        }
        if(!StringUtils.isEmpty(banjiname)){
            hql.append(" and a.name=?3");
        }
        Query query = em.createQuery(hql.toString());
        if(userid!=null&&userid>0){
            query.setParameter(1,userid);
        }
        if(!StringUtils.isEmpty(kemuname)){
            query.setParameter(2,kemuname);
        }
        if(!StringUtils.isEmpty(banjiname)){
            query.setParameter(3,banjiname);
        }
        zuoyeVos = query.getResultList();
        return zuoyeVos;
    }
    @Override
    public List<ZuoyeVo> listAllZuoye(String kemuname,String banjiname,Integer userid) {
        List<ZuoyeVo> zuoyeVos = null;
        StringBuffer hql = new StringBuffer(" select new com.xiaoyuan.entity.ZuoyeVo(d.kemuid,d.id as zuoyeid,a.ID as banjiid, d.task,b.name as kemuname,a.name as banjiname) from  TmBanJi a, TmKemu b,TmUserClassKemu c,TmZuoYe d where a.id=c.classId and b.id=c.kemuId and a.id=d.banjiid  and c.kemuId>0 ");
        if(userid!=null&&userid>0){
            hql.append(" and c.userId=?1");
        }
        if(!StringUtils.isEmpty(kemuname)){
            hql.append(" and b.name=?2");
        }
        if(!StringUtils.isEmpty(banjiname)){
            hql.append(" and a.name=?3");
        }
        Query query = em.createQuery(hql.toString());
        if(userid!=null&&userid>0){
            query.setParameter(1,userid);
        }
        if(!StringUtils.isEmpty(kemuname)){
            query.setParameter(2,kemuname);
        }
        if(!StringUtils.isEmpty(banjiname)){
            query.setParameter(3,banjiname);
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

    public  List<ZuoyeVo> listAllZuoyeById(String usercode){
        List<ZuoyeVo> zuoyeVos = null;
        StringBuffer hql = new StringBuffer(" select new com.xiaoyuan.entity.ZuoyeVo(d.kemuid,d.id as zuoyeid,a.ID as banjiid, d.task,b.name as kemuname,a.name as banjiname) from  TmBanJi a, TmKemu b,TmBanjiKemu c,TmZuoYe d,TmStudent student where student.banjiid=a.id  and a.id=c.banjiid and b.id=c.kemuid and a.id=d.banjiid and b.id=d.kemuid");

        if(!StringUtils.isEmpty(usercode)){
            hql.append(" and student.usercode=?1");
        }else{
            return null;
        }

        Query query =em.createQuery(hql.toString());
        if(!StringUtils.isEmpty(usercode)){
            query.setParameter(1,usercode);
        }
        List<ZuoyeVo> zuoyeVoList = query.getResultList();
       return zuoyeVoList;

    }
}
