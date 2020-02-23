package com.neo.model;

import java.util.List;

public class HeWeather5 {
    private Object basic;
    private List<HourlyForecast> hourly_forecast;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getBasic() {
        return basic;
    }

    public void setBasic(Object basic) {
        this.basic = basic;
    }

    public List<HourlyForecast> getHourly_forecast() {
        return hourly_forecast;
    }

    public void setHourly_forecast(List<HourlyForecast> hourly_forecast) {
        this.hourly_forecast = hourly_forecast;
    }
}
