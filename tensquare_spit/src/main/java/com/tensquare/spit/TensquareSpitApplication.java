package com.tensquare.spit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.tensqaure.common.util.IdWorker;

/**
 * @program: tensquare_parent
 * @description:吐槽模块启动类
 * @author: Linweizhe
 * @create: 2018-12-19 21:26
 **/
@SpringBootApplication
public class TensquareSpitApplication {

    public static void main(String[] args) {
        SpringApplication.run(TensquareSpitApplication.class);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1, 1);
    }
}
