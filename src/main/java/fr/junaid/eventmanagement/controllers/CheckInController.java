package fr.junaid.eventmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.junaid.eventmanagement.controllers.exceptions.AlreadyCheckedInException;
import fr.junaid.eventmanagement.controllers.exceptions.NotCheckInException;
import fr.junaid.eventmanagement.entities.Participant;
import fr.junaid.eventmanagement.repos.ParticipantRepository;

@RepositoryRestController
@RequestMapping("/events")
public class CheckInController {
	
	@Autowired
	private ParticipantRepository participantRepository;
	
	@PostMapping("/checkin/{id}")
	public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id , PersistentEntityResourceAssembler assembler) {
		
		Participant participant = participantRepository.findOne(id);
		
		if(participant != null) {
			if(participant.getCheckedIn()) {
				throw new AlreadyCheckedInException();
			}
			participant.setCheckedIn(true);
			participantRepository.save(participant);
		}
		
		return ResponseEntity.ok(assembler.toResource(participant));
	}
	
	@PostMapping("/checkout/{id}")
	public ResponseEntity<PersistentEntityResource> checkOut(@PathVariable Long id , PersistentEntityResourceAssembler assembler) {
		
		Participant participant = participantRepository.findOne(id);
		
		if(participant != null) {
			if(!participant.getCheckedIn()) {
				throw new NotCheckInException();
			}
			participant.setCheckedIn(false);
			participantRepository.save(participant);
		}
		
		return ResponseEntity.ok(assembler.toResource(participant));
	}

}
