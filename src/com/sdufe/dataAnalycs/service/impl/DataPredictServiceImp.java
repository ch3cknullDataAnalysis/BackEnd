package com.sdufe.dataAnalycs.service.impl;

import com.sdufe.dataAnalycs.dao.impl.GetDataDaoImpl;
import com.sdufe.dataAnalycs.poji.SingleSmoothingEntity;
import com.sdufe.dataAnalycs.service.DataPredictService;
import sun.plugin2.os.windows.FLASHWINFO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataPredictServiceImp implements DataPredictService {
    @Override
    public float getDataPredict(String cityNum, String key) {
        String dataPredictResu = "";
        // 调用dao层服务，获得所需数据
        GetDataDaoImpl getDataDao = new GetDataDaoImpl();
        List<Float> dataOfNePredict = getDataDao.getDataOfNePredict(cityNum, key);
        // 进行数据处理
        /** 一次指数平滑公式：
         * F(t+1)=a*Xt+(1-a)*Ft
         */
        // （1）获取实际观察值列表和最后一次的预测值
        SingleSmoothingEntity singleSmoothingEntity = new SingleSmoothingEntity();
        singleSmoothingEntity.setRealDataList(dataOfNePredict);
        singleSmoothingEntity.setLastPredictParam(dataOfNePredict.get(0));
        List<Float> realParamList = singleSmoothingEntity.getRealDataList();
        float lastPredictParam = singleSmoothingEntity.getLastPredictParam();
        // 定义结果集合类
        Map<Float,Float> resultMap = new HashMap<>();
        List<Map> resultList = new ArrayList<>();
        List<Float> gapList = new ArrayList<>();
        Map<Float,Float> gapMap = new HashMap<>();
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        // （2）平滑值区间 [1~10]
//        for (double a = 2; a < 10; a++) { 测试应该选取什么平滑指数
            double a = 8;// 选取平滑指数为0.8，此时误差最小
            for (Float realData: realParamList) {
                double smoothParam = a/10;
                System.out.println("平滑指数："+smoothParam+",实际值是："
                        + realData+",上次预测值是："
                        +lastPredictParam+"，误差为："
                        + decimalFormat.format(Math.abs(realData-lastPredictParam)));
                 //将误差值装进list方便统计平均误差
                gapList.add(Math.abs(realData - lastPredictParam));
                lastPredictParam = (float) (smoothParam * realData + (1-smoothParam)*lastPredictParam);
//                // 保留一位小数
                lastPredictParam = Float.parseFloat(decimalFormat.format(lastPredictParam));
                System.out.println("预测下次为："+lastPredictParam);

            }
            // 计算误差的平均值
            double totalGap = 0.0;
            for (Float gap: gapList) {
                totalGap = totalGap + gap;
            }
            System.out.println(gapList.size()+"；"+totalGap);
//            gapMap.put((float)a,(float)totalGap/(float) gapList.size());
//            // 每更换一个平滑值，预估值都要复位
//            lastPredictParam = singleSmoothingEntity.getLastPredictParam();
//            // 清空当前list装的误差值
//            gapList.clear();
//        }
//        System.out.println(gapMap.toString());
//        System.out.println(lastPredictParam);

        return lastPredictParam;
    }
}
