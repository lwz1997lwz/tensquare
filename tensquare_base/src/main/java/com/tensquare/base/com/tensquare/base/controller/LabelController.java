package com.tensquare.base.com.tensquare.base.controller;

import com.tensquare.base.com.tensquare.base.pojo.Label;
import com.tensquare.base.com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: tensquare_parent
 * @description: 标签控制器类
 * @author: Linweizhe
 * @create: 2018-12-05 18:55
 **/

@RestController //相当于 @ResponseBody 和 @Controller
@CrossOrigin// 解决跨域问题
@RequestMapping("/label")
public class LabelController {
    @Autowired
    LabelService labelService;

    @RequestMapping(method = RequestMethod.GET)
    public Result getAll() {
        return new Result(true, StatusCode.OK, "查询成功", labelService.getAll());
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.GET)
    public Result getById(@PathVariable String labelId) {

        return new Result(true, StatusCode.OK, "查询成功", labelService.findLabelById(labelId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Label label) {
        labelService.save(label);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.PUT)
    public Result update(@PathVariable String labelId, @RequestBody Label label) {
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String labelId) {
        labelService.delete(labelId);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result search(@RequestBody Label label) {
        List<Label> list = labelService.search(label);
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result pageQuery(@RequestBody Label label, @PathVariable int page, @PathVariable int size) {
        Page<Label> pageData = labelService.pageQuery(label, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult(pageData.getTotalElements(), pageData.getContent()));
    }
}
