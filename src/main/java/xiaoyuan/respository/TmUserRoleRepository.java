package com.xiaoyuan.respository;

import com.xiaoyuan.entity.TmUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dnys on 2017/9/20.
 */
public interface TmUserRoleRepository extends JpaRepository<TmUserRole,Integer>{
    public List<TmUserRole> findAllByuserid(int userid);
}
