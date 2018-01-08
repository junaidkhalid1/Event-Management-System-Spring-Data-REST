package fr.junaid.eventmanagement.entities.projections;

import java.time.Instant;
import java.time.ZonedDateTime;

import org.springframework.data.rest.core.config.Projection;

import fr.junaid.eventmanagement.entities.Event;

@Projection(name = "partial", types = { Event.class })
public interface PartialEventProjection {

	String getName();

	ZonedDateTime getStartTime();

	ZonedDateTime getEndTime();
	
	// To expose hidden field which I hide using @JsonIgnore in a AbstractEntity class
	Instant getCreated();
}
