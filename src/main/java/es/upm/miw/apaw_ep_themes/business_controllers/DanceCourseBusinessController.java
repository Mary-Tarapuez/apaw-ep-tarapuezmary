package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.DanceCourseDao;
import es.upm.miw.apaw_ep_themes.documents.DanceCourse;
import es.upm.miw.apaw_ep_themes.documents.Room;
import es.upm.miw.apaw_ep_themes.dtos.DanceCourseCreationDto;
import es.upm.miw.apaw_ep_themes.dtos.DanceCourseDto;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DanceCourseBusinessController {

    private DanceCourseDao danceCourseDao;

    @Autowired
    public DanceCourseBusinessController(DanceCourseDao danceCourseDao) {
        this.danceCourseDao = danceCourseDao;
    }

    public DanceCourseDto create(DanceCourseCreationDto danceCourseCreationDto) {
        Room room = new Room(danceCourseCreationDto.getNumber(), danceCourseCreationDto.getFloor());
        DanceCourse danceCourse = new DanceCourse(danceCourseCreationDto.getDescription(), danceCourseCreationDto.getStartDate(), danceCourseCreationDto.getDueDate(), danceCourseCreationDto.getStateCourse(),
                room);
        this.danceCourseDao.save(danceCourse);
        return new DanceCourseDto(danceCourse);
    }

    public DanceCourseDto readDescription(String id){
        return new DanceCourseDto(this.danceCourseDao.findById(id).orElseThrow(() -> new NotFoundException("DanceCourse id:" + id)));
    }
}
