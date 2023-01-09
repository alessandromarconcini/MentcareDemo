package it.univr.mentcareDemo.model.repository;

import it.univr.mentcareDemo.model.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.Month;

@Repository
public interface ReportRepository extends CrudRepository<Report,Long> {

}
