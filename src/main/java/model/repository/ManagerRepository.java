package model.repository;

import model.Manager;
import model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Integer, Manager> {
}
