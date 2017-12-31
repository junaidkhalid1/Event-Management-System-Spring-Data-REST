package fr.junaid.eventmanagement.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import fr.junaid.eventmanagement.entities.Venue;

//public interface VenueRepository extends CrudRepository<Venue, Long> {
public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {

}
