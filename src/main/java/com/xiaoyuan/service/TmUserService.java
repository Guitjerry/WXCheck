package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmUser;

import java.util.List;

/**
 * Created by dnys on 2017/9/22.
 */
public interface TmUserService {
    public List<TmUser> findAllByaccountAndpassword(String account, String password);
}
