package com.example.demolesevents.hexagon.serverSidePort;

import com.example.demolesevents.hexagon.domain.Event;

public interface ISaveEvent {
    Event save(Event event);
}
