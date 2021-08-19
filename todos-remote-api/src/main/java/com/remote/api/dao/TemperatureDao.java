package com.remote.api.dao;

import com.remote.api.mapper.TemperatureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TemperatureDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TemperatureMapper temperatureMapper;

    public String getTemperature(int dayInMonth) {
        String getTemperatureByDayQuery = "SELECT * FROM temperature_for_every_day WHERE day = ?";

        try {
            return jdbcTemplate.queryForObject(getTemperatureByDayQuery, temperatureMapper, dayInMonth);

        } catch (EmptyResultDataAccessException ex) {
            ex.printStackTrace();

            return "404";
        }

    }

}
