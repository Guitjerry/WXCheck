package com.xiaoyuan.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by dnys on 2017/10/24.
 */
@Service(value = "tmUserScoreService")
public class TmUserScoreServiceImpl implements TmUserScoreService {
    @PersistenceContext
    protected EntityManager em;
    @Override
    public Integer findAllCountByNameAndBanji(String name, String banji, String testname) {
       StringBuffer hql = new StringBuffer(" from TmUserScore where 1=1 ");
        if(!StringUtils.isEmpty(name)){
            hql.append(" and name=?1");
        }
        if(!StringUtils.isEmpty(banji)){
            hql.append(" and schoolclass=?2");
        }
        if(!StringUtils.isEmpty(testname)){
            hql.append(" and schooltest=?3");
        }
        Query query = em.createQuery(hql.toString());

        if(!StringUtils.isEmpty(name)){
            query.setParameter(1,name);
        }
        if(!StringUtils.isEmpty(banji)){
            query.setParameter(2,banji);
        }
        if(!StringUtils.isEmpty(testname)){
            query.setParameter(3,testname);
        }
        return query.getResultList().size();
    }
}
