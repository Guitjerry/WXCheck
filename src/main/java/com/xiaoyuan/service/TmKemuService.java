package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmKemu;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 *根据班级查找科目
 */
public interface TmKemuService {
    public List<TmKemu> selectKemuByBanji(Integer banjidi);

    /**
     * 分页查询科目
     * @param pageRequest
     * @return
     */
    public List<TmKemu> findAllTmKemu(PageRequest pageRequest);
}
