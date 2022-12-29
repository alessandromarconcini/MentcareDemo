package it.univr.mentcareDemo.model.repository;

import it.univr.mentcareDemo.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message,Long> {
}
