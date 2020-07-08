package com.project.oglasnik.sales.controller;

import com.project.oglasnik.sales.domain.model.SellerId;
import com.project.oglasnik.sales.domain.repository.SellerRepository;
import com.project.oglasnik.sales.domain.model.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;
import com.project.oglasnik.sales.domain.events.SellerCreated;

import java.time.Instant;
import java.util.List;

@RestController
public class SellerController {

    @Autowired
    SellerRepository sellerRepository;
    ApplicationEventPublisher eventPublisher;

    @RequestMapping("/sellers")
    public List<Seller> getSellers()
    {
        return sellerRepository.findAll();
    }

    @RequestMapping("/seller/{sellerId}")
    public Seller getSeller (@PathVariable SellerId sellerId) {
        return sellerRepository.findBySellerId(sellerId);
    }

    @RequestMapping(method= RequestMethod.POST, value="/seller")
    public void addSeller (@RequestBody Seller seller) {
        eventPublisher.publishEvent(new SellerCreated(seller.getId(), seller.getCompany().getId(), Instant.now()));
        sellerRepository.save(seller);
    }

    @PutMapping("/seller/{sellerId}")
    public void updateSeller (@PathVariable SellerId sellerId, @RequestBody Seller seller) {
        Seller newSeller = sellerRepository.findBySellerId(sellerId);
        newSeller.setFirstName(seller.getFirstName());
        newSeller.setLastName(seller.getLastName());
        if(seller.getCompany()!= null) {
            newSeller.setCompany(seller.getCompany());
        }
        newSeller.setEmail(seller.getEmail());
        newSeller.setPassword(seller.getPassword());

        sellerRepository.save(newSeller);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/seller/{sellerId}")
    public void deleteSeller (@PathVariable SellerId sellerId, @RequestBody Seller seller) {
        Seller newSeller = sellerRepository.findBySellerId(sellerId);
        sellerRepository.delete(newSeller);
    }
}
