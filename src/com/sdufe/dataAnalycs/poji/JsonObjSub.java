package com.sdufe.dataAnalycs.poji;

import java.util.HashMap;
import java.util.Map;

public class JsonObjSub {
    String cityName;
    float[][] raw;// 元数据
    Map<String, Float> stat = new HashMap<String, Float>();// 统计数据

    public JsonObjSub(String cityName, float[][] raw, Map<String, Float> stat) {
        this.cityName = cityName;
        this.raw = raw;
        this.stat = stat;
    }

    public JsonObjSub() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public float[][] getRaw() {
        return raw;
    }

    public void setRaw(float[][] raw) {
        this.raw = raw;
    }

    public Map<String, Float> getStat() {
        return stat;
    }

    public void setStat(Map<String, Float> stat) {
        this.stat = stat;
    }
}
