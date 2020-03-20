package com.curevent.services;

import com.curevent.exceptions.EventNotFoundException;
import com.curevent.models.entities.Event;
import com.curevent.models.entities.Template;
import com.curevent.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event getOneById(UUID id) {
        return eventRepository.findById(id).stream().findAny()
                .orElseThrow(()->new EventNotFoundException(id));
    }


    public Event add(Event event) {
        return eventRepository.save(event);
    }

    public Event update(Event event) {
        getOneById(event.getId());
        return eventRepository.save(event);
    }

    public void delete(UUID id) {
        Event event = getOneById(id);
        eventRepository.delete(event);
    }
}
