package model.repository;

import model.Patient;
import model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Long, Prescription> {
}