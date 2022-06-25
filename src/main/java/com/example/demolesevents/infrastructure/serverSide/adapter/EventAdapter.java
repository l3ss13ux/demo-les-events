package com.example.demolesevents.infrastructure.serverSide.adapter;

import com.example.demolesevents.hexagon.domain.Event;
import com.example.demolesevents.hexagon.serverSidePort.ISaveEvent;
import com.example.demolesevents.infrastructure.serverSide.entity.EventEntity;
import com.example.demolesevents.infrastructure.serverSide.repository.EventRepository;
import org.springframework.stereotype.Component;

@Component
public class EventAdapter implements ISaveEvent {
    private EventRepository eventRepository;

    @Override
    public Event save(Event event) {
        return eventRepository.save(new EventEntity(event)).toDomain();
    }
}
