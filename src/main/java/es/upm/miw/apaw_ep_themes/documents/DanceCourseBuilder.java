package es.upm.miw.apaw_ep_themes.documents;

import java.util.Date;

public class DanceCourseBuilder {

    private String description;

    private Date startDate;

    private Date dueDate;

    private Boolean stateCourse;

    private Room room;

    public DanceCourseBuilder setDescription(String description){
        this.description = description;
        return this;
    }

    public DanceCourseBuilder setStarDate(Date starDate){
        this.startDate = starDate;
        return this;
    }

    public DanceCourseBuilder setDueDate(Date dueDate){
        this.dueDate = dueDate;
        return this;
    }

    public DanceCourseBuilder setStateCourse(Boolean stateCourse){
        this.stateCourse = stateCourse;
        return this;
    }

    public DanceCourseBuilder setRoom(Room room){
        this.room = room;
        return this;
    }

    public DanceCourse build(){
        return new DanceCourse(description, startDate, dueDate, stateCourse, room);
    }
}
