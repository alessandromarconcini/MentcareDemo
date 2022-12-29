package model.repository;

import model.Message;
import model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface MessageRepository extends CrudRepository<Message,Long> {
}
