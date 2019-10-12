package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.DanceCourseBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.DanceCourseCreationDto;
import es.upm.miw.apaw_ep_themes.dtos.DanceCourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DanceCourseResource.DANCE_COURSES)
public class DanceCourseResource {

    public static final String DANCE_COURSES = "/danceCourses";

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
}