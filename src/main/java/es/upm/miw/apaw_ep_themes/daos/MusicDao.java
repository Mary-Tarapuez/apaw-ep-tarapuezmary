package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.Music;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicDao extends MongoRepository<Music, String> {
}
