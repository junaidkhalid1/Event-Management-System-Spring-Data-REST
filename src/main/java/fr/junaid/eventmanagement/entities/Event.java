package fr.junaid.eventmanagement.entities;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"resouceId"}) // It tell Jackson converter I want the resourceId to be very first
@Entity
public class Event extends AbstractEntity {

	private String name;
	@JsonProperty("desc") // To customize the name in Json Response
	private String description;
	private ZonedDateTime startTime;
	private ZonedDateTime endTime;
	private ZoneId zoneId;
	private Boolean started;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=false)
	private Organizer organizer;
	
	@OneToMany(mappedBy="event", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true) // orphanRemoval: if no link remains delete them
	private Set<Participant> participants;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@RestResource(exported=false)
	private Venue venue;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ZonedDateTime getStartTime() {
		return startTime;
	}
	
	public void setStartTime(ZonedDateTime startTime) {
		this.startTime = startTime;
	}
	
	public ZonedDateTime getEndTime() {
		return endTime;
	}
	
	public void setEndTime(ZonedDateTime endTime) {
		this.endTime = endTime;
	}
	
	public ZoneId getZoneId() {
		return zoneId;
	}
	
	public void setZoneId(ZoneId zoneId) {
		this.zoneId = zoneId;
	}
	
	public Boolean getStarted() {
		return started;
	}
	
	public void setStarted(Boolean started) {
		this.started = started;
	}

	public Organizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public Set<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	
	// To expose id
	public Long getResouceId() {
		return this.id;
	}
	
	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Event) obj).id );
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
