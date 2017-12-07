package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmUser;
import com.xiaoyuan.util.MD5Util;
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
    public List<TmUser> findAllByaccountAndNameAndPhone(String account,String name,String phone) {
        StringBuffer hql = new StringBuffer(" select a.account,a.name,a.email,a.phone,c.code,a.id from TM_USER a,TM_USER_ROLE b,TM_ROLE c  where a.id=b.user_id and b.role_id = c.id ");
        if (!StringUtils.isEmpty(account)) {
            hql.append(" and account=?1");
        }
        if (!StringUtils.isEmpty(name)) {
            hql.append(" and name=?2");
        }
        if (!StringUtils.isEmpty(phone)) {
            hql.append(" and phone like ?3");
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
        List<Object[]> objects = query.getResultList();
       for(Object[] obj:objects){
           TmUser tmUser = new TmUser();
          String myaccount =  obj[0].toString();
          String myname =  obj[1].toString();
          String myemail =  obj[2].toString();
          String myphone =  obj[3].toString();
          String mycode =  obj[4].toString();
          String id =  obj[5].toString();
           tmUser.setAccount(myaccount);
           tmUser.setName(myname);
           tmUser.setEmail(myemail);
           tmUser.setPhone(myphone);
           tmUser.setCode(mycode);
           tmUser.setId(Integer.valueOf(id));
           tmUsers.add(tmUser);
       }
       return tmUsers;
    }
}
