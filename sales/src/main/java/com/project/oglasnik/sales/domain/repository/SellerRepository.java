package com.project.oglasnik.sales.domain.repository;

import com.project.oglasnik.sales.domain.model.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Integer> {
    List<Seller> findAll();
    Seller findBySellerId(Integer id);
}