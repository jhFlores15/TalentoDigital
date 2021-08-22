package com.johfloresm.eventos.services;

import com.johfloresm.eventos.models.Event;
import com.johfloresm.eventos.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService{
    @Autowired
    EventRepository eventRepository;

    public List<Event> getEventsByStateId(Long id){
        return eventRepository.getEventsByStateId(id);
    }

    public Event getEventById(Long id){
        return eventRepository.findById(id).orElse(null);
    }

    public List<Event> getEventsByNotStateId(Long id){
        return eventRepository.getEventsByNotStateId(id);
    }

    public Event saveEvent(Event e){
        return eventRepository.save(e);
    }

}
