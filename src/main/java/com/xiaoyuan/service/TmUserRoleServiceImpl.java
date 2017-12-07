package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmRole;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Service(value = "tmUserRoleService")
public class TmUserRoleServiceImpl implements TmUserRoleService {
    @PersistenceContext
    protected EntityManager em;
    @Override
    public List<TmRole> findAllRoleByUserId(Integer userId) {
        StringBuffer hql = new StringBuffer(" select a.* from TM_ROLE a,TM_USER_ROLE b where b.ROLE_ID=a.id and b.USER_ID=?1 ");
        Query query = em.createNativeQuery(hql.toString(),TmRole.class);
        query.setParameter(1,userId);
        return  query.getResultList();
    }
}
