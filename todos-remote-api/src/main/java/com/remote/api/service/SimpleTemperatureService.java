package com.remote.api.service;

import com.remote.api.dao.TemperatureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleTemperatureService implements TemperatureService {
    @Autowired
    private TemperatureDao temperatureDao;

    @Override
    public String getTemperatureByDay(int dayInMonth) {
        return temperatureDao.getTemperature(dayInMonth);
    }
}
