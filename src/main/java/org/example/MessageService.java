package org.example;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class MessageService {

    private static final Logger LOGGER = Logger.getLogger(MessageService.class.getName());

    @Cacheable(cacheManager = "requestCacheManager", cacheNames = "message")
    public String transform(final String message) {
        LOGGER.info("Transform message request received");

        return message.toUpperCase();
    }
}