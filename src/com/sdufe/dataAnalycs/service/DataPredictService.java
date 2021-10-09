package com.sdufe.dataAnalycs.service;

public interface DataPredictService {
    /**
     * 返回数据预测的结果
     * @param cityNum 要预测的省份编码
     * @param key 要预测的属性
     * @return 以字符串的形式返回预测的结果
     */
    public float getDataPredict(String cityNum,String key);
}
