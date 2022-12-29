package it.univr.mentcareDemo.model.repository;

import it.univr.mentcareDemo.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event,Long> {
}