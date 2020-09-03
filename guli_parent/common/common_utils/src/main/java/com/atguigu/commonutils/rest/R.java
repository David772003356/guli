package com.atguigu.commonutils.rest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 结果类
 * @author: Wu Yuwei
 * @create: 2020-08-31 09:00
 **/
@Data
public class R implements Serializable {
    private static final long serialVersionUID = 8655251143785547771L;

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty("返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    private R(){}

    public static R ok(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(RestCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }
    public static R failure(){
        R r = new R();
        r.setSuccess(false);
        r.setCode(RestCode.FAILURE);
        r.setMessage("失败");
        return r;
    }
    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }
    public R message(String message){
        this.setMessage(message);
        return this;
    }
    public R code(Integer code){
        this.setCode(code);
        return this;
    }
    public R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }
    public R data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
