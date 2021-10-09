package com.sdufe.dataAnalycs.test;

import com.sdufe.dataAnalycs.service.impl.DataPredictServiceImp;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataPredictServiceImpTest {

    @Test
    public void getDataPredict() {
        DataPredictServiceImp dataPredictServiceImp = new DataPredictServiceImp();
        dataPredictServiceImp.getDataPredict("gdpSum","110000");
    }
}