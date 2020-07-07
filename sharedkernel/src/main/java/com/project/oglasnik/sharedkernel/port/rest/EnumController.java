package com.project.oglasnik.sharedkernel.port.rest;

import com.project.oglasnik.sharedkernel.domain.people.Occupation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EnumController {

    @RequestMapping("/occupations")
    public String[] getOccupations()
    {
        Occupation[] occupations = Occupation.values();
        String[] occupationList = new String[occupations.length];

        for (int i = 0; i < occupations.length; i++) {
            occupationList[i] = occupations[i].name();
        }

        return occupationList;
    }
}