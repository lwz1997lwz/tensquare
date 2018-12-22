package com.tensquare.article.dao;

import com.tensquare.article.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article>{

    /**
     * 审核文章 state 0 -> 1
     * @param id
     */
    @Modifying
    @Query(value = "update tb_article set state = 1 where id = ?" ,nativeQuery = true)
    void updateState(String id);

    /**
     * 给文章点赞+1
     * @param id
     */
    @Modifying
    @Query(value = "update tb_article set thumbup = thumbup + 1 where id = ?",nativeQuery = true)
     void thumbupArticle(String id);
}
