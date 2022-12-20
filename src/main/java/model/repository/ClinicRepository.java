package model.repository;

import model.Clinic;
import model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Long, Clinic> {
}
