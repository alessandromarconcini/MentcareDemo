package model.repository;

import model.Message;
import model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Long, Message> {
}
