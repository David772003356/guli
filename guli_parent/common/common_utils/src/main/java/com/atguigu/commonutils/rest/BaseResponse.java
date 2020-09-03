package com.atguigu.commonutils.rest;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: Wu Yuwei
 * @create: 2020-08-31 09:41
 **/
@Data
public class BaseResponse {
    private int status = 200;
    private String message;
    private Date srvTime = new Date();

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse status(int status){
        this.status = status;
        return this;
    }
    public BaseResponse message(String message){
        this.message= message;
        return this;
    }

    public BaseResponse() {
    }
}
