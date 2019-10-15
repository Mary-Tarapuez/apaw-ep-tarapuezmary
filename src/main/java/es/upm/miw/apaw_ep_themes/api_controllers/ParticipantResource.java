package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.ParticipantBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.ParticipantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ParticipantResource.PARTICIPANTS)
public class ParticipantResource {
    public static final String PARTICIPANTS = "/participants";
    static final String ID = "/{id}";
    static final String NICK = "/nick";
    static final String SEARCH = "/search";

    private ParticipantBusinessController participantBusinessController;

    @Autowired
    public ParticipantResource(ParticipantBusinessController participantBusinessController){
        this.participantBusinessController = participantBusinessController;
    }

    @GetMapping(value = ID + NICK)
    public ParticipantDto readNick(@PathVariable String id){
        return this.participantBusinessController.readNick(id);
    }
}
