package es.upm.miw.apaw_ep_themes.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
public class DanceCourse {

    @Id
    private String id;

    private String description;

    private Date startDate;

    private Date dueDate;

    private Boolean stateCourse;

    private Room room;

    private List<Participant> participant;

    public DanceCourse(String description, Date startDate, Date dueDate, Boolean stateCourse, Room room) {
        this.description = description;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.stateCourse = stateCourse;
        this.room = room;
        this.participant = new ArrayList<>();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getStateCourse() {
        return stateCourse;
    }

    public void setStateCourse(Boolean stateCourse) {
        this.stateCourse = stateCourse;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "DanceCourse{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", dueDate=" + dueDate +
                ", stateCourse=" + stateCourse +
                ", room=" + room +
                '}';
    }
}
