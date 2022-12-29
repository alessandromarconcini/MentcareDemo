package model.repository;

import model.Event;
import model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface EventRepository extends CrudRepository<Event,Long> {
}