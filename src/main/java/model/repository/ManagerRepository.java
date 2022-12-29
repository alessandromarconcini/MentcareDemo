package model.repository;

import model.Manager;
import model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ManagerRepository extends CrudRepository<Manager,Long> {
}
