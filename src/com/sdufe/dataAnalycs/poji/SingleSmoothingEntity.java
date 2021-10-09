package com.sdufe.dataAnalycs.poji;

import java.io.Serializable;
import java.util.List;

public class SingleSmoothingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Float> realDataList;

    private Float lastPredictParam;

    public List<Float> getRealDataList() {
        return realDataList;
    }

    public void setRealDataList(List<Float> realDataList) {
        this.realDataList = realDataList;
    }

    public Float getLastPredictParam() {
        return lastPredictParam;
    }

    public void setLastPredictParam(Float lastPredictParam) {
        this.lastPredictParam = lastPredictParam;
    }
}
