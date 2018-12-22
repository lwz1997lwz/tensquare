package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface RecruitDao extends JpaRepository<Recruit, String>, JpaSpecificationExecutor<Recruit> {
    /**
     * 根据state(0:关闭 1:开启 2:推荐) 查询推荐的前六个职位  并根据创建时间降序排列
     * @param state
     * @return
     */
    List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state);

    /**
     * 查询最新的职位
     * @param state
     * @return
     */
    List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state);
}
