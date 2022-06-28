package com.example.demolesevents.hexagon.userSidePort;

import com.example.demolesevents.hexagon.domain.Event;
import com.example.demolesevents.hexagon.exception.BadEventException;

public interface ICreateEvent {
    Event create(Event event) throws BadEventException;
}
