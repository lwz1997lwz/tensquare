package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @program: tensquare_parent
 * @description:
 * @author: Linweizhe
 * @create: 2018-12-20 16:45
 **/
public interface SpitDao extends MongoRepository<Spit,String> {
    public Page findByParentid(String parentId , Pageable pageable);
}
