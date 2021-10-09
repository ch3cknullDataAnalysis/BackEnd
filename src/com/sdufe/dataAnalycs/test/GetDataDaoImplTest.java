package com.sdufe.dataAnalycs.test;

import com.sdufe.dataAnalycs.dao.impl.GetDataDaoImpl;

public class GetDataDaoImplTest {

    GetDataDaoImpl getDataDao = new GetDataDaoImpl();
    @org.junit.Test
    public void getAllData() {
        System.out.println(""+getDataDao.getAllData("gdpSum","110000"));
    }

    @org.junit.Test
    public void getgetDataOfNePredict() {
        System.out.println(""+getDataDao.getDataOfNePredict("gdpSum","110000"));
    }

//    @org.junit.Test
//    public void getKeyData() {
//        // 测试北京数据
//        System.out.println(""+getDataDao.getKeyData("gdpSum","110000"));
//    }
}