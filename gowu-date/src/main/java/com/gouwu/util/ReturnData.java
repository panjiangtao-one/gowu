package com.gouwu.util;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Map;

/**
 * @program: share-manage-3.0
 * @description: 封装接口返回对象
 * @author: ly
 * @create: 2019/1/15
 **/
@SuppressWarnings("serial")
public class ReturnData implements Serializable {
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";

    /**
     * 自定义状态码
     * 200:请求成功
     * 201:请求地址不合法
     * 202:请重新登录
     * 203:业务异常
     * 500:服务器内部异常
     */
    private String statusCode = "200";
    @JSONField(name = "success")
    private String status = SUCCESS;
    private String message;
    private Object data;
    private Map map;

    public ReturnData() {

    }

    public ReturnData(String status) {
        if (status != null && status.equals(ReturnData.ERROR)) {
            this.statusCode = "203";
        }
        this.status = status;
    }

    public ReturnData(String status, String message) {
        this.status = status;
        this.message = message;
    }


    public ReturnData(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static ReturnData getSuccessReturnData() {
        return new ReturnData(ReturnData.SUCCESS);
    }

    public static ReturnData getErrorReturnData() {
        return new ReturnData(ReturnData.ERROR);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
