package com.example.demolesevents.hexagon.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class Event {
    private UUID id;
    private String title;
    private String location;
    private Float price;
    private LocalDate moment;
    private Type type;

    public Event(String title, String location, Float price, LocalDate moment, Type type) {
        this.title = title;
        this.location = location;
        this.price = price;
        this.moment = moment;
        this.type = type;
    }

    public Event(UUID id, String title, String location, Float price, LocalDate moment, Type type) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.price = price;
        this.moment = moment;
        this.type = type;
    }
}
