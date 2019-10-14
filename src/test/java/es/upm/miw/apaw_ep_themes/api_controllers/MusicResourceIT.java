package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.documents.DanceCourse;
import es.upm.miw.apaw_ep_themes.dtos.DanceCourseCreationDto;
import es.upm.miw.apaw_ep_themes.dtos.DanceCourseDto;
import es.upm.miw.apaw_ep_themes.dtos.MusicCreateDto;
import es.upm.miw.apaw_ep_themes.dtos.MusicDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

@ApiTestConfig
public class MusicResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
     void createMusic() {

        DanceCourseCreationDto danceCourseCreationDto = new DanceCourseCreationDto("Beginner", new Date("12/10/2019"), new Date("16/10/2019"), Boolean.TRUE, 2, 1);
        String idDanceCourse = this.webTestClient
                .post().uri(DanceCourseResource.DANCE_COURSES)
                .body(BodyInserters.fromObject(danceCourseCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(DanceCourseDto.class)
                .returnResult().getResponseBody().getId();
        MusicCreateDto musicCreateDto = new MusicCreateDto("tittle_music-2", "pop", idDanceCourse);
        MusicDto musicDto = this.webTestClient.
                post().uri(MusicResource.MUSICS)
                .body(BodyInserters.fromObject(musicCreateDto))
                .exchange().expectStatus().isOk()
                .expectBody(MusicDto.class).returnResult().getResponseBody();
        assertEquals("tittle_music-2",musicDto.getTittle());
    }

    @Test
    void testCreateDanceCourseIdException() {

        MusicCreateDto musicCreateDto = new MusicCreateDto("tittle_music-2", "pop", "dgdg");
        this.webTestClient
                .post().uri(MusicResource.MUSICS)
                .body(BodyInserters.fromObject(musicCreateDto))
                .exchange().expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }
}
