package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.dtos.ParticipantDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class ParticipantBusinessControllerIT {


    @Autowired
    private ParticipantBusinessController participantBusinessController;

    private ParticipantDto participantDto;

    @BeforeEach
    void before() {

        participantDto = new ParticipantDto("nick", "Jorge Atiencia", new Date("07/07/1988"));
    }

    @Test
    void testCreate() {
        ParticipantDto participantDto1 = participantBusinessController.create(participantDto);
        assertEquals("nick", participantDto1.getNick());
    }
}
