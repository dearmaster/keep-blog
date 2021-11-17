package com.master.keep.blog.api.controller;

import com.master.keep.blog.model.Article;
import com.master.keep.common.web.model.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.master.keep.common.web.ResponseBuilder.success;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @ApiOperation("查询当前登录用户所有文章")
    @GetMapping("/loadAll")
    public Response<List<Article>> loadAll() {
        return success();
    }

    @ApiOperation("查询当前登录用户指定分类下所有文章")
    @GetMapping("/loadAll/{category}")
    public Response<List<Article>> loadAllByCategory(@PathVariable("category") String categoryId) {
        return success();
    }

    @ApiOperation("查询当前登录用户指定文章")
    @GetMapping("/load/{id}")
    public Response<Article> loadById(@PathVariable("id") String articleId) {
        return success();
    }

    @ApiOperation("删除当前登录用户指定文章")
    @GetMapping("/delete/{id}")
    public Response<Void> delete(@PathVariable("id") String articleId) {
        return success();
    }

    @ApiOperation("保存文章到当前用户")
    @PostMapping("/save")
    public Response<Void> save(@RequestBody Article article) {
        return success();
    }

    @ApiOperation("更新当前用户文章")
    @PostMapping("/update")
    public Response<Void> update(@RequestBody Article article) {
        return success();
    }

}