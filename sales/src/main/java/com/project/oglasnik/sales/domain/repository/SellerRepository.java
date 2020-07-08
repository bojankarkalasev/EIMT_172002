package com.project.oglasnik.sales.domain.repository;

import com.project.oglasnik.sales.domain.model.Seller;
import com.project.oglasnik.sales.domain.model.SellerId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SellerRepository extends CrudRepository<Seller, SellerId> {
    List<Seller> findAll();
    Seller findBySellerId(SellerId id);
}