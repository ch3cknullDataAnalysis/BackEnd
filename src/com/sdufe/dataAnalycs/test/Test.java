package com.sdufe.dataAnalycs.test;

import com.opensymphony.xwork2.ActionSupport;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class Test extends ActionSupport {

    InputStream inputStream;
    public InputStream getInputStream() {
        return inputStream;
    }

    /**
     * 测试struts是否可以使用
     * @return
     */
    public String test1(){
        System.out.println("可以正常使用struts2");
        return "test1 is ok";
    }

    /**
     * 测试ajax的使用
     * @return
     */
    public String test2() throws UnsupportedEncodingException {
        inputStream = new ByteArrayInputStream("ajax is ok".getBytes("UTF-8"));
        System.out.println("可以正常使用struts2的ajax");
        return "test2 is ok";
    }
}
