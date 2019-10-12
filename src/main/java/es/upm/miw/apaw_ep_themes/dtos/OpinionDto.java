package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Opinion;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import es.upm.miw.apaw_ep_themes.utils.Constants;

import java.util.Date;

public class OpinionDto {

    private String id;

    private String description;

    private Date dateRegister;

    public OpinionDto() {
        // empty for framework
    }

    public OpinionDto(String description, Date dateRegister) {
        this.description = description;
        this.dateRegister = dateRegister;
    }

    public OpinionDto(Opinion opinion) {
        this.id = opinion.getId();
        this.description = opinion.getDescription();
        this.dateRegister = opinion.getDateRegister();
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

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public void validate(){
        if(description == null || description.isEmpty() || dateRegister == null){
            throw new BadRequestException(Constants.INCOMPLETE_DATA_ERROR);
        }
    }

    @Override
    public String toString() {
        return "OpinionDto{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", dateRegister=" + dateRegister +
                '}';
    }
}
