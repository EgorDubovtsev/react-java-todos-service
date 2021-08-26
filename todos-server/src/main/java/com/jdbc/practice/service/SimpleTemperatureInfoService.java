package com.jdbc.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.concurrent.Callable;

@Service
public class SimpleTemperatureInfoService implements TemperatureInfoService {
    private static final String DOMEN = "http://localhost:8081";
    @Value("${info.full.temperature.message}")
    private String temperatureMessage;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getFullTemperatureInfo() {
        int todayDayOfMonth = LocalDate.now().getDayOfMonth();

        Callable<String> callableForTemperature = () -> restTemplate.getForObject(DOMEN + "/api/temperature/" + todayDayOfMonth, String.class);
        Callable<String> callableForWeather = () -> restTemplate.getForObject(DOMEN + "/api/weather", String.class);
        Callable<Integer> callableForRainChance = () -> restTemplate.getForObject(DOMEN + "/api/rainChance", Integer.class);


        try {
            return String.format(temperatureMessage,
                    callableForWeather.call(),
                    callableForTemperature.call(),
                    callableForRainChance.call());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "500";
    }
}
