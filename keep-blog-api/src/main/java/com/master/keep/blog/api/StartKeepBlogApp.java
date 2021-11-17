package com.master.keep.blog.api;

import com.master.keep.blog.dao.config.MybatisConfig;
import com.master.keep.blog.service.KeepBlogServiceConfig;
import com.master.keep.common.datasource.DruidConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({MybatisConfig.class, KeepBlogServiceConfig.class})
public class StartKeepBlogApp {

    public static void main(String[] args) {
        SpringApplication.run(StartKeepBlogApp.class, args);
    }

}