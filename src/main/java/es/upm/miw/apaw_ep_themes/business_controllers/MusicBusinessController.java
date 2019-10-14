package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.DanceCourseDao;
import es.upm.miw.apaw_ep_themes.daos.MusicDao;
import es.upm.miw.apaw_ep_themes.documents.DanceCourse;
import es.upm.miw.apaw_ep_themes.documents.Music;
import es.upm.miw.apaw_ep_themes.dtos.MusicCreateDto;
import es.upm.miw.apaw_ep_themes.dtos.MusicDto;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class MusicBusinessController {

    private MusicDao musicDao;

    private DanceCourseDao danceCourseDao;

    @Autowired
    public MusicBusinessController(MusicDao musicDao, DanceCourseDao danceCourseDao) {
        this.musicDao = musicDao;
        this.danceCourseDao = danceCourseDao;
    }

    public MusicDto create(MusicCreateDto musicCreateDto) {
        DanceCourse danceCourse = this.danceCourseDao.findById(musicCreateDto.getDanceCourseId()).orElseThrow(() -> new NotFoundException("DanceCourse id:" + musicCreateDto.getDanceCourseId()));
        Music music = new Music(musicCreateDto.getTittle(), musicCreateDto.getGender(), danceCourse);
        this.musicDao.save(music);
        return new MusicDto(music);
    }
}