package com.master.keep.blog.api.controller;

import com.master.keep.blog.model.Article;
import com.master.keep.blog.model.Category;
import com.master.keep.blog.service.CategoryService;
import com.master.keep.common.web.model.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.master.keep.common.web.ResponseBuilder.success;

@Api
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ApiOperation("查询当前登录用户所有分类")
    @GetMapping("/loadAll")
    public Response<List<Category>> loadAll() {
        List<Category> list = categoryService.loadAllByUser("lily");
        return success(list);
    }

    @ApiOperation("查询当前登录用户指定分类")
    @GetMapping("/load/{id}")
    public Response<Article> loadById(@PathVariable("id") String articleId) {
        return success();
    }

    @ApiOperation("删除当前登录用户指定分类")
    @GetMapping("/delete/{id}")
    public Response<Void> delete(@PathVariable("id") String articleId) {
        return success();
    }

    @ApiOperation("保存分类给当前用户")
    @PostMapping("/save")
    public Response<Void> save(@RequestBody Article article) {
        return success();
    }

    @ApiOperation("更新当前用户指定分类")
    @PostMapping("/update")
    public Response<Void> update(@RequestBody Article article) {
        return success();
    }

}