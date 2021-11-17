package com.master.keep.blog.dao;

import com.master.keep.blog.dao.config.MybatisConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MybatisConfig.class)
public class MapperTestBoot {
}