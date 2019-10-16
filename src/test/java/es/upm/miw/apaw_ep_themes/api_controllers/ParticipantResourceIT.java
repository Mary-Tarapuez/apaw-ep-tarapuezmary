package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.dtos.ParticipantDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.List;

@ApiTestConfig
public class ParticipantResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void TestSearchNick(){
        List<ParticipantDto> participansJorge = this.webTestClient
                .get().uri(uriBuilder ->
                        uriBuilder.path(ParticipantResource.PARTICIPANTS + ParticipantResource.SEARCH)
                         .queryParam("q","nick:Jorge")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ParticipantDto.class)
                .returnResult().getResponseBody();
        assertFalse(participansJorge.isEmpty());

    }

}
