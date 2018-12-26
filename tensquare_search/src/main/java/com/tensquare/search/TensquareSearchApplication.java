package com.tensquare.search;

import com.tensqaure.common.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @program: tensquare_parent
 * @description: 搜索模块启动类
 * @author: Linweizhe
 * @create: 2018-12-23 13:10
 **/
@SpringBootApplication
public class TensquareSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(TensquareSearchApplication.class);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1, 1);
    }

}

