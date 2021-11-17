package com.master.keep.blog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

/**
 * Category is a user defined value
 */
@Setter
@Getter
@NoArgsConstructor
public class Category {

    private String uid;
    private String name;
    private List<Article> articles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return name.equals(category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Category{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}