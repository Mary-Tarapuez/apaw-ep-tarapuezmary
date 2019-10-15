package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.ParticipantDao;
import es.upm.miw.apaw_ep_themes.documents.Participant;
import es.upm.miw.apaw_ep_themes.dtos.ParticipantDto;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ParticipantBusinessController {

    private ParticipantDao participantDao;

    @Autowired
    public ParticipantBusinessController(ParticipantDao participantDao) {
        this.participantDao = participantDao;
    }

    public ParticipantDto create(ParticipantDto participantDto) {
        Participant participant = new Participant(participantDto.getNick(), participantDto.getFullName(), participantDto.getBirthDate());
        this.participantDao.save(participant);
        return new ParticipantDto(participant);
    }

    public ParticipantDto readNick(String id) {
        return new ParticipantDto(this.participantDao.findById(id).orElseThrow(() -> new NotFoundException("Participant id:" + id)));
    }
}

