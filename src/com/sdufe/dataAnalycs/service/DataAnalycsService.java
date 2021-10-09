package com.sdufe.dataAnalycs.service;

import com.sdufe.dataAnalycs.poji.Gdp;

import java.util.List;

public interface DataAnalycsService {
    public List<Gdp> getAllData();
    public float getMax();
    public float getMin();
    public float getSum();
    public float getMean();
    public float getMedi();
}
