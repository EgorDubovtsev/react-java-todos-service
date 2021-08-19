package com.remote.api.service;

import com.remote.api.util.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class SimpleWeatherService implements WeatherService {
    @Autowired
    private Random random;

    @Override
    public Weather getTodayWeather() {
        int weatherId = random.nextInt(Weather.values().length);

        return Arrays.stream(Weather.values()).collect(Collectors.toList()).get(weatherId);
    }
}
