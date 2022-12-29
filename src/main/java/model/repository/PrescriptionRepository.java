package model.repository;

import model.Patient;
import model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface PrescriptionRepository extends CrudRepository<Prescription,Long> {
}