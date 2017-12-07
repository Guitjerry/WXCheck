package com.xiaoyuan.respository;

import com.xiaoyuan.entity.TmUserScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dnys on 2017/10/24.
 */
public interface TmUserScoreRepository extends JpaRepository<TmUserScore,Integer> {
    public List<TmUserScore> findAllByNameAndStudentcodeAndSchoolClass(String name,String studentcode,String schoolclass);
}
