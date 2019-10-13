package es.upm.miw.apaw_ep_themes.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Music {

    @Id
    private String id;

    private String title;

    private String gender;

    private DanceCourse danceCourse;

    public Music(String title, String gender, DanceCourse danceCourse) {
        this.title = title;
        this.gender = gender;
        this.danceCourse = danceCourse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public DanceCourse getDanceCourse() {
        return danceCourse;
    }

    public void setDanceCourse(DanceCourse danceCourse) {
        this.danceCourse = danceCourse;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", gender='" + gender + '\'' +
                ", danceCourse=" + danceCourse +
                '}';
    }
}