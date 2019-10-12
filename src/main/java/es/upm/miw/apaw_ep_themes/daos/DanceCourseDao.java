package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.DanceCourse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DanceCourseDao extends MongoRepository<DanceCourse, String> {
}
