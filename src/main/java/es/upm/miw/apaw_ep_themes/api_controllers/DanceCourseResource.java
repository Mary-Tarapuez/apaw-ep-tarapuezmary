package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.DanceCourseBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.DanceCourseCreationDto;
import es.upm.miw.apaw_ep_themes.dtos.DanceCourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(DanceCourseResource.DANCE_COURSES)
public class DanceCourseResource {

    public static final String DANCE_COURSES = "/danceCourses";
    static final String ID_ID = "/{id}";
    static final String DESCRIPTION = "/description";

    private DanceCourseBusinessController danceCourseBusinessController;

    @Autowired
    public DanceCourseResource(DanceCourseBusinessController danceCourseBusinessController) {
        this.danceCourseBusinessController = danceCourseBusinessController;
    }

    @PostMapping
    public DanceCourseDto create(@RequestBody DanceCourseCreationDto danceCourseCreationDto) {
        danceCourseCreationDto.validate();
        return this.danceCourseBusinessController.create(danceCourseCreationDto);
    }

    @PatchMapping
    public DanceCourseDto updatePartial(@RequestBody DanceCourseDto danceCourseDto) {
        return this.danceCourseBusinessController.updatePartial(danceCourseDto);
    }

    @PutMapping(value = ID_ID + DESCRIPTION)
    public void updateDanceCourse(@PathVariable String id, @RequestBody DanceCourseDto danceCourseDto) {
        danceCourseDto.validateDescription();
        this.danceCourseBusinessController.updateDescription(id, danceCourseDto.getDescription());
    }

}