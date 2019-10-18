package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

public class MusicCreateDto {

    private String tittle;
    private String gender;
    private String danceCourseId;

    public MusicCreateDto() {
        // Empty for framework
    }

    public MusicCreateDto(String tittle, String gender, String danceCourseId) {
        this.tittle = tittle;
        this.gender = gender;
        this.danceCourseId = danceCourseId;
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

    public String getDanceCourseId() {
        return danceCourseId;
    }

    public void setDanceCourseId(String danceCourseId) {
        this.danceCourseId = danceCourseId;
    }

    public void validate() {
        if (this.tittle == null || this.tittle.isEmpty() || this.gender == null || this.gender.isEmpty() || this.danceCourseId == null || this.danceCourseId.isEmpty()) {
            throw new BadRequestException("Incomplete Data");
        }
    }

    @Override
    public String toString() {
        return "MusicCreateDto{" +
                "tittle='" + tittle + '\'' +
                ", gender='" + gender + '\'' +
                ", danceCourseId='" + danceCourseId + '\'' +
                '}';
    }
}
