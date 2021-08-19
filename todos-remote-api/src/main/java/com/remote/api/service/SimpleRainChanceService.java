package com.remote.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SimpleRainChanceService implements RainChanceService {
    @Autowired
    private Random random;

    @Override
    public int getRainChance() {
        return random.nextInt(100);
    }
}
