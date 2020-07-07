package com.project.oglasnik.sharedkernel.domain.vehicle;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.oglasnik.sharedkernel.domain.base.ValueObject;
import org.springframework.lang.NonNull;

import java.util.Objects;

public class Equipment implements ValueObject {

    @JsonProperty("cruiseControl")
    private final boolean cruiseControl;

    @JsonProperty("airConditioning")
    private final boolean airConditioning;

    @JsonProperty("sunroof")
    private final boolean sunroof;

    @JsonProperty("airSuspension")
    private final boolean airSuspension;

    @JsonProperty("blindSpot")
    private final boolean blindSpot;

    @JsonProperty("navigation")
    private final boolean navigation;

    @JsonProperty("bluetooth")
    private final boolean bluetooth;

    @JsonProperty("fourWheelDrive")
    private final boolean fourWheelDrive;

    @JsonProperty("parkDistanceControl")
    private final boolean parkDistanceControl;

    @JsonProperty("leather")
    private final boolean leather;

    @JsonProperty("laneAssist")
    private final boolean laneAssist;

    @JsonProperty("camera")
    private final boolean camera;


    @JsonCreator
    public Equipment(@JsonProperty("cruiseControl") boolean cruiseControl,
                 @JsonProperty("airConditioning") boolean airConditioning,
                 @JsonProperty("sunroof") boolean sunroof,
                 @JsonProperty("airSuspension") boolean airSuspension,
                 @JsonProperty("blindSpot") boolean blindSpot,
                 @JsonProperty("navigation")boolean navigation,
                 @JsonProperty("bluetooth") boolean bluetooth,
                 @JsonProperty("fourWheelDrive") boolean fourWheelDrive,
                 @JsonProperty("parkDistanceControl") boolean parkDistanceControl,
                 @JsonProperty("leather") boolean leather,
                 @JsonProperty("laneAssist") boolean laneAssist,
                 @JsonProperty("camera") boolean camera) {
        this.cruiseControl = cruiseControl;
        this.airConditioning = airConditioning;
        this.sunroof = sunroof;
        this.airSuspension = airSuspension;
        this.blindSpot = blindSpot;
        this.navigation = navigation;
        this.bluetooth = bluetooth;
        this.fourWheelDrive = fourWheelDrive;
        this.parkDistanceControl = parkDistanceControl;
        this.leather = leather;
        this.laneAssist = laneAssist;
        this.camera = camera;
    }
}