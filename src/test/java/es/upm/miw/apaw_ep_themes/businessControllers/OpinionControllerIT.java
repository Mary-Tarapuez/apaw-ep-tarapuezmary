package es.upm.miw.apaw_ep_themes.businessControllers;


import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.business_controllers.OpinionBusinessController;
import es.upm.miw.apaw_ep_themes.daos.OpinionDao;
import es.upm.miw.apaw_ep_themes.documents.Opinion;
import es.upm.miw.apaw_ep_themes.dtos.OpinionDto;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@TestConfig
public class OpinionControllerIT {

    @Autowired
    private OpinionDao opinionDao;

    @Autowired
    private OpinionBusinessController opinionBusinessController;

    private Opinion opinion;

    @BeforeEach
    void before() {
        this.opinion = new Opinion("description", new Date("17/10/2019"));
        this.opinionDao.save(opinion);
    }

    @Test
    void testReadAll(){
        OpinionDto opinionDto = new OpinionDto("opinion", new Date("17/10/2019"));
        opinionBusinessController.readAll();
        assertEquals("description", "description");
    }
}
