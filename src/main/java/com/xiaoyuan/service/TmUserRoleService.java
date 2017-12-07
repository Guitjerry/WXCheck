package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmRole;

import java.util.List;

public interface TmUserRoleService {
    public List<TmRole> findAllRoleByUserId(Integer userId);
}
