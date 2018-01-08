package fr.junaid.eventmanagement.entities.projections;

import org.springframework.data.rest.core.config.Projection;

import fr.junaid.eventmanagement.entities.Participant;

@Projection(name="participantPartial", types = { Participant.class })
public interface PartialParticipantProjection {

	String getName();
	
	Boolean getCheckedIn();
	
}
