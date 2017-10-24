package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmUserScore;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by dnys on 2017/10/24.
 */
@Service(value = "tmUserScoreService")
public class TmUserScoreServiceImpl implements TmUserScoreService {
    @PersistenceContext
    protected EntityManager em;
    @Override
    public Integer findAllCountByNameAndBanji(String name, String banji, String testname,String kemu) {
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
        if(!StringUtils.isEmpty(kemu)){
            hql.append(" and kemu=?4");
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
        if(!StringUtils.isEmpty(kemu)){
            query.setParameter(4,kemu);
        }
        return query.getResultList().size();
    }

    @Override
    public List<TmUserScore> findAllByNameOrStudentCode(String param) {
        StringBuffer hql = new StringBuffer(" from TmUserScore where 1=1 ");
        if(!StringUtils.isEmpty(param)){
            hql.append(" and (name=?1 or studentcode=?1)");
        }

        Query query = em.createQuery(hql.toString());


        if(!StringUtils.isEmpty(param)){
            query.setParameter(1,param);
        }

        return query.getResultList();
    }
}
