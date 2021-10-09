package com.sdufe.dataAnalycs.dao;

import com.sdufe.dataAnalycs.poji.Gdp;
import com.sdufe.dataAnalycs.poji.Temp;

import java.util.List;

public interface GetDataDao {
    /**
     * 返回所有数据
     * @param key 需要返回哪个属性列
     * @param cityNum 省份编码
     * @return
     */
    public List<Gdp> getAllData(String key, String cityNum);

    /**
     * 返回数据分析所需要用的数据
     * @param key 需要返回哪个属性列
     * @param cityNum 省份编码
     * @return
     */
    public List<Float> getDataOfNePredict(String cityNum, String key);

//    /**
//     * 返回要求进行数据分析的数据
//     * @return
//     */
//    public List<Temp> getKeyData(String key, String cityNum);
}
