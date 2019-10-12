package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.documents.DanceCourse;
import es.upm.miw.apaw_ep_themes.documents.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestConfig
public class DanceCourseDaoIT {

    @Autowired
    private DanceCourseDao danceCourseDao;

    @Test
    void testCreate() {
        DanceCourse danceCourse = new DanceCourse("Salsa", new Date("12/10/2019"), new Date("18/10/2019"), Boolean.TRUE, new Room(2, 1));
        this.danceCourseDao.save(danceCourse);
        DanceCourse databaseDanceCourse = this.danceCourseDao.findById(danceCourse.getId()).orElseGet(Assertions::fail);
        assertEquals("Salsa", databaseDanceCourse.getDescription());
    }
}
