package it.univr.mentcareDemo.model.repository;

import it.univr.mentcareDemo.model.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Long> {

    public Optional<Doctor> findByName(String name);


}