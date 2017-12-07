package com.xiaoyuan.respository;

import com.xiaoyuan.entity.TmUserClassKemu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TmUserClassKemuRepository extends JpaRepository<TmUserClassKemu,Integer> {
    public List<TmUserClassKemu> findAllByUserId(Integer userid);
}
