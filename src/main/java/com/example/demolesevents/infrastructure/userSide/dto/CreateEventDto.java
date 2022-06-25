package com.example.demolesevents.infrastructure.userSide.dto;

import com.example.demolesevents.hexagon.domain.Event;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEventDto {
    private String title;
    private String location;
    private Float price;

    public Event toDomain() {
        Event event = new Event();
        event.setTitle(title);
        event.setLocation(location);
        event.setPrice(price);
        return event;
    }
}
