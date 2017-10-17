package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmKemu;
import com.xiaoyuan.pager.PageBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by dnys on 2017/9/21.
 */
@Service(value = "tmKemuService")
public class TmKemuServiceImpl implements TmKemuService{
    @PersistenceContext
    protected EntityManager em;
    @Override
    public List<TmKemu> selectKemuByBanji(Integer banjidi) {
        String sql = "  select b from TmBanjiKemu a,TmKemu b,TmBanJi c where a.kemuid=b.id and a.banjiid=c.ID  and c.id=?1";
        Query query = em.createQuery(sql);
        query.setParameter(1,banjidi);
        return query.getResultList();
    }
    public List<TmKemu> findAllTmKemu(PageRequest pageRequest){
        StringBuffer hql = new StringBuffer(" from TmKemu");
        Query query = em.createQuery(hql.toString());
        query.setFirstResult((pageRequest.getPageNumber()-1)*pageRequest.getPageSize());
        query.setMaxResults(pageRequest.getPageSize());
        return query.getResultList();
    }
}
