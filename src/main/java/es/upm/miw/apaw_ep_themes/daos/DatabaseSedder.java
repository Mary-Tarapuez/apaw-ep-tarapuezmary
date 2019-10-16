package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

@Service
public class DatabaseSedder {
    private ParticipantDao participantDao;

    @Autowired
    public DatabaseSedder(ParticipantDao participantDao){
        this.participantDao = participantDao;
        this.seedParticipants();
    }

    public void seedParticipants(){
        this.participantDao.saveAll(Arrays.asList(
                new Participant("Jorge","Jorge Ramirez", new Date("12/11/2005")),
                new Participant("mtarapuez","Maricela Tarapuez", new Date("31/12/2005"))
        ));
    }


}
