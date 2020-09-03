package com.atguigu.eduservice.dto;

import com.atguigu.commonutils.page.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Wu Yuwei
 * @create: 2020-08-31 17:54
 **/
@Data
public class TeacherDTO extends Page implements Serializable {
    private static final long serialVersionUID = 5581716166589069652L;

    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @ApiModelProperty(value = "讲师简介")
    private String intro;

    @ApiModelProperty(value = "讲师资历,一句话说明讲师")
    private String career;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "讲师头像")
    private String avatar;

    @ApiModelProperty(value = "排序")
    private Integer sort;
}
