package com.sdufe.dataAnalycs.poji;

import java.util.HashMap;
import java.util.Map;

public class JsonObj1 {
    int code;//状态码，0为成功，其他为失败
    String message;// 错误提示信息，没有错误时不用管
    float data;

    public JsonObj1(int code, String message, float data) {
        this.code = code;
        this.message = message;
        this.data = data;
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

    public float getData() {
        return data;
    }

    public void setData(float data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonObj1{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
