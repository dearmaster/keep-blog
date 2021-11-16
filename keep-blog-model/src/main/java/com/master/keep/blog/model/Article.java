package com.master.keep.blog.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class Article {

    @ApiModelProperty(example = "example-id")
    private String id;
    @ApiModelProperty(example = "我的博客开通啦", required = true)
    private String subject;
    @ApiModelProperty(example = "大家好，我是Jay。这是我的个人博客。欢迎大家来访", required = true)
    private String content;

}