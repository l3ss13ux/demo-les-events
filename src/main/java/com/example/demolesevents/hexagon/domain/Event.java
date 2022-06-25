package com.example.demolesevents.hexagon.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Event {
    private UUID id;
    private String title;
    private String location;
    private Float price;
}
