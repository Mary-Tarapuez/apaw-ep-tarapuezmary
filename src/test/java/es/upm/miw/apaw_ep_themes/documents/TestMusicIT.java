package es.upm.miw.apaw_ep_themes.documents;

import org.junit.jupiter.api.Test;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestMusicIT {

    @Test
    void testCreate(){
        Music music = new Music("Vivir","Salsa", new DanceCourse("Teen", new Date("17/10/2019"), new Date("21/10/2019"), Boolean.TRUE, new Room(2, 1)));
        assertEquals("Vivir", music.getTitle());
        assertEquals("Salsa", music.getGender());
        assertEquals("Teen", music.getDanceCourse().getDescription());
    }
}
