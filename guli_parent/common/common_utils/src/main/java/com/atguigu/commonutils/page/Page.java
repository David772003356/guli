package com.atguigu.commonutils.page;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 分页参数
 * @author: Wu Yuwei
 * @create: 2020-08-31 17:48
 **/
@Data
public class Page implements Serializable {

    private static final long serialVersionUID = 6491813377767395131L;
    private int pageNum=1;
    private int pageSize=10;
    private String sortColumn;
    private String sortRule;
}
