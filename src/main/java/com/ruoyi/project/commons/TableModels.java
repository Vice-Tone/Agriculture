package com.ruoyi.project.commons;

import java.util.HashMap;
import java.util.Map;

/**

 */
public class TableModels {
    public int code;
    public String msg;
    public int count;
    public boolean status;
    public Object data;

    public TableModels() {
    }

    /* 返回状态为true,带有参数和count*/
    public static TableModels success(int count, Object data) {
        return new TableModels(0, "", count, data, true);
    }

    /* 返回状态为true，带有参数，不带count，此时count为0*/
    public static TableModels success(Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", data);
        return new TableModels(0, "", data, true);
    }


    /*返回状态为true，参数为空 */
    public static TableModels success() {
        return new TableModels(0, "", true);
    }

    public static TableModels failure() {

        return new TableModels(500, "", false);
    }


    public static TableModels failure(Object data) {
        return new TableModels(500, "", data, false);
    }
    public static TableModels failure(int code,Object data) {
        return new TableModels(code, "", data, false);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TableModels(int code, String msg, Object data, boolean status) {
        this.code = code;
        this.msg = msg;
        this.status = status;
        this.data = data;
    }

    public TableModels(int code, String msg, int count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public TableModels(int code, String msg, boolean status) {
        this.code = code;
        this.msg = msg;
        this.status = status;
    }

    public TableModels(int code, String msg, int count, Object data, boolean status) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.status = status;
        this.data = data;
    }


}
