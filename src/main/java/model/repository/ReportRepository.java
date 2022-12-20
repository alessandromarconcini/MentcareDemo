package model.repository;

import model.Patient;
import model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Long, Report> {
}
