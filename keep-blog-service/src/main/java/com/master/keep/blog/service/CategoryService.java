package com.master.keep.blog.service;

import com.master.keep.blog.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> loadAllByUser(String username);

}