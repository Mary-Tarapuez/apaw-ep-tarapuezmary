package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.documents.DanceCourse;
import es.upm.miw.apaw_ep_themes.documents.Music;
import es.upm.miw.apaw_ep_themes.documents.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class MusicDaoIT {

    @Autowired
    private MusicDao musicDao;

    @Test
    void testCreate() {
        Room room = new Room(2, 1);
        DanceCourse danceCourse = new DanceCourse("Salsa", new Date("12/10/2019"), new Date("18/10/2019"), Boolean.TRUE, room);
        danceCourse.setId("33333");
        Music music = new Music("Vivir", "Salsa", danceCourse);
        this.musicDao.save(music);
        Music databaseMusic = this.musicDao.findById(music.getId()).orElseGet(Assertions::fail);
        assertEquals("Vivir", databaseMusic.getTitle());
    }
}
