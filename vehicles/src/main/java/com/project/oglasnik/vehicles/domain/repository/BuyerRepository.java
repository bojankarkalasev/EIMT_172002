package com.project.oglasnik.vehicles.domain.repository;

import com.project.oglasnik.vehicles.domain.model.Buyer;
import com.project.oglasnik.vehicles.domain.model.BuyerId;
import com.project.oglasnik.vehicles.domain.model.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BuyerRepository extends CrudRepository<Buyer, BuyerId> {
    List<Buyer> findAll();
    Buyer findByBuyerId(BuyerId id);
}