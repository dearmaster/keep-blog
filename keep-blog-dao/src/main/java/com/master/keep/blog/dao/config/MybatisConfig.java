package com.master.keep.blog.dao.config;

import com.master.keep.common.datasource.DruidConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@MapperScan("com.master.keep.blog.dao.mapper")
@Import({DruidConfig.class})
public class MybatisConfig {
}