package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Music;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import es.upm.miw.apaw_ep_themes.utils.Constants;

public class MusicDto {

    private String id;

    private String tittle;

    private String gender;

    public MusicDto() {
        //empty for framework
    }

    public MusicDto(String tittle, String gender) {
        this.tittle = tittle;
        this.gender = gender;
    }

    public MusicDto(Music music) {
        this.id = music.getId();
        this.tittle = music.getTitle();
        this.gender = music.getGender();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void validate() {
        if (tittle == null || tittle.isEmpty() || gender == null || gender.isEmpty()) {
            throw new BadRequestException(Constants.INCOMPLETE_DATA_ERROR);
        }
    }

    @Override
    public String toString() {
        return "MusicDto{" +
                "id='" + id + '\'' +
                ", tittle='" + tittle + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}