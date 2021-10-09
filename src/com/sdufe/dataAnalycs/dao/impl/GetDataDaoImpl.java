package com.sdufe.dataAnalycs.dao.impl;

import com.sdufe.dataAnalycs.dao.GetDataDao;
import com.sdufe.dataAnalycs.poji.Gdp;

import java.util.LinkedList;
import java.util.List;

public class GetDataDaoImpl extends BaseDao implements GetDataDao {
    @Override
    public List<Gdp> getAllData(String key, String cityNum) {
        String sql = "select "+"year,cityName,"+key+" from gdp where cityNum = "+cityNum;
        List<Gdp> gdps = queryForList(Gdp.class,sql);
        return gdps;
    }

    public List<Float> getDataOfNePredict(String cityNum, String key){
        String sql = "select "+key+" from gdp where cityNum = "+cityNum;
        List<Object[]> dataOfNePredict = queryForList(sql);
        List<Float> temp = new LinkedList<Float>();
        for (int i=0;i<dataOfNePredict.size();++i){
            temp.add((Float) dataOfNePredict.get(i)[0]);
        }
        return temp;
    }
//    @Override
//    public List<Temp> getKeyData(String key, String cityNum) {
//        String sql = "select "+key+" from gdp where cityNum = "+cityNum;
//        List<Temp> keys = queryForList(Temp.class,  sql);
//        return keys;
//    }
}
