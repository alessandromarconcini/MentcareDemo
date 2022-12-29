package model.repository;

import model.Nurse;
import model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface NurseRepository extends CrudRepository<Nurse,Long> {
}
