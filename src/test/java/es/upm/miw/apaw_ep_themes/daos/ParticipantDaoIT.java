package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.documents.Participant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestConfig
public class ParticipantDaoIT {

    @Autowired
    private ParticipantDao participantDao;

    @Test
    void testCreate(){
        Participant participant = new Participant("nick", "FullName", new Date("15/08/2000"));
        this.participantDao.save(participant);
        assertEquals("nick", participant.getNick());
    }

}
