package com.tensquare.spit.controller;

import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import com.tensqaure.common.entity.PageResult;
import com.tensqaure.common.entity.Result;
import com.tensqaure.common.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @program: tensquare_parent
 * @description: 吐槽控制器
 * @author: Linweizhe
 * @create: 2018-12-20 16:53
 **/
@RestController
@CrossOrigin
@RequestMapping(value = "/spit")
public class SpitController {
    @Autowired
    private SpitService spitService;
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 查询全部数据
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", spitService.findAll());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findOne(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", spitService.findById(id));
    }

    /**
     * 增加
     *
     * @param spit
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Spit spit) {
        spitService.save(spit);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 4.2.3 根据上级ID查询吐槽列表
     * （1）SpitDao新增方法定义
     * （2）SpitService新增方法
     * 修改
     *
     * @param spit
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody Spit spit, @PathVariable String id) {
        spit.set_id(id);
        spitService.update(spit);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id) {
        spitService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @RequestMapping(value="/comment/{parentId}/{page}/{size}",method=RequestMethod.GET)
    public Result findByParentid(@PathVariable String parentId,
                                 @PathVariable int page,@PathVariable int size){
        Page<Spit> pageList = spitService.findByParentid(parentId,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Spit>(pageList.getTotalElements(), pageList.getContent() ) );
    }
    /**
     * 点赞
     * @param id
     * @return
     */
    @RequestMapping(value="/thumbup/{id}",method=RequestMethod.PUT)
    public Result updateThumbup(@PathVariable String id){
        //通过redis 控制不能重复点赞
        String userid = "111";//userid需通过权限模块获得
        if (redisTemplate.opsForValue().get("thumbup_" + userid+"_"+id) != null) {
            return new Result(false, StatusCode.REPERROR, "不能重复点赞");
        }
        spitService.updateThumbup(id);
        redisTemplate.opsForValue().set("thumbup_" + userid+"_"+id,"1");
        return new Result(true,StatusCode.OK,"点赞成功");
    }
}

