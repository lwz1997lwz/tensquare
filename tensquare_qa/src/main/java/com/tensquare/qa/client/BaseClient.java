package com.tensquare.qa.client;

import com.tensqaure.common.entity.Result;
import com.tensqaure.common.entity.StatusCode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: tensquare_parent
 * @description:
 * @author: Linweizhe
 * @create: 2019-03-08 20:52
 **/

@FeignClient("tensquare-base")
public interface BaseClient {
    @RequestMapping(value="/label" , method = RequestMethod.GET)
    public Result getAll();

}
