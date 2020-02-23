package com.neo.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neo.until.Until;
import com.neo.model.HourlyForecast;
import com.neo.model.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Configuration
@EnableScheduling
public class WeatherDataServiceImpl implements WeatherDataService {
    @Autowired
    private RestTemplate restTemplate;
    private static final Logger log =
            LoggerFactory.getLogger(WeatherDataServiceImpl.class);
    private final String WEATHER_API = "https://way.jd.com/he/hourly?lang=en&appkey=2a624ff2758abe5fc9f6d792c118fd46";
    //mockup Cache
    Map<String, List<HourlyForecast>> cashMap = new HashMap<>();
    private final String DEGREE = " °C";
    private final String KEY = "txt";
    private final String SPEEDKEY = "spd";
    private final String UNIT = "km/h";

    /**
     * get weather data
     *
     * @param city
     * @return
     */
    public HourlyForecast getDataByCityName(String city) {
        String uri = WEATHER_API + "&city=" + city;
        log.info("uri :{}", uri);
        return this.doGetWeatherData(uri, city);
    }

    /**
     * each 20 mins to clear Cache
     */
    @Scheduled(cron = "0 0/20 * * * ?")
    private void configureTasks() {
        cashMap.clear();
        log.info("Clear Cache ,Time :{}" ,LocalDateTime.now());
    }

    /**
     * invoke weather api
     * @param uri
     * @param city
     * @return
     */
    private HourlyForecast doGetWeatherData(String uri,String city){
        ObjectMapper mapper = new ObjectMapper();
        HourlyForecast obj = new HourlyForecast();
        WeatherResponse weatherResponse = null;
        String strBody = "";
        String cashKey = city+"@"+ LocalDate.now();
        //check exist  from cache
        if(cashMap.containsKey(cashKey)){
            List<HourlyForecast> hfList = cashMap.get(cashKey);
            obj = filterTime(hfList,obj);
            log.info("get data from Cache , Key :{}" ,cashKey);
            return obj;
        }
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        if(response.getStatusCodeValue()==200){
            strBody = response.getBody();
            log.info("body:{}",strBody);
        }
        try {
            weatherResponse = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        if (StringUtils.isEmpty(weatherResponse)) {
            return obj;
        }
        List<HourlyForecast> hfList = weatherResponse.getResult().getHeWeather5().get(0).getHourly_forecast();
        hfList.stream().peek(item -> {
            if (StringUtils.isEmpty(item)) {
                return;
            }
            try {
                item.setWeather(item.getCond().get(KEY).toString());
                item.setSpeed(Until.append(item.getWind().get(SPEEDKEY).toString(), UNIT));
                item.setTmp(Until.append(item.getTmp(), DEGREE));
                item.setChinaDate(Until.changeHour(item.getDate()));
                item.setDisplayChinaDate(Until.formatDate(item.getChinaDate()));
                item.setCity(city);
            } catch (Exception e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }

        }).collect(Collectors.toList());
        cashMap.put(cashKey,hfList);
        obj = filterTime(hfList,obj);
        return obj;
    }

    /**
     * filter time from list
     * @param hfList
     * @param obj
     * @return
     */
    private HourlyForecast filterTime(List<HourlyForecast> hfList ,HourlyForecast obj){
        obj = hfList.get(0);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:00");
        String createTime = dateTimeFormatter.format( LocalDateTime.now());
        for(HourlyForecast item :hfList){
            if(item.getChinaDate().trim().equals(createTime)){
                obj = item;
                break;
            }
        }
        return obj;
    }
}
