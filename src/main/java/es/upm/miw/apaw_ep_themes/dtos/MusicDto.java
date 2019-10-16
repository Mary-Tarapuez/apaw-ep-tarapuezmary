package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Music;

public class MusicDto {

    private String id;

    private String tittle;

    public MusicDto() {
        //empty for framework
    }

    public MusicDto(Music music) {
        this.id = music.getId();
        this.tittle = music.getTitle();
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

    @Override
    public String toString() {
        return "MusicDto{" +
                "id='" + id + '\'' +
                ", tittle='" + tittle + '\'' +
                '}';
    }
}