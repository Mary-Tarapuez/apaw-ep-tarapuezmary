package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import es.upm.miw.apaw_ep_themes.utils.Constants;

import java.util.Date;

public class DanceCourseCreationDto {

    private String description;

    private Date startDate;

    private Date dueDate;

    private Boolean stateCourse;

    private int number;

    private int floor;

    public DanceCourseCreationDto() {
        // Empty for framework
    }

    public DanceCourseCreationDto(String description, Date startDate, Date dueDate, Boolean stateCourse, int number, int floor) {
        this.description = description;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.stateCourse = stateCourse;
        this.number = number;
        this.floor = floor;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void validate() {
        if (this.description == null || this.description.isEmpty() || this.startDate == null || this.dueDate == null || this.stateCourse == null || this.number == 0 || this.floor == 0) {
            throw new BadRequestException(Constants.INCOMPLETE_DATA_ERROR);
        }
    }

    @Override
    public String toString() {
        return "DanceCourseCreationDto{" +
                "description='" + description + '\'' +
                ", startDate=" + startDate +
                ", dueDate=" + dueDate +
                ", stateCourse=" + stateCourse +
                ", number=" + number +
                ", floor=" + floor +
                '}';
    }
}
