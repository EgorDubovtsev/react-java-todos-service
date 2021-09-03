package com.remote.api.controller;

import com.remote.api.service.RainChanceService;
import com.remote.api.service.TemperatureService;
import com.remote.api.service.WeatherService;
import com.remote.api.util.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    @Autowired
    private TemperatureService temperatureService;
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private RainChanceService rainChanceService;

    @GetMapping("/api/temperature/{dayInMonth}")
    public String getTemperatureByDay(@PathVariable String dayInMonth) {

        return temperatureService.getTemperatureByDay(Integer.parseInt(dayInMonth));
    }

    @GetMapping("/api/weather")
    public String getTodayWeather() {
        Weather weather = weatherService.getTodayWeather();

        return weather.name();
    }

    @GetMapping("/api/rainChance")
    public Integer getRainChanceInPercents() {

        return rainChanceService.getRainChance();
    }
}
