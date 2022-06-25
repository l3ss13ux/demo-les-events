package com.example.demolesevents.infrastructure.serverSide.repository;

import com.example.demolesevents.infrastructure.serverSide.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, UUID> {
    EventEntity save(EventEntity eventEntity);
}
