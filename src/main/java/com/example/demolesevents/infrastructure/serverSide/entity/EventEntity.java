package com.example.demolesevents.infrastructure.serverSide.entity;

import com.example.demolesevents.hexagon.domain.Event;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
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
    @CreationTimestamp
    private Date creation;

    public EventEntity(Event event) {
        this.id = event.getId();
        this.title = event.getTitle();
        this.location = event.getLocation();
        this.price = event.getPrice();
    }

    public Event toDomain() {
        Event event = new Event();
        event.setId(this.id);
        event.setTitle(this.title);
        event.setLocation(this.location);
        event.setPrice(this.price);
        return event;
    }
}
