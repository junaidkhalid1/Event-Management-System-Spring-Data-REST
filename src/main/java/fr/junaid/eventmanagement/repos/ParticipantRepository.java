package fr.junaid.eventmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import fr.junaid.eventmanagement.entities.Participant;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {

}
