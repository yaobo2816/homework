package com.neo.repository;

import com.neo.model.HourlyForecast;
import com.neo.model.WeatherResponse;

import java.util.List;

public interface WeatherDataService {
    HourlyForecast getDataByCityName(String cityName);
}
