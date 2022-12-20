package model.repository;

import model.Drug;
import model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRepository extends JpaRepository<Long, Drug> {
}
