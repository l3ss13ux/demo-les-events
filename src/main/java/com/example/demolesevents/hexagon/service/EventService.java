package com.example.demolesevents.hexagon.service;

import com.example.demolesevents.hexagon.domain.Event;
import com.example.demolesevents.hexagon.domain.Type;
import com.example.demolesevents.hexagon.exception.BadEventException;
import com.example.demolesevents.hexagon.serverSidePort.ISaveEvent;
import com.example.demolesevents.hexagon.userSidePort.ICreateEvent;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class EventService implements ICreateEvent {
    private final ISaveEvent iSaveEvent;

    @Override
    public Event create(Event event) throws BadEventException {
        // 1ere règle métier : la date de l'event doit être dans le futur
        if (!event.getMoment().isAfter(LocalDate.now())) {
            throw  new BadEventException();
        }

        // 2ème règle métier : si le type est CARITATIF, le prix doit être à 0
        if (event.getType() == Type.CHARITY && event.getPrice() != 0) {
            throw  new BadEventException();
        }

        return iSaveEvent.save(event);
    }
}
