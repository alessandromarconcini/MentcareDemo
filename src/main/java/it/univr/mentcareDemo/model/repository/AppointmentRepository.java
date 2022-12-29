package it.univr.mentcareDemo.model.repository;

import it.univr.mentcareDemo.model.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment,Long> {
}
