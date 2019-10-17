package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.OpinionDao;
import es.upm.miw.apaw_ep_themes.documents.Opinion;
import es.upm.miw.apaw_ep_themes.dtos.OpinionDto;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OpinionBusinessController {

    private OpinionDao opinionDao;

    @Autowired
    public OpinionBusinessController(OpinionDao opinionDao) {
        this.opinionDao = opinionDao;
    }

    public OpinionDto create(OpinionDto opinionDto) {
        Opinion opinion = new Opinion(opinionDto.getDescription(), opinionDto.getDateRegister());
        this.opinionDao.save((opinion));
        return new OpinionDto(opinion);
    }

    public List<OpinionDto> readAll() {
        List<Opinion> opinions = this.opinionDao.findAll();
        return opinions.stream().map(OpinionDto::new).collect(Collectors.toList());
    }

    public void delete(String id){
        Opinion opinion = this.opinionDao.findById(id).orElseThrow(()-> new NotFoundException("Opinion not found"));
        this.opinionDao.delete(opinion);
    }
}