package com.example.springbootmybaitsplus.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author huanfuan
 * @Date 2019/12/30 23:03
 * @Version 1.0
 */

@Configuration
public class MybatisPlusConfig {

    /**
     * 注册分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return  new PaginationInterceptor();
    }
}
