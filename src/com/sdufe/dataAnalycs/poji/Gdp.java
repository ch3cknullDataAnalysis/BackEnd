package com.sdufe.dataAnalycs.poji;

public class Gdp {
    private String year;
    private String cityNum;
    private String cityName;
    private float gdpSum;
    private float gdp1;
    private float gdp2;
    private float gdpIndu;
    private float gdpArch;
    private float gdp3;
    private float gdpTrff;
    private float gdpReta;
    private float gdpStay;
    private float gdpEco;
    private float gdpHouse;
    private float gdpOther;
    private float gdp1P;
    private float gdp2p;
    private float gdp3P;
    private float gdpPeoMean;

    public Gdp(String year, String cityNum, String cityName, float gdpSum, float gdp1, float gdp2, float gdpIndu, float gdpArch, float gdp3, float gdpTrff, float gdpReta, float gdpStay, float gdpEco, float gdpHouse, float gdpOther, float gdp1P, float gdp2p, float gdp3P, float gdpPeoMean) {
        this.year = year;
        this.cityNum = cityNum;
        this.cityName = cityName;
        this.gdpSum = gdpSum;
        this.gdp1 = gdp1;
        this.gdp2 = gdp2;
        this.gdpIndu = gdpIndu;
        this.gdpArch = gdpArch;
        this.gdp3 = gdp3;
        this.gdpTrff = gdpTrff;
        this.gdpReta = gdpReta;
        this.gdpStay = gdpStay;
        this.gdpEco = gdpEco;
        this.gdpHouse = gdpHouse;
        this.gdpOther = gdpOther;
        this.gdp1P = gdp1P;
        this.gdp2p = gdp2p;
        this.gdp3P = gdp3P;
        this.gdpPeoMean = gdpPeoMean;
    }

    public Gdp() {
    }

    public float getGdpSum() {
        return gdpSum;
    }

    public void setGdpSum(float gdpSum) {
        this.gdpSum = gdpSum;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCityNum() {
        return cityNum;
    }

    public void setCityNum(String cityNum) {
        this.cityNum = cityNum;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public float getGdp1() {
        return gdp1;
    }

    public void setGdp1(float gdp1) {
        this.gdp1 = gdp1;
    }

    public float getGdp2() {
        return gdp2;
    }

    public void setGdp2(float gdp2) {
        this.gdp2 = gdp2;
    }

    public float getGdpIndu() {
        return gdpIndu;
    }

    public void setGdpIndu(float gdpIndu) {
        this.gdpIndu = gdpIndu;
    }

    public float getGdpArch() {
        return gdpArch;
    }

    public void setGdpArch(float gdpArch) {
        this.gdpArch = gdpArch;
    }

    public float getGdp3() {
        return gdp3;
    }

    public void setGdp3(float gdp3) {
        this.gdp3 = gdp3;
    }

    public float getGdpTrff() {
        return gdpTrff;
    }

    public void setGdpTrff(float gdpTrff) {
        this.gdpTrff = gdpTrff;
    }

    public float getGdpReta() {
        return gdpReta;
    }

    public void setGdpReta(float gdpReta) {
        this.gdpReta = gdpReta;
    }

    public float getGdpStay() {
        return gdpStay;
    }

    public void setGdpStay(float gdpStay) {
        this.gdpStay = gdpStay;
    }

    public float getGdpEco() {
        return gdpEco;
    }

    public void setGdpEco(float gdpEco) {
        this.gdpEco = gdpEco;
    }

    public float getGdpHouse() {
        return gdpHouse;
    }

    public void setGdpHouse(float gdpHouse) {
        this.gdpHouse = gdpHouse;
    }

    public float getGdpOther() {
        return gdpOther;
    }

    public void setGdpOther(float gdpOther) {
        this.gdpOther = gdpOther;
    }

    public float getGdp1P() {
        return gdp1P;
    }

    public void setGdp1P(float gdp1P) {
        this.gdp1P = gdp1P;
    }

    public float getGdp2p() {
        return gdp2p;
    }

    public void setGdp2p(float gdp2p) {
        this.gdp2p = gdp2p;
    }

    public float getGdp3P() {
        return gdp3P;
    }

    public void setGdp3P(float gdp3P) {
        this.gdp3P = gdp3P;
    }

    public float getGdpPeoMean() {
        return gdpPeoMean;
    }

    public void setGdpPeoMean(float gdpPeoMean) {
        this.gdpPeoMean = gdpPeoMean;
    }

    @Override
    public String toString() {
        return "Gdp{" +
                "year='" + year + '\'' +
                ", cityNum='" + cityNum + '\'' +
                ", cityName='" + cityName + '\'' +
                ", gdpSum=" + gdpSum +
                ", gdp1=" + gdp1 +
                ", gdp2=" + gdp2 +
                ", gdpIndu=" + gdpIndu +
                ", gdpArch=" + gdpArch +
                ", gdp3=" + gdp3 +
                ", gdpTrff=" + gdpTrff +
                ", gdpReta=" + gdpReta +
                ", gdpStay=" + gdpStay +
                ", gdpEco=" + gdpEco +
                ", gdpHouse=" + gdpHouse +
                ", gdpOther=" + gdpOther +
                ", gdp1P=" + gdp1P +
                ", gdp2p=" + gdp2p +
                ", gdp3P=" + gdp3P +
                ", gdpPeoMean=" + gdpPeoMean +
                '}';
    }
}
