package com.example.demolesevents.infrastructure.userSide.dto;

import com.example.demolesevents.hexagon.domain.Event;
import com.example.demolesevents.hexagon.domain.Type;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateEventDto {
    private String title;
    private String location;
    private Float price;
    private LocalDate moment;
    private Type type;

    public Event toDomain() {
        return new Event(title, location, price, moment, type);
    }
}
