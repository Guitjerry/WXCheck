package com.xiaoyuan.respository;

import com.xiaoyuan.entity.TmUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dnys on 2017/9/18.
 */
public interface TmUserRepository extends JpaRepository<TmUser,Integer> {
//    public List<TmUser> findAllByaccountAndpassword(String account,String password);
}
