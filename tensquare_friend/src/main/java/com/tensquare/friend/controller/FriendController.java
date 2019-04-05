package com.tensquare.friend.controller;

import com.tensqaure.common.entity.Result;
import com.tensqaure.common.entity.StatusCode;
import com.tensqaure.common.util.JwtUtil;
import com.tensquare.friend.service.FriendService;
import io.jsonwebtoken.Claims;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: tensquare_parent
 * @description: 交友控制器
 * @author: Linweizhe
 * @create: 2019-03-11 15:47
 **/

@RestController
@RequestMapping(value = "/friend")
public class FriendController {


    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private FriendService friendService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/add/{friendId}/{type}", method = RequestMethod.POST)
    public Result addFriend(@PathVariable String friendId, @PathVariable int type) {

        Claims claims = (Claims) request.getAttribute("roles");
        if (claims == null) {
            return new Result(false, StatusCode.ERROR, "未登录");
        }
        String userId = claims.getId();
        //判断交友类型（type：  1：喜欢  2：不喜欢 ）
        if (type == 1) {
            int flag = friendService.addFriend(userId, friendId);
            if (flag == 0) {
                return new Result(false, StatusCode.ERROR, "请勿重复添加");
            }
        }else {

        }

        return new Result(true, StatusCode.OK, "操作成功");
    }
}
