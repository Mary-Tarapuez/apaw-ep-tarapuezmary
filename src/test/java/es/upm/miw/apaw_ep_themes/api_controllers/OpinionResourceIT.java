package es.upm.miw.apaw_ep_themes.api_controllers;


import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.dtos.OpinionDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ApiTestConfig
public class OpinionResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate(){
        OpinionDto opinionDto = this.webTestClient.post().uri(OpinionResource.OPINIONS).body(BodyInserters.fromObject(new OpinionDto("Description", new Date("15/10/2019")))).exchange().expectStatus().isOk().expectBody(OpinionDto.class).returnResult().getResponseBody();
        assertEquals("Description", opinionDto.getDescription());
    }

    @Test
    void testCreateOpinionException(){
        OpinionDto opinionDto = new OpinionDto(null, null);
        this.webTestClient.post().uri(OpinionResource.OPINIONS).body(BodyInserters.fromObject(opinionDto)).exchange().expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

}
