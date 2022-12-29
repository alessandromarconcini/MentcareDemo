package it.univr.mentcareDemo.model.repository;

import it.univr.mentcareDemo.model.Nurse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends CrudRepository<Nurse,Long> {
}
