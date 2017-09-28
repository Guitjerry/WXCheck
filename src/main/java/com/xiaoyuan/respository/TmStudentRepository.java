package com.xiaoyuan.respository;

import com.xiaoyuan.entity.TmStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dnys on 2017/9/8.
 */
public interface TmStudentRepository extends JpaRepository<TmStudent,Integer>{
    public List<TmStudent> findAllByusercode(String usercode);
}
