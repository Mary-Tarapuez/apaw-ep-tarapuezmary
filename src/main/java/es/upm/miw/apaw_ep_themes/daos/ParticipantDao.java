package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.Participant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParticipantDao extends MongoRepository<Participant, String> {
}
