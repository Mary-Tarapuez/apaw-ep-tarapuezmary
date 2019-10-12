package es.upm.miw.apaw_ep_themes.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Opinion {

    @Id
    private String id;

    private String description;

    private Date dateRegister;

    public Opinion(String description, Date dateRegister) {
        this.description = description;
        this.dateRegister = dateRegister;
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

    @Override
    public String toString() {
        return "Opinion{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", dateRegister=" + dateRegister +
                '}';
    }
}
