package com.project.oglasnik.vehicles.controller;

import com.project.oglasnik.vehicles.domain.events.VehicleCreated;
import com.project.oglasnik.vehicles.domain.model.BuyerId;
import com.project.oglasnik.vehicles.domain.model.Vehicle;
import com.project.oglasnik.vehicles.domain.model.VehicleId;
import com.project.oglasnik.vehicles.domain.repository.BuyerRepository;
import com.project.oglasnik.vehicles.domain.model.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.oglasnik.vehicles.domain.events.VehicleAddedByBuyer;
import org.springframework.context.ApplicationEventPublisher;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@RestController
public class BuyerController {

    @Autowired
    BuyerRepository buyerRepository;
    ApplicationEventPublisher eventPublisher;

    @RequestMapping("/buyers")
    public List<Buyer> getBuyers()
    {
        return buyerRepository.findAll();
    }

    @RequestMapping("/buyer/{buyerId}")
    public Buyer getBuyer(@PathVariable BuyerId buyerId) {
        return buyerRepository.findByBuyerId(buyerId);
    }

    @RequestMapping(method= RequestMethod.POST, value="/buyers")
    public void addBuyer(@RequestBody Buyer buyer) {
        buyerRepository.save(buyer);
    }

    @PutMapping("/buyer/{buyerId}")
    public void updateBuyer(@PathVariable BuyerId buyerId, @RequestBody Buyer buyer) {
        Buyer newBuyer = buyerRepository.findByBuyerId(buyerId);
        newBuyer.setFirstName(buyer.getFirstName());
        newBuyer.setLastName(buyer.getLastName());
        newBuyer.setCompanyName(buyer.getCompanyName());
        if(buyer.getOccupation()!= null) {
            newBuyer.setOccupation(buyer.getOccupation());
        }
        newBuyer.setTaxNumber(buyer.getTaxNumber());
        newBuyer.setEmail(buyer.getEmail());
        newBuyer.setPassword(buyer.getPassword());
        newBuyer.setApproved(buyer.getApproved());
        if(buyer.getVehicles() != null) {
            newBuyer.setVehicles(buyer.getVehicles());
        }

        buyerRepository.save(newBuyer);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/buyer/{buyerId}")
    public void deleteBuyer(@PathVariable BuyerId buyerId, @RequestBody Buyer buyer) {
        Buyer newBuyer = buyerRepository.findByBuyerId(buyerId);
        buyerRepository.delete(newBuyer);
    }

    @PutMapping("/buyer/{buyerId}/addfavourite/{vechicleId}")
    public void addFavourite(@PathVariable BuyerId buyerId, @PathVariable VehicleId vehicleId, @RequestBody Vehicle vehicle) {
        eventPublisher.publishEvent(new VehicleAddedByBuyer(vehicleId, buyerId, Instant.now()));
        Set<Buyer> buyers = vehicle.getBuyers();
        buyers.add(buyerRepository.findByBuyerId(buyerId));
        vehicle.setBuyers(buyers);
    }
}
