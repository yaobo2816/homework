package com.neo.model;

import java.util.List;
import java.util.Map;

public class HourlyForecast {
    private Map cond;
    private String weather;
    private String date;
    private String chinaDate;
    private String displayChinaDate;
    private String hum;
    private String pop;
    private String pres;
    private Map wind;
    private String speed;
    private String tmp;
    private String city;

    public String getDisplayChinaDate() {
        return displayChinaDate;
    }

    public void setDisplayChinaDate(String displayChinaDate) {
        this.displayChinaDate = displayChinaDate;
    }

    public String getChinaDate() {
        return chinaDate;
    }

    public void setChinaDate(String chinaDate) {
        this.chinaDate = chinaDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getPres() {
        return pres;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    public Map getCond() {
        return cond;
    }

    public void setCond(Map cond) {
        this.cond = cond;
    }

    public Map getWind() {
        return wind;
    }

    public void setWind(Map wind) {
        this.wind = wind;
    }
}
