package com.atguigu.commonutils.rest;

import java.util.List;

/**
 * @description:
 * @author: Wu Yuwei
 * @create: 2020-08-31 09:43
 **/
public class TableResultResponse<T> extends BaseResponse {

    TableData<T> data;

    public TableResultResponse(long total, List<T> rows) {
        this.data = new TableData<T>(total, rows);
    }

    public TableResultResponse(long total, Object object, List<T> rows) {
        this.data = new TableData<T>(total, object, rows);
    }

    public TableResultResponse() {
        this.data = new TableData<T>();
    }

    @Override
    public TableResultResponse message(String message){
        this.setMessage(message);
        return this;
    }

    @Override
    public TableResultResponse status(int status){
        this.setStatus(status);
        return this;
    }

    TableResultResponse<T> total(int total) {
        this.data.setTotal(total);
        return this;
    }

    TableResultResponse<T> total(List<T> rows) {
        this.data.setRows(rows);
        return this;
    }

    public TableData<T> getData() {
        return data;
    }

    public void setData(TableData<T> data) {
        this.data = data;
    }

    public class TableData<T> {
        long total;
        Object object;
        List<T> rows;

        public TableData(long total, List<T> rows) {
            this.total = total;
            this.rows = rows;
        }

        public TableData(long total, Object object, List<T> rows) {
            this.total = total;
            this.object = object;
            this.rows = rows;
        }

        public TableData() {
        }

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }

        public List<T> getRows() {
            return rows;
        }

        public void setRows(List<T> rows) {
            this.rows = rows;
        }

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }
    }
}
