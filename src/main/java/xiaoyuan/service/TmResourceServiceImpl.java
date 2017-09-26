package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmResource;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by dnys on 2017/9/13.
 */
@Service(value = "tmResourceService")
public class TmResourceServiceImpl implements TmResourceService {
    @PersistenceContext
    protected EntityManager em;
    @Override
    public List<TmResource> findAllParent() {
        String sql = "select * from TM_RESOURCE where PARENT_ID is null";
        Query query =  em.createNativeQuery(sql,TmResource.class);
        return query.getResultList();
    }

    @Override
    public List<TmResource> findAllByParentid(Integer parentid) {
        String sql = "select * from TM_RESOURCE where PARENT_ID=?1";
        Query query =  em.createNativeQuery(sql,TmResource.class);
        query.setParameter(1,parentid);
        return query.getResultList();
    }

    @Override
    public List<TmResource> findAll() {
        String sql = "select new com.xiaoyuan.entity.TmResourceVo(b.id as resourceid,a.id as parentid,b.name ,a.name as parentname) from TmResource a,TmResource b where a.id=b.parentid";
        Query query =  em.createQuery(sql);
        return query.getResultList();
    }

    @Override
    public List<TmResource> findResourceByUserid() {
//        select DISTINCT d.* from tm_user a,tm_role_resource b,tm_user_role c,tm_resource d
//        where a.id=c.USER_ID and b.ROLE_ID=c.ROLE_ID and b.RESOURCE_ID = d.id
//        and a.ACCOUNT='check' and a.status=0
                String sql = "select DISTINCT d.* from tm_user a,tm_role_resource b,tm_user_role c,tm_resource d"+
                        " where a.id=c.USER_ID and b.ROLE_ID=c.ROLE_ID and b.RESOURCE_ID = d.id"+
                        " and a.ACCOUNT='check' and a.status=0";
        Query query = em.createNativeQuery(sql,TmResource.class);
        return  query.getResultList();
    }

    @Override
    public List<TmResource> findAllParentByUserId(Integer userid) {
        String sql ="select * from tm_resource where id in(select DISTINCT  c.parent_id from tm_role a,tm_role_resource b,tm_resource c,tm_user d,tm_user_role f "+
                "where a.id=b.ROLE_ID and c.id=b.RESOURCE_ID and d.id=f.USER_ID and a.id=f.ROLE_ID and b.ROLE_ID = f.ROLE_ID "+
                " and d.ID=?1)";
        Query query = em.createNativeQuery(sql,TmResource.class);
        query.setParameter(1,userid);
        List<TmResource> objects =  query.getResultList();
        return objects;
    }

    @Override
    public List<TmResource> findAllByUserId(Integer userid) {
        String sql ="select DISTINCT  c.* from tm_role a,tm_role_resource b,tm_resource c,tm_user d,tm_user_role f "+
                "where a.id=b.ROLE_ID and c.id=b.RESOURCE_ID and d.id=f.USER_ID and a.id=f.ROLE_ID and b.ROLE_ID = f.ROLE_ID "+
                " and d.ID=?1";
        Query query = em.createNativeQuery(sql,TmResource.class);
        query.setParameter(1,userid);
        List<TmResource> objects =  query.getResultList();
        return objects;
    }
}
