package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.dtos.OpinionDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class OpinionBusinessControllerIT {

    @Autowired
    private OpinionBusinessController opinionBusinessController;

    private OpinionDto opinionDto;

    @BeforeEach
    void before() {
        opinionDto = new OpinionDto("Good", new Date("20/10/2019"));
    }

    @Test
    void testCreate() {
        OpinionDto opinionDto1 = opinionBusinessController.create(opinionDto);
        assertEquals("Good", opinionDto1.getDescription());
    }
}
