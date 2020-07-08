package com.project.oglasnik.vehicles.domain.repository;

import com.project.oglasnik.vehicles.domain.model.Vehicle;
import com.project.oglasnik.vehicles.domain.model.Buyer;
import com.project.oglasnik.vehicles.domain.model.VehicleId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, VehicleId> {
    List<Vehicle> findAll();
    Vehicle findByVehicleId(VehicleId id);
}
