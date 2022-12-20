package model.repository;

import model.Patient;
import model.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptionistRepository extends JpaRepository<Integer, Receptionist> {
}
