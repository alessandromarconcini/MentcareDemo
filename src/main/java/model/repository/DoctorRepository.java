package model.repository;

import model.Doctor;
import model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Integer, Doctor> {
}