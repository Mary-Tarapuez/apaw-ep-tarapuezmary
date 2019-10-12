package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.Opinion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OpinionDao extends MongoRepository<Opinion, String> {
}
