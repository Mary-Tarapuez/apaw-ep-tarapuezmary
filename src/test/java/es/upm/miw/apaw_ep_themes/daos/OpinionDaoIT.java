package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.documents.Opinion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class OpinionDaoIT {

    @Autowired
    private OpinionDao opinionDao;

    @Test
    void testCreate(){
        Opinion opinion = new Opinion("Funny", new Date("15/10/2019"));
        this.opinionDao.save(opinion);
        Opinion databaseOpinion = this.opinionDao.findById(opinion.getId()).orElseGet(Assertions::fail);
        assertEquals("Funny", databaseOpinion.getDescription());
    }

}
