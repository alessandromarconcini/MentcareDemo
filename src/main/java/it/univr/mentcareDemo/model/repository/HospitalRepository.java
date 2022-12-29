package it.univr.mentcareDemo.model.repository;

import it.univr.mentcareDemo.model.Hospital;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital,Long> {
}