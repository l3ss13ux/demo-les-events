package com.example.demolesevents.hexagon.service;

import com.example.demolesevents.hexagon.domain.Event;
import com.example.demolesevents.hexagon.serverSidePort.ISaveEvent;
import com.example.demolesevents.hexagon.userSidePort.ICreateEvent;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EventService implements ICreateEvent {
    private final ISaveEvent iSaveEvent;

    @Override
    public Event create(Event event) {
        return iSaveEvent.save(event);
    }
}
