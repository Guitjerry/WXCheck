package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmBanJi;
import com.xiaoyuan.entity.TmUserClassKemu;
import com.xiaoyuan.entity.UserKemuVo;
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

        String hql = " select DISTINCT  a.* from TM_BANJI a,TM_USER_CLASS_KEMU b where a.id = b.class_id and b.USER_ID=?1 and b.KEMU_ID=0";
        Query query = em.createNativeQuery(hql,TmBanJi.class);
        query.setParameter(1,userId);
        return  query.getResultList();

    }
    public List<TmUserClassKemu> findAllByUserIdAndKemuId(Integer userId,Integer kemuId,Integer banjiid) {

        String hql = " select * from TM_USER_CLASS_KEMU b where b.USER_ID=?1 and b.KEMU_ID=?2 and b.CLASS_ID=?3";
        Query query = em.createNativeQuery(hql,TmUserClassKemu.class);
        query.setParameter(1,userId);
        query.setParameter(2,kemuId);
        query.setParameter(3,banjiid);
        return  query.getResultList();

    }

    public List<UserKemuVo> findAllVoByUserId(Integer userId,Integer banjiid){
        String hql = " select new com.xiaoyuan.entity.UserKemuVo(a.id,c.id,a.name,c.name) from TmUserClassKemu b,TmKemu a,TmBanJi c where b.userId=?1 and a.id=b.kemuId and c.ID=b.classId and c.id=?2";
        Query query = em.createQuery(hql);
        query.setParameter(1,userId);
        query.setParameter(2,banjiid);
        return  query.getResultList();
    }
    public List<TmBanJi> findAllBanjiByUserId(Integer userId){
        String hql = " select DISTINCT  a.* from TM_BANJI a,TM_USER_CLASS_KEMU b where a.id = b.class_id and b.USER_ID=?1";
        Query query = em.createNativeQuery(hql,TmBanJi.class);
        query.setParameter(1,userId);
        return  query.getResultList();
    }

}
