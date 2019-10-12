package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.dtos.DanceCourseCreationDto;
import es.upm.miw.apaw_ep_themes.dtos.DanceCourseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ApiTestConfig
public class DanceCourseResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        DanceCourseCreationDto danceCourseCreationDto = new DanceCourseCreationDto("Beginner", new Date("12/10/2019"), new Date("16/10/2019"), Boolean.TRUE, 2, 1);
        DanceCourseDto danceCourseDto = this.webTestClient
                .post().uri(DanceCourseResource.DANCE_COURSES)
                .body(BodyInserters.fromObject(danceCourseCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(DanceCourseDto.class)
                .returnResult().getResponseBody();
        assertEquals("Beginner", danceCourseDto.getDescription());
    }

    @Test
    void testCreateDanceCourseException() {
        DanceCourseCreationDto danceCourseCreationDto = new DanceCourseCreationDto("Pop", new Date("12/10/2019"), new Date("16/10/2019"), Boolean.TRUE, 2, 0);
        this.webTestClient
                .post().uri(DanceCourseResource.DANCE_COURSES)
                .body(BodyInserters.fromObject(danceCourseCreationDto))
                .exchange().expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void testUpdatePartial() {
        DanceCourseDto danceCourseDto = new DanceCourseDto();
        danceCourseDto.setDueDate(new Date("18/10/2019"));
        this.webTestClient
                .post().uri(DanceCourseResource.DANCE_COURSES)
                .body(BodyInserters.fromObject(danceCourseDto))
                .exchange().expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
