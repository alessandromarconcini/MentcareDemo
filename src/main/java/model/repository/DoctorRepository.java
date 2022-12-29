package model.repository;

import model.Doctor;
import model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface DoctorRepository extends CrudRepository<Doctor,Long> {
}