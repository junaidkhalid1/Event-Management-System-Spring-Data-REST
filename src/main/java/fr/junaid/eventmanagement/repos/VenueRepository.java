package fr.junaid.eventmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import fr.junaid.eventmanagement.entities.Venue;

public interface VenueRepository extends CrudRepository<Venue, Long> {

}
