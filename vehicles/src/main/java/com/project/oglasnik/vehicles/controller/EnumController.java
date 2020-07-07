package com.project.oglasnik.vehicles.controller;

import com.project.oglasnik.vehicles.domain.enumeration.BodyType;
import com.project.oglasnik.vehicles.domain.enumeration.Color;
import com.project.oglasnik.vehicles.domain.enumeration.Damage;
import com.project.oglasnik.vehicles.domain.enumeration.Fuel;
import com.project.oglasnik.vehicles.domain.enumeration.Make;
import com.project.oglasnik.vehicles.domain.enumeration.Transmission;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EnumController {

    @RequestMapping("/bodytypes")
    public String[] getBodyTypes()
    {
        BodyType[] bodyTypes = BodyType.values();
        String[] bodyTypesList = new String[bodyTypes.length];

        for (int i = 0; i < bodyTypes.length; i++) {
            bodyTypesList[i] = bodyTypes[i].name();
        }

        return bodyTypesList;
    }


    @RequestMapping("/colors")
    public String[] getColors()
    {
        Color[] colors = Color.values();
        String[] colorList = new String[colors.length];

        for (int i = 0; i < colors.length; i++) {
            colorList[i] = colors[i].name();
        }

        return colorList;
    }

    @RequestMapping("/damages")
    public String[] getDamages()
    {
        Damage[] damages = Damage.values();
        String[] damageList = new String[damages.length];

        for (int i = 0; i < damages.length; i++) {
            damageList[i] = damages[i].name();
        }

        return damageList;
    }

    @RequestMapping("/fuels")
    public String[] getFuel()
    {
        Fuel[] fuels = Fuel.values();
        String[] fuelList = new String[fuels.length];

        for (int i = 0; i < fuels.length; i++) {
            fuelList[i] = fuels[i].name();
        }

        return fuelList;
    }

    @RequestMapping("/makes")
    public String[] getMakes()
    {
        Make[] makes = Make.values();
        String[] makeList = new String[makes.length];

        for (int i = 0; i < makes.length; i++) {
            makeList[i] = makes[i].name();
        }

        return makeList;
    }

    @RequestMapping("/transmissions")
    public String[] getTransmissions()
    {
        Transmission[] transmissions = Transmission.values();
        String[] transmissionList = new String[transmissions.length];

        for (int i = 0; i < transmissions.length; i++) {
            transmissionList[i] = transmissions[i].name();
        }

        return transmissionList;
    }
}