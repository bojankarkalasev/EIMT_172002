package com.project.oglasnik.vehicles.controller;

import com.project.oglasnik.vehicles.domain.model.VehicleId;
import com.project.oglasnik.vehicles.domain.repository.VehicleRepository;
import com.project.oglasnik.vehicles.domain.model.Vehicle;
import com.project.oglasnik.vehicles.domain.events.VehicleCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;
    ApplicationEventPublisher eventPublisher;

    @RequestMapping("/vehicles")
    public List<Vehicle> getVehicleId()
    {
        return vehicleRepository.findAll();
    }

    @RequestMapping("/vehicles/{VehicleId}")
    public Vehicle getVehicle(@PathVariable int VehicleId)
    {
        return vehicleRepository.findByVehicleId(VehicleId);
    }


    @RequestMapping(method= RequestMethod.POST, value="/vehicles")
    public void addVehicle(@RequestBody Vehicle vehicle) {
        VehicleId vehicleId = vehicle.getId();
        eventPublisher.publishEvent(new VehicleCreated(vehicleId, Instant.now()));
        vehicleRepository.save(vehicle);

    }

    @RequestMapping(method= RequestMethod.DELETE, value="/vehicles/{VehicleId}")
    public void deleteVehicle(@PathVariable int VehicleId) {
        Vehicle newVehicle = vehicleRepository.findByVehicleId(VehicleId);
        vehicleRepository.delete(newVehicle);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/vehicles/{VehicleId}")
    public void updateVehicle(@PathVariable int VehicleId, @RequestBody  Vehicle vehicle) {
        Vehicle newVehicle = vehicleRepository.findByVehicleId(VehicleId);
        if(vehicle.getBodyType()!= null) {
            newVehicle.setBodyType(vehicle.getBodyType());
        }
        if(vehicle.getColor()!= null) {
            newVehicle.setColor(vehicle.getColor());
        }
        if(vehicle.getDamage() != null) {
            newVehicle.setDamage(vehicle.getDamage());
        }
        if(vehicle.getFuel() != null) {
            newVehicle.setFuel(vehicle.getFuel());
        }
        if(vehicle.getMake() != null) {
            newVehicle.setMake(vehicle.getMake());
        }
        if(vehicle.getTransmission() != null) {
            newVehicle.setTransmission(vehicle.getTransmission());
        }

        vehicleRepository.save(newVehicle);
    }

}