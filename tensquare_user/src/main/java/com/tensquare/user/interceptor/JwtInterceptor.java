package com.tensquare.user.interceptor;

import com.tensqaure.common.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: tensquare_parent
 * @description: jwt拦截器
 * @author: Linweizhe
 * @create: 2019-03-02 21:10
 **/
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("经过了拦截器");
        String authHeader = request.getHeader("authorization");
        if (authHeader != null && authHeader.startsWith("lwz")) {
            String token = authHeader.substring(3);
            Claims claims = jwtUtil.parseJWT(token);
            if(claims!=null){ 
                if("admin".equals(claims.get("roles"))){//如果是管理员 
                    request.setAttribute("admin_claims","admin");
                } 
                if("user".equals(claims.get("roles"))){//如果是用户 
                    request.setAttribute("user_claims","user");
                } 
            }
        }
        return true;
    }
}
