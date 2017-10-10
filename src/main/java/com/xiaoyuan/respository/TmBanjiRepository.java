package com.xiaoyuan.respository;

import com.xiaoyuan.entity.TmBanJi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dnys on 2017/9/8.
 */
public interface TmBanjiRepository  extends JpaRepository<TmBanJi,Integer>{
    public List<TmBanJi> findAllByname(String name);
}
