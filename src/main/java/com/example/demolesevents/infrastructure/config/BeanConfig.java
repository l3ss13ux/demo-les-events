package com.example.demolesevents.infrastructure.config;

import com.example.demolesevents.hexagon.serverSidePort.ISaveEvent;
import com.example.demolesevents.hexagon.service.EventService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public EventService iCreateEvent(ISaveEvent iSaveEvent) {
        return new EventService(iSaveEvent);
    }
}
