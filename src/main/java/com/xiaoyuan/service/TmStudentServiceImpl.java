package com.xiaoyuan.service;

import com.xiaoyuan.entity.TmStudent;
import com.xiaoyuan.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dnys on 2017/9/28.
 */
@Service(value = "tmStudentService")
public class TmStudentServiceImpl implements TmStudentService{
    @PersistenceContext
    protected EntityManager em;
    @Override
    public List<TmStudent> findAllStudent() {
        List<TmStudent> tmStudents = new ArrayList<>();
        String hql =" select u.NAME,u.USERCODE,u.PHONE,u.AGE,u.BANJIID,b.NAME as banjiname,u.id from TM_STUDENT u left join TM_BANJI b on u.banjiid=b.ID";
        Query query = em.createNativeQuery(hql);
        List<Object[]> objects = query.getResultList();
        for(Object[] tmstudent:objects){
            TmStudent tmStudent = new TmStudent();

            String name = tmstudent[0]==null?"":String.valueOf(tmstudent[0]);
            String code = tmstudent[1]==null?"":String.valueOf(tmstudent[1]);
            String phone = tmstudent[2]==null?"":String.valueOf(tmstudent[2]);
            String age = tmstudent[3]==null?null:String.valueOf(tmstudent[3]);
            String banjiid = tmstudent[4]==null?null:String.valueOf(tmstudent[4]);
            String banjiname = tmstudent[5]==null?"":String.valueOf(tmstudent[5]);
            String id = tmstudent[6]==null?"":String.valueOf(tmstudent[6]);
            tmStudent.setName(name);
            tmStudent.setUsercode(code);
            tmStudent.setPhone(phone);
            if(!StringUtils.isEmpty(age)){
                tmStudent.setAge(Integer.valueOf(age));
            }
            if(!StringUtils.isEmpty(banjiid)){
                tmStudent.setBanjiid(Integer.valueOf(banjiid));
            }
            if(!StringUtils.isEmpty(id)){
                tmStudent.setId(Integer.valueOf(id));
            }
            tmStudent.setBanjiname(banjiname);
            tmStudents.add(tmStudent);
        }
        return tmStudents;
    }
}
