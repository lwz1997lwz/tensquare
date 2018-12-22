package com.tensquare.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.tensqaure.common.util.IdWorker;

/**
 * @program: tensquare_parent
 * @description: tensquare_base模块启动类
 * @author: Linweizhe
 * @create: 2018-12-05 18:38
 **/
@SpringBootApplication
public class TensquareBaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(TensquareBaseApplication.class, args);
    }

    //将其注册为bean
    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
