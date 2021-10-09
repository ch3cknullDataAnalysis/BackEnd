package com.sdufe.dataAnalycs.web;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.sdufe.dataAnalycs.poji.Gdp;
import com.sdufe.dataAnalycs.poji.JsonObJ;
import com.sdufe.dataAnalycs.poji.JsonObj1;
import com.sdufe.dataAnalycs.poji.JsonObjSub;
import com.sdufe.dataAnalycs.service.impl.DataAnalycsServiceImp;
import com.sdufe.dataAnalycs.service.impl.DataPredictServiceImp;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataAnalycs extends ActionSupport {

    InputStream inputStream;
    public InputStream getInputStream() {
        return inputStream;
    }

    /**
     * 做数据分析
     * @return 返回要求的原数据，和经过分析后的数据
     */
    public String getdataAnalycs() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, UnsupportedEncodingException {
        // 接收数据
        HttpServletRequest request = ServletActionContext.getRequest();
        String key = request.getParameter("key").toString();
        String allCityNum = request.getParameter("cityNum").toString();
        String []cityNums = allCityNum.split(",");

//        // 测试用数据
//        String key = "gdpSum";
//        String allCityNum = "110000,120000";
//        String []cityNums = allCityNum.split(",");
        // 创建要回传的Json对象
        JsonObJ jsonObJ = new JsonObJ(0,"",key,cityNums.length);
        JsonObjSub []jsonObjSubs = new JsonObjSub[cityNums.length];

        // 调用service层服务
        for (int k=0;k<cityNums.length;++k) {
            String cityNum = cityNums[k];
            DataAnalycsServiceImp dataAnalycsServiceImp = null;
            try {
                dataAnalycsServiceImp = new DataAnalycsServiceImp(key, cityNum);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            // 得到原始信息
            List<Gdp> gdpList = dataAnalycsServiceImp.getAllData();
            // 得到统计信息
            float max = dataAnalycsServiceImp.getMax();
            float min = dataAnalycsServiceImp.getMin();
            float sum = dataAnalycsServiceImp.getSum();
            float mean = dataAnalycsServiceImp.getMean();
            float medi = dataAnalycsServiceImp.getMedi();

            // 封装JsonObjSub数据到Json对象中的data数组中
            JsonObjSub jsonObjSub = new JsonObjSub();
            jsonObjSub.setCityName(gdpList.get(0).getCityName());
            float[][] raw = new float[2][gdpList.size()];// 元数据
            for (int i = 0; i < raw[0].length; ++i) {
                raw[0][i] = Float.parseFloat(gdpList.get(i).getYear());
                char[] chars = key.toCharArray();
                if (chars[0] > 'a' && chars[0] < 'z') chars[0] = (char) (chars[0] - 32);
                key = new String(chars);
                Method method = Gdp.class.getMethod("get" + key);
                raw[1][i] = (float) method.invoke(gdpList.get(i));
            }
            jsonObjSub.setRaw(raw);
            Map<String, Float> stat = new HashMap<String, Float>();// 统计数据
            stat.put("max", max);
            stat.put("min", min);
            stat.put("sum", sum);
            stat.put("mean", mean);
            stat.put("medi", medi);
            jsonObjSub.setStat(stat);
            jsonObjSubs[k] = jsonObjSub;
        }
        jsonObJ.setData(jsonObjSubs);
        // 封装为json字符串并返回给前端
        Gson gson = new Gson();
        String gsonString = gson.toJson(jsonObJ);
        System.out.println(gsonString);// test
        inputStream = new ByteArrayInputStream(gsonString.getBytes("UTF-8"));
        return "ok";
    }

    /**
     * 得到数据预测的结果
     * @return
     */
    public String getDataPredict() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, UnsupportedEncodingException {
        // 接收数据
        HttpServletRequest request = ServletActionContext.getRequest();
        String key = request.getParameter("key").toString();
        String cityNum = request.getParameter("cityNum").toString();
//        String key = "gdpSum";
//        String cityNum = "110000";

        // 调用service层服务
        DataPredictServiceImp dataPredictServiceImp = new DataPredictServiceImp();
        float dataPredictResu = dataPredictServiceImp.getDataPredict(cityNum, key);

        // 回传结果给前端
        JsonObj1 jsonObj1 = new JsonObj1(0,"",dataPredictResu);
        Gson gson = new Gson();
        String gsonString = gson.toJson(jsonObj1);
        System.out.println(gsonString);// test
        inputStream = new ByteArrayInputStream(gsonString.getBytes("UTF-8"));
        return "okk";
    }
}
