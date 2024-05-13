package org.launchcode.codingevents.models;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by Chris Bay
 */
public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotBlank(message = "Location cannotbe left blank.")
    private String location;

    @AssertTrue(message = "Attendee must register for the event")
    private boolean registrationRequired;

    @Positive(message="Number of attendees must be one or more.")
    private  int numberOfAttendees;

    @NotNull(message = "Start time must not be null")
    private LocalDateTime startTimeOfEvent;



//    public Event(String name, String description, String contactEmail) {
//        this();
//        this.name = name;
//        this.description = description;
//        this.contactEmail = contactEmail;
//    }


    public Event(String name, String description, String contactEmail, String location, boolean registrationRequired, int numberOfAttendees, LocalDateTime startTimeOfEvent) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.registrationRequired = registrationRequired;
        this.numberOfAttendees = numberOfAttendees;
        this.startTimeOfEvent = startTimeOfEvent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isRegistrationRequired() {
        return registrationRequired;
    }

    public void setRegistrationRequired(boolean registrationRequired) {
        this.registrationRequired = registrationRequired;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public LocalDateTime getStartTimeOfEvent() {
        return startTimeOfEvent;
    }

    public void setStartTimeOfEvent(LocalDateTime startTimeOfEvent) {
        this.startTimeOfEvent = startTimeOfEvent;
    }

    public Event() {
        this.id = nextId;
        nextId++;
    }
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

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
