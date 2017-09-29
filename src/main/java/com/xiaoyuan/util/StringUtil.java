package com.xiaoyuan.util;

import org.springframework.util.StringUtils;

/**
 * Created by dnys on 2017/9/28.
 */
public class StringUtil {
    /**
     * 对象是空返回空字符串（obj传入字符串对象）
     * @param obj
     * @return
     */
    public static String getStr(Object obj,String format){
        String ostr = obj==null?null:String.valueOf(obj);
        if("string".equals(format)&&ostr==null){
          ostr="";

        }
        return ostr;

    }
}
