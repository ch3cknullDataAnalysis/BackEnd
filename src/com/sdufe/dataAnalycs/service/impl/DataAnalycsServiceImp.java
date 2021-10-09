package com.sdufe.dataAnalycs.service.impl;

import com.sdufe.dataAnalycs.dao.GetDataDao;
import com.sdufe.dataAnalycs.dao.impl.GetDataDaoImpl;
import com.sdufe.dataAnalycs.poji.Gdp;
import com.sdufe.dataAnalycs.poji.Temp;
import com.sdufe.dataAnalycs.service.DataAnalycsService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class DataAnalycsServiceImp implements DataAnalycsService {
    // 调用Dao层服务，获得必要的数据
    List<Gdp> gdpList = new LinkedList<>();
    GetDataDao getDataDao = new GetDataDaoImpl();
    float []keys;
    float sum=0;

    public DataAnalycsServiceImp(String key, String cityNum) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        this.gdpList = getDataDao.getAllData(key, cityNum);
        // 将待分析元素拿出来，形成一个数组，然后再进行处理
        keys = new float[gdpList.size()];
        for (int i=0; i<gdpList.size(); ++i){
            //用映射来决定该调用哪个方法
            // 将key的首字母大写
            char[] chars = key.toCharArray();
            if (chars[0]>'a' && chars[0]<'z') chars[0] = (char)(chars[0] - 32);
            key = new String(chars);
            Method method = Gdp.class.getMethod("get"+key);
            keys[i] = (float) method.invoke(gdpList.get(i));
        }
        //对数组进行从小到大的排序
        Arrays.sort(keys);
    }

    @Override
    public float getMax() {
        return keys[keys.length-1];
    }

    @Override
    public float getMin() {
        return keys[0];
    }

    @Override
    public float getSum() {
        for (int i = 0; i < keys.length; ++i) {
            sum+=keys[i];
        }
        return sum;
    }

    @Override
    public float getMean() {
        return sum/keys.length;
    }

    @Override
    public float getMedi() {
        return keys[(int)keys.length/2];
    }

    @Override
    public List<Gdp> getAllData() {
        return gdpList;
    }
}

/**
 * 自定义实现的比较器，用于List进行比较来排序
 */
class MyComparator implements Comparator<Temp> {
    //返回值为负则temp1排在temp2前面，反正在后面，为0则表示相等
    @Override
    public int compare(Temp temp1, Temp temp2) {
        if (temp1.getNum() >= temp2.getNum())return -1;
        else{
            return 1;
        }
    }
}