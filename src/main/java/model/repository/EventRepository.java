package model.repository;

import model.Event;
import model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Long, Event> {
}