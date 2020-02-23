package com.neo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Weather {
    @JsonProperty(value = "HeWeather5")
    List<HeWeather5> heWeather5;

    public List<HeWeather5> getHeWeather5() {
        return heWeather5;
    }

    public void setHeWeather5(List<HeWeather5> heWeather5) {
        this.heWeather5 = heWeather5;
    }
}
