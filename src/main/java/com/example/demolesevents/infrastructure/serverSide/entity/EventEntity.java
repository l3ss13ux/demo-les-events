package com.example.demolesevents.infrastructure.serverSide.entity;

import com.example.demolesevents.hexagon.domain.Event;
import com.example.demolesevents.hexagon.domain.Type;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "events")
@NoArgsConstructor
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column
    private String title;
    @Column
    private String location;
    @Column
    private Float price;
    @Column
    private LocalDate moment;
    @Column
    private String type;
    @Column
    @CreationTimestamp
    private LocalDate creation;

    public EventEntity(Event event) {
        this.id = event.getId();
        this.title = event.getTitle();
        this.location = event.getLocation();
        this.price = event.getPrice();
        this.moment = event.getMoment();
        this.type = event.getType().name();
    }

    public Event toDomain() {
        return new Event(this.id, this.title, this.location, this.price, this.moment, Type.valueOf(type));
    }
}
