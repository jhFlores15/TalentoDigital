package com.johfloresm.eventos.repositories;

import com.johfloresm.eventos.models.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event,Long>{

    @Query("select e from Event e join e.location l join l.state s where s.id = ?1")
    List<Event> getEventsByStateId(Long id);

    @Query("select e from Event e join e.location l join l.state s where s.id <> ?1")
    List<Event> getEventsByNotStateId(Long id);
}
