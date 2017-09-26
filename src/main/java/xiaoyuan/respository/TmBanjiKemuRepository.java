package com.xiaoyuan.respository;

import com.xiaoyuan.entity.TmBanjiKemu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dnys on 2017/9/20.
 */
public interface TmBanjiKemuRepository extends JpaRepository<TmBanjiKemu,Integer>{
    public List<TmBanjiKemu> findAllBybanjiid(int banjiid);
}
