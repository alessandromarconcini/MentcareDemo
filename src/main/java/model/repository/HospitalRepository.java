package model.repository;

import model.Hospital;
import model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Long, Hospital> {
}