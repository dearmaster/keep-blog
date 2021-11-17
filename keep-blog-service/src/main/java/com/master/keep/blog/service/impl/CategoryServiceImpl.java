package com.master.keep.blog.service.impl;

import com.master.keep.blog.dao.mapper.CategoryMapper;
import com.master.keep.blog.model.Category;
import com.master.keep.blog.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<Category> loadAllByUser(String username) {
        return categoryMapper.selectByUser(username);
    }

}