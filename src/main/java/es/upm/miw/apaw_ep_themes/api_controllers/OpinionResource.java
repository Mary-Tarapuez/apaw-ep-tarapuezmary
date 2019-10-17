package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.OpinionBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.OpinionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(OpinionResource.OPINIONS)
public class OpinionResource {

    static final String OPINIONS = "/opinions";
    static final String ID = "/{id}";
    static final String DESCRIPTION = "/description";

    private OpinionBusinessController opinionBusinessController;

    @Autowired
    public OpinionResource(OpinionBusinessController opinionBusinessController) {
        this.opinionBusinessController = opinionBusinessController;
    }

    @PostMapping
    public OpinionDto create(@RequestBody OpinionDto opinionDto) {
        opinionDto.validate();
        return this.opinionBusinessController.create(opinionDto);
    }

    @GetMapping
    public List<OpinionDto> readAll(){
        return this.opinionBusinessController.readAll();
    }

    @DeleteMapping(value = ID)
    public void delete(String id){
        this.opinionBusinessController.delete(id);
    }
}
