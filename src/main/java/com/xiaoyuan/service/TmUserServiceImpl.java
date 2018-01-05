package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmUser;
import com.xiaoyuan.util.MD5Util;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dnys on 2017/9/22.
 */
@Service(value = "tmUserService")
public class TmUserServiceImpl implements TmUserService {
    @PersistenceContext
    protected EntityManager em;
    @Override
    public List<TmUser> findAllByaccountAndpassword(String account, String password) {
        StringBuffer hql = new StringBuffer(" from TmUser where 1=1");
        if(StringUtils.isEmpty(account)||StringUtils.isEmpty(password)){
            return null;
        }
        if(!StringUtils.isEmpty(account)){
            hql.append(" and account=?1");
        }
        if(!StringUtils.isEmpty(password)){
            hql.append(" and password=?2");
        }
        Query query = em.createQuery(hql.toString());

        if(!StringUtils.isEmpty(account)){
            query.setParameter(1,account);
        }
        if(!StringUtils.isEmpty(password)){
            query.setParameter(2, MD5Util.string2MD5(password));
        }
        return query.getResultList();

    }
    public List<TmUser> findAllByaccountAndNameAndPhone(String account, String name, String phone, Pageable pageable,Integer pageNo) {
        StringBuffer hql = new StringBuffer(" select distinct a.account,a.name,a.email,a.phone,c.code,a.id from TM_USER a left join TM_USER_ROLE b on a.id=b.user_id left join TM_ROLE c  on b.role_id = c.id where 1=1 ");
        if (!StringUtils.isEmpty(account)) {
            hql.append(" and a.account=?1");
        }
        if (!StringUtils.isEmpty(name)) {
            hql.append(" and a.name=?2");
        }
        if (!StringUtils.isEmpty(phone)) {
            hql.append(" and a.phone like ?3");
        }
        Query query = em.createNativeQuery(hql.toString());
        if (!StringUtils.isEmpty(account)) {
            query.setParameter(1, account);
        }
        if (!StringUtils.isEmpty(name)) {
            query.setParameter(2, name);
        }
        if (!StringUtils.isEmpty(phone)) {
            query.setParameter(3, "%"+phone+"%");
        }
        List<TmUser> tmUsers = new ArrayList<>();
        query.setFirstResult((pageNo-1)*pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        List<Object[]> objects = query.getResultList();
       for(Object[] obj:objects){
           TmUser tmUser = new TmUser();
          String myaccount =  obj[0].toString();
          String myname =  obj[1].toString();
          String myemail =  obj[2].toString();
          String myphone =  obj[3].toString();
           if(obj[4]!=null){
               String mycode =  obj[4].toString();
               tmUser.setCode(mycode);
           }

          String id =  obj[5].toString();

           tmUser.setAccount(myaccount);
           tmUser.setName(myname);
           tmUser.setEmail(myemail);
           tmUser.setPhone(myphone);


           tmUser.setId(Integer.valueOf(id));
           tmUsers.add(tmUser);
       }

       return tmUsers;
    }
}
