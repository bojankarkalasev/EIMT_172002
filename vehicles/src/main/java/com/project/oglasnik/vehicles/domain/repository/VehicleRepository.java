package com.project.oglasnik.vehicles.domain.repository;

import com.project.oglasnik.vehicles.domain.model.Vehicle;
import com.project.oglasnik.vehicles.domain.model.Buyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
    List<Vehicle> findAll();
    Vehicle findByVehicleId(Integer id);
}
