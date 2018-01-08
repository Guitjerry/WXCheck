package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmClassJiLvChild;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.List;

/**
 * Created by dnys on 2018/1/8.
 */
public interface TmClassJiLvChildService {
    public List<TmClassJiLvChild> findAll();
    public List<TmClassJiLvChild> findAllByType();
}
