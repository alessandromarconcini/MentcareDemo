package model.repository;

import model.Hospital;
import model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface HospitalRepository extends CrudRepository<Hospital,Long> {
}