package it.univr.mentcareDemo.model.repository;

import it.univr.mentcareDemo.model.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends CrudRepository<Report,Long> {
}
