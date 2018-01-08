package fr.junaid.eventmanagement.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import fr.junaid.eventmanagement.entities.Event;
import fr.junaid.eventmanagement.entities.projections.PartialEventProjection;

import java.lang.String;
import java.time.ZoneId;
import java.util.List;

//public interface EventRepository extends CrudRepository<Event, Long> {

//To apply PartialEventProjection on collection of resources need below annotation, here collections of events. We need this, if using Excerpts
@RepositoryRestResource(excerptProjection=PartialEventProjection.class) 
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
	
	// List<Event> findByName(@Param("name") String name); // Custome finder method to search Event by Name
	Page<Event> findByName(@Param("name") String name, Pageable pageable); // Paging Support added

	Page<Event> findByNameAndZoneId(@Param("name") String name, @Param("zoneId") ZoneId zoneId, Pageable pageable);// Find By multiple Parameters

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void delete(Long id);
}
