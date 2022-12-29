package model.repository;

import model.Clinic;
import model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ClinicRepository extends CrudRepository<Clinic,Long> {
}
