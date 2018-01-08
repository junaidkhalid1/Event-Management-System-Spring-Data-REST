package fr.junaid.eventmanagement.entities.projections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import fr.junaid.eventmanagement.entities.Venue;

// To combine two fields and expose them as one
@Projection(name = "virtual", types = { Venue.class })
public interface StreetAddressProjection {
	
	@Value("#{target.streetAddress} #{target.streetAddress2}") // target here is the Venue class
	String getCompleteStreetAddress();
}
