package com.atguigu.servicebase.handler;

import com.atguigu.commonutils.rest.ObjectRestResponse;
import com.atguigu.commonutils.rest.RestCode;
import com.atguigu.commonutils.rest.RestMsg;
import com.atguigu.commonutils.utils.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 异常处理
 * @author: Wu Yuwei
 * @create: 2020-09-01 16:08
 **/
@ControllerAdvice
@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ObjectRestResponse error(Exception e){
        e.printStackTrace();
        return new ObjectRestResponse().message(RestMsg.FAILURE_MSG).status(RestCode.FAILURE);
    }

    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public ObjectRestResponse error(GuliException e){
        e.printStackTrace();
        log.error(e.getMsg());
        log.error(ExceptionUtil.getMessage(e));
        return new ObjectRestResponse().message(e.getMsg()).status(e.getCode());
    }

}
