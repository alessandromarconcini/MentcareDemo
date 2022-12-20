package model.repository;

import model.Nurse;
import model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepository extends JpaRepository<Integer, Nurse> {
}
