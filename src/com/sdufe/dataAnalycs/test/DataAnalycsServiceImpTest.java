package com.sdufe.dataAnalycs.test;

import com.sdufe.dataAnalycs.service.DataAnalycsService;
import com.sdufe.dataAnalycs.service.impl.DataAnalycsServiceImp;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class DataAnalycsServiceImpTest {
    DataAnalycsService dataAnalycsServiceImp;

    {
        try {
            dataAnalycsServiceImp = new DataAnalycsServiceImp("gdpSum","110000");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAll() {
        System.out.println("max="+dataAnalycsServiceImp.getMax()+"      min="+dataAnalycsServiceImp.getMin()+
                "      sum="+dataAnalycsServiceImp.getSum()+"       mean="+
                dataAnalycsServiceImp.getMean()+"        medi="+dataAnalycsServiceImp.getMedi());
    }
}