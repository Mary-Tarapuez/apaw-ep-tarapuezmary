package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.MusicBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.MusicCreateDto;
import es.upm.miw.apaw_ep_themes.dtos.MusicDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(MusicResource.MUSICS)
public class MusicResource {

    public static final String MUSICS = "/musics";
    static final String ID = "/{id}";
    static final String TITLE = "/title";
    static final String DANCE_COURSE = "/{id}";

    private MusicBusinessController musicBusinessController;

    @Autowired
    public MusicResource(MusicBusinessController musicBusinessController) {
        this.musicBusinessController = musicBusinessController;
    }

    @PostMapping
    public MusicDto create(@RequestBody MusicCreateDto musicCreateDto) {
        musicCreateDto.validate();
        return this.musicBusinessController.create(musicCreateDto);
    }
}
