package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.ParticipantBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.ParticipantDto;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = SEARCH)
    public List<ParticipantDto> find(@RequestParam String q){
        if(!"nick".equals(q.split(":")[0])){
            throw new BadRequestException("query param q is incorrect, missing 'nick'");
        }
        return this.participantBusinessController.findNick(q.split(":")[1]);
    }
}
