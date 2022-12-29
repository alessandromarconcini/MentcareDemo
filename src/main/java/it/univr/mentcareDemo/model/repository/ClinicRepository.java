package it.univr.mentcareDemo.model.repository;

import it.univr.mentcareDemo.model.Clinic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends CrudRepository<Clinic,Long> {
}
