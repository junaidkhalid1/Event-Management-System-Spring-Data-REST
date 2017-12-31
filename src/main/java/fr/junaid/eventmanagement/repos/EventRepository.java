package fr.junaid.eventmanagement.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import fr.junaid.eventmanagement.entities.Event;

//public interface EventRepository extends CrudRepository<Event, Long> {
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

}
