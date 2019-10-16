package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.DanceCourseDao;
import es.upm.miw.apaw_ep_themes.documents.DanceCourse;
import es.upm.miw.apaw_ep_themes.documents.Room;
import es.upm.miw.apaw_ep_themes.dtos.DanceCourseCreationDto;
import es.upm.miw.apaw_ep_themes.dtos.DanceCourseDto;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

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

    public DanceCourseDto updatePartial(DanceCourseDto danceCourseDto) {
        Optional<DanceCourse> danceCourse = this.danceCourseDao.findById(danceCourseDto.getId());
        if (danceCourse.isPresent()) {
            danceCourse.get().setDueDate(danceCourseDto.getDueDate());
            this.danceCourseDao.save(danceCourse.get());
            return new DanceCourseDto(danceCourse.get());
        }
        return null;
    }

    private DanceCourse findDanceCourseBYAssured(String id) {
        return this.danceCourseDao.findById(id).orElseThrow(() -> new NotFoundException("DanceCourse id:" + id));
    }

    public void updateDescription(String id, String description) {
        DanceCourse danceCourse = this.findDanceCourseBYAssured(id);
        danceCourse.setDescription(description);
        this.danceCourseDao.save(danceCourse);
    }
}
