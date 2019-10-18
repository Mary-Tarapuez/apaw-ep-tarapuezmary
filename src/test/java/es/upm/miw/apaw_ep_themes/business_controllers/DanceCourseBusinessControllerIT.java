package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.daos.DanceCourseDao;
import es.upm.miw.apaw_ep_themes.documents.DanceCourse;
import es.upm.miw.apaw_ep_themes.documents.Room;
import es.upm.miw.apaw_ep_themes.dtos.DanceCourseCreationDto;
import es.upm.miw.apaw_ep_themes.dtos.DanceCourseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class DanceCourseBusinessControllerIT {

    @Autowired
    private DanceCourseBusinessController danceCourseBusinessController;

    private DanceCourse danceCourse;

    @BeforeEach
    void before() {
        Room room = new Room(4, 5);
        danceCourse = new DanceCourse("Beginner", new Date("20/10/2019"), new Date("20/10/2019"), Boolean.TRUE,
                room);
    }

    @Test
    void testCreate() {
        DanceCourseCreationDto danceCourseCreationDto = new DanceCourseCreationDto(danceCourse.getDescription(), danceCourse.getStartDate(), danceCourse.getDueDate(), danceCourse.getStateCourse(),
                danceCourse.getRoom().getNumber(), danceCourse.getRoom().getFloor());
        DanceCourseDto danceCourseDto = danceCourseBusinessController.create(danceCourseCreationDto);
        assertEquals("Beginner", danceCourseDto.getDescription());
    }

}
