package com.example.demolesevents.hexagone.service;

import com.example.demolesevents.hexagon.domain.Event;
import com.example.demolesevents.hexagon.domain.Type;
import com.example.demolesevents.hexagon.exception.BadEventException;
import com.example.demolesevents.hexagon.serverSidePort.ISaveEvent;
import com.example.demolesevents.hexagon.service.EventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EventServiceTest {
    @InjectMocks
    EventService eventService;

    @Mock
    ISaveEvent iSaveEvent;

    @Test
    public void cannotCreateEventInThePast() throws BadEventException {
        LocalDate dateOfEvent = LocalDate.of(2022,06,10);
        Event event = new Event("Devfest Lille 2022", "Kinépolis Lomme", 40.0f, dateOfEvent, Type.CULTURAL);
        assertThrows(BadEventException.class, () -> eventService.create(event));
        verifyNoInteractions(iSaveEvent);
    }

    @Test
    public void charityEventMustNotBePaying() throws BadEventException {
        LocalDate dateOfEvent = LocalDate.of(2022,10,05);
        Event event = new Event("Don du sang", "Saint-Quentin", 10.0f, dateOfEvent, Type.CHARITY);
        assertThrows(BadEventException.class, () -> eventService.create(event));
        verifyNoInteractions(iSaveEvent);
    }

    @Test
    public void createGoodEvent() throws BadEventException {
        LocalDate dateOfEvent = LocalDate.of(2023,06,18);
        Event event = new Event("Devfest Lille 2023", "Kinépolis Lomme", 42.0f, dateOfEvent, Type.CULTURAL);
        doReturn(event).when(iSaveEvent).save(event);

        Event eventReturned = eventService.create(event);

        assertEquals(eventReturned.getTitle(), event.getTitle());
        assertEquals(eventReturned.getLocation(), event.getLocation());
        assertEquals(eventReturned.getPrice(), event.getPrice());
        assertEquals(eventReturned.getMoment(), event.getMoment());
        assertEquals(eventReturned.getType(), event.getType());
        verify(iSaveEvent).save(event);
        verifyNoMoreInteractions(iSaveEvent);

    }
}
