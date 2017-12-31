package fr.junaid.eventmanagement.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import fr.junaid.eventmanagement.entities.Participant;

//public interface ParticipantRepository extends CrudRepository<Participant, Long> {
public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long> {

}
