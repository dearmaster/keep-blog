package com.master.keep.blog.dao.mapper;

import com.master.keep.blog.model.Article;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleMapper {

    @Select({
            "select a.*",
            "from t_article a",
            "inner join t_category_article_map m",
            "on (a.id = m.article_id and m.category_id = #{categoryId})"
    })
    @Results({
            @Result(id = true, column = "id", property = "uid"),
            @Result(column = "subject", property = "subject"),
            @Result(column = "content", property = "content")
    })
    List<Article> selectByCategory(String categoryId);

}