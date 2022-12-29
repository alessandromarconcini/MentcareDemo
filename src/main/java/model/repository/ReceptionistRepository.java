package model.repository;

import model.Patient;
import model.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ReceptionistRepository extends CrudRepository<Receptionist,Long> {
}
