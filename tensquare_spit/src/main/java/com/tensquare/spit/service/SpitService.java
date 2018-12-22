package com.tensquare.spit.service;

import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tensqaure.common.util.IdWorker;

import java.util.Date;
import java.util.List;

/**
 * @program: tensquare_parent
 * @description:
 * @author: Linweizhe
 * @create: 2018-12-20 16:48
 **/
@Service
@Transactional
public class SpitService {
    @Autowired
    private SpitDao spitDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MongoTemplate mongoTemplate;


    public List findAll() {
        return spitDao.findAll();
    }

    public Spit findById(String id) {
        return spitDao.findById(id).get();
    }

    public void save(Spit spit) {
        spit.set_id(idWorker.nextId() + "");
        spit.setPublishtime(new Date());//发布日期
        spit.setVisits(0);//浏览量
        spit.setShare(0);//分享数
        spit.setThumbup(0);//点赞数
        spit.setComment(0);//回复数
        spit.setState("1");//状态
        //发布吐槽若存在上级 需增加上级评论数
        if (null != spit.getParentid() && !"".equals(spit.getParentid())) {
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
            Update update = new Update();
            update.inc("comment", 1);
            mongoTemplate.updateFirst(query, update, "spitdb");
        }
        spitDao.save(spit);
    }

    public void update(Spit spit) {
        spitDao.save(spit);
    }

    public void deleteById(String id) {
        spitDao.deleteById(id);
    }

    public Page<Spit> findByParentid(String id, int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        return spitDao.findByParentid(id, pageable);
    }

    /**
     * 点赞
     *
     * @param id
     */
    public void updateThumbup(String id) {
//        存在效率问题  与数据库交互了两次  且没必要查询出所有字段修改后再更新所有字段。
//        Spit spit = spitDao.findById(id).get();
//        spit.setThumbup((spit.getThumbup()== null?0:spit.getThumbup())+1);
//        spitDao.save(spit);
        //方式二 使用类似与原生mongo命令实现自增

        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update = new Update();
        update.inc("thumbup", 1);
        mongoTemplate.updateFirst(query, update, "spitdb");
    }
}
