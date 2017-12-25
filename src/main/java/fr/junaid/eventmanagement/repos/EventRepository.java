package fr.junaid.eventmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import fr.junaid.eventmanagement.entities.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}
