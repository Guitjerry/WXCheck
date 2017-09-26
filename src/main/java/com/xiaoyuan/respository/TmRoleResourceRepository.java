package com.xiaoyuan.respository;

import com.xiaoyuan.entity.TmRoleResource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dnys on 2017/9/19.
 */
public interface TmRoleResourceRepository extends JpaRepository<TmRoleResource,Integer>{
    public List<TmRoleResource> findAllByroleid(Integer roleid);
}
