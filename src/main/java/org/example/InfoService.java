package org.example;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class InfoService {

    private static final Logger LOGGER = Logger.getLogger(InfoService.class.getName());

    private final long startTime;

    public InfoService() {
        this.startTime = System.currentTimeMillis();
    }

    @Cacheable(cacheManager = "applicationCacheManager", cacheNames = "startTime")
    public Long getStartTime() {
        LOGGER.info("Start time request received");

        return this.startTime;
    }

    public Long getUptime() {
        LOGGER.info("Uptime request received");

        return System.currentTimeMillis() - this.startTime;
    }
}