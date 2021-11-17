package com.master.keep.blog.dao.mapper;

import com.master.keep.blog.model.Category;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface CategoryMapper {

    @Select({
            "select c.*",
            "from t_category c",
            "inner join t_user u",
            "on (c.user_id = u.id and u.username = #{username})"
    })
    @Results({
            @Result(id = true, column = "id", property = "uid"),
            @Result(column = "category", property = "name"),
            @Result(column = "id", property = "articles",
                    many = @Many(
                            select = "com.master.keep.blog.dao.mapper.ArticleMapper.selectByCategory",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<Category> selectByUser(String username);

}