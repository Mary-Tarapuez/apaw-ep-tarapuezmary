package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.DanceCourse;

import java.util.Date;

public class DanceCourseDto {

    private String id;

    private String description;

    private Date startDate;

    private Date dueDate;

    private Boolean stateCourse;

    public DanceCourseDto() {
        // Empty for framework
    }

    public DanceCourseDto(DanceCourse danceCourse) {
        this.description = danceCourse.getDescription();
        this.startDate = danceCourse.getStartDate();
        this.dueDate = danceCourse.getDueDate();
        this.stateCourse = danceCourse.getStateCourse();
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

    @Override
    public String toString() {
        return "DanceCourseDto{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", dueDate=" + dueDate +
                ", stateCourse=" + stateCourse +
                '}';
    }
}
