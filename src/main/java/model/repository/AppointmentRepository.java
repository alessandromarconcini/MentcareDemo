package model.repository;

import model.Appointment;
import model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Long, Appointment> {
}
