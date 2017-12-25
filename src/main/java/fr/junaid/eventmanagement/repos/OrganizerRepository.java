package fr.junaid.eventmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import fr.junaid.eventmanagement.entities.Organizer;

public interface OrganizerRepository extends CrudRepository<Organizer, Long> {

}
