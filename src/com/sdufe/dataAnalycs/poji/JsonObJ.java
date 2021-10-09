package com.sdufe.dataAnalycs.poji;

import java.util.Arrays;


/**
 * 回传给前端的javaBean封装类，用来转化成json字符串
 */
public class JsonObJ {
    int code;//状态码，0为成功，其他为失败
    String message;// 错误提示信息，没有错误时不用管
    String keyName;// 前端传过来的属性名
    JsonObjSub[] data;// 存放对应城市的要返回数据

    public JsonObJ(int code, String message, String keyName, int length) {
        this.code = code;
        this.message = message;
        this.keyName = keyName;
        this.data = new JsonObjSub[length];
    }

    public JsonObJ() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public JsonObjSub[] getData() {
        return data;
    }

    public void setData(JsonObjSub[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonObJ{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", keyName='" + keyName + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}