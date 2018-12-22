package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.data.jpa.repository.Query;


/**
 * 问题数据访问接口
 *
 * @author Administrator
 */
public interface ProblemDao extends JpaRepository<Problem, String>, JpaSpecificationExecutor<Problem> {

    /**
     * 根据标签id查询最新问答
     * @param labelid
     * @param pageable
     * @return
     */
    @Query(value = "select * from tb_pl t1, tb_problem t2 where t2.id = t1.problemid and t1.labelid = ?1 order by t2.replytime desc",nativeQuery = true)
    Page<Problem> newList(String labelid , Pageable pageable);

    @Query(value = "select * from tb_pl t1, tb_problem t2 where t2.id = t1.problemid and t1.labelid = ? order by t2.reply desc",nativeQuery = true)
    Page<Problem> hotList(String labelid , Pageable pageable);

    @Query(value = "select * from tb_pl t1, tb_problem t2 where t2.id = t1.problemid and t1.labelid = ? and reply = 0 order by t2.replytime desc",nativeQuery = true)
    Page<Problem> waitList(String labelid , Pageable pageable);

}
