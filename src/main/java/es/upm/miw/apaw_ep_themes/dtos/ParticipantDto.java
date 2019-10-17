package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Participant;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

import java.util.Date;

public class ParticipantDto {

    public static String INCOMPLETE_DATA_ERROR = "Incomplete Data";

    private String id;

    private String nick;

    private String fullName;

    private Date birthDate;

    public ParticipantDto() {
        //empty for framework
    }

    public ParticipantDto(String nick, String fullName, Date birthDate) {
        this.nick = nick;
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

    public ParticipantDto(Participant participant) {
        this.id = participant.getId();
        this.nick = participant.getNick();
        this.fullName = participant.getFullName();
        this.birthDate = participant.getBirthDate();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void validate() {
        if (nick == null || nick.isEmpty() || fullName == null || fullName.isEmpty() || birthDate == null) {
            throw new BadRequestException(INCOMPLETE_DATA_ERROR);
        }
    }

    @Override
    public String toString() {
        return "ParticipantDto{" +
                "id='" + id + '\'' +
                ", nick='" + nick + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
