package fr.junaid.eventmanagement.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import fr.junaid.eventmanagement.entities.Organizer;

//public interface OrganizerRepository extends CrudRepository<Organizer, Long> {
public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long> {

}
