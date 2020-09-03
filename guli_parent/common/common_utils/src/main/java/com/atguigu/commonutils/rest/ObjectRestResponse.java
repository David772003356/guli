package com.atguigu.commonutils.rest;

/**
 * @description:
 * @author: Wu Yuwei
 * @create: 2020-08-31 09:42
 **/
public class ObjectRestResponse<T> extends BaseResponse {

    T data;

    public ObjectRestResponse data(T data) {
        this.setData(data);
        return this;
    }

    public ObjectRestResponse status(int status) {
        this.setStatus(status);
        return this;
    }

    public ObjectRestResponse message(String message) {
        this.setMessage(message);
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ObjectRestResponse [")
                .append("status=").append(getStatus())
                .append("message=").append(getMessage())
                .append("data=").append(data)
                .append("]");
        return sb.toString();
    }
}
