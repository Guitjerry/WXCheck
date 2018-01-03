package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmUser;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by dnys on 2017/9/22.
 */
public interface TmUserService {
    public List<TmUser> findAllByaccountAndpassword(String account, String password);

    /**
     * 根据账户，用户名，手机查询
     * @param account
     * @param name
     * @param phone
     * @return
     */
    public List<TmUser> findAllByaccountAndNameAndPhone(String account, String name, String phone, Pageable pageable, Integer pageNo);
}
