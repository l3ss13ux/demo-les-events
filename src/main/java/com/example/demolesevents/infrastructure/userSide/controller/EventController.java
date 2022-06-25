package com.example.demolesevents.infrastructure.userSide.controller;

import com.example.demolesevents.hexagon.domain.Event;
import com.example.demolesevents.hexagon.userSidePort.ICreateEvent;
import com.example.demolesevents.infrastructure.userSide.dto.CreateEventDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/events")
public class EventController {
    private ICreateEvent iCreateEvent;

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody  CreateEventDto createEventDto) {
        return ResponseEntity.ok(iCreateEvent.create(createEventDto.toDomain()));
    }
}
