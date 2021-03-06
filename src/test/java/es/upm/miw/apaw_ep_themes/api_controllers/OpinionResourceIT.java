package es.upm.miw.apaw_ep_themes.api_controllers;


import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.business_controllers.OpinionBusinessController;
import es.upm.miw.apaw_ep_themes.daos.OpinionDao;
import es.upm.miw.apaw_ep_themes.documents.Opinion;
import es.upm.miw.apaw_ep_themes.dtos.OpinionDto;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ApiTestConfig
public class OpinionResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private OpinionBusinessController opinionBusinessController;

    @Autowired
    private OpinionDao opinionDao;

    @Test
    void testCreate(){
        OpinionDto opinionDto = this.webTestClient
                .post().uri(OpinionResource.OPINIONS)
                .body(BodyInserters.fromObject(new OpinionDto("Description", new Date("15/10/2019"))))
                .exchange().expectStatus().isOk()
                .expectBody(OpinionDto.class)
                .returnResult().getResponseBody();
        assertEquals("Description", opinionDto.getDescription());
    }

    @Test
    void testCreateOpinionException(){
        OpinionDto opinionDto = new OpinionDto(null, null);
        this.webTestClient.post().uri(OpinionResource.OPINIONS).body(BodyInserters.fromObject(opinionDto)).exchange().expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testReadAll(){
        OpinionDto opinionDto = new OpinionDto("Fanny", new Date("15/10/2019"));
        this.webTestClient.post().uri(OpinionResource.OPINIONS).body(BodyInserters.fromObject(opinionDto)).exchange().expectStatus().isOk();
        List<OpinionDto> list = this.webTestClient.get().uri(OpinionResource.OPINIONS).exchange().expectStatus().isOk().expectBodyList(OpinionDto.class).returnResult().getResponseBody();
        assertTrue(list.size()>0);
        assertNotNull(list.get(0).getId());
        assertNotNull(list.get(0).getDescription());
        assertNotNull(list.get(0).getDateRegister());
    }
    @Test
    void testReadAllException(){
        this.webTestClient.get().uri(OpinionResource.OPINIONS + OpinionResource.ID + OpinionResource.DESCRIPTION, "no").exchange().expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }
    void testDelete(){
        String idOpinion = this.webTestClient
                .post().uri(OpinionResource.OPINIONS)
                .body(BodyInserters.fromObject(new OpinionDto("Description", new Date("15/10/2019"))))
                .exchange()
                .expectStatus().isOk()
                .expectBody(OpinionDto.class)
                .returnResult().getResponseBody().getId();
        this.webTestClient
                .delete().uri(OpinionResource.OPINIONS + OpinionResource.ID,idOpinion)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testPublisher(){

      OpinionDto opinionDto = new OpinionDto("Teen", new Date("18/10/2019"));
        String id = this.webTestClient.post().uri(OpinionResource.OPINIONS)
                .body(BodyInserters.fromObject(opinionDto))
                .exchange().expectStatus().isOk()
                .expectBody(OpinionDto.class).returnResult().getResponseBody().getId();

        Opinion opinion = new  Opinion("Tenn", new Date ("19/10/2019"));
        this.opinionDao.save(opinion);
        Opinion opinionData = this.opinionDao.findById(opinion.getId()).orElseThrow(()->new NotFoundException("Opinion not found"));
        StepVerifier.create(opinionBusinessController.publisher()).then(()-> opinionBusinessController.create(new OpinionDto("description",new Date("19/10/2019"))))
                .expectNext("New Opinion is created").thenCancel().verify();
    }
}