package com.project.oglasnik.vehicles.domain.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.oglasnik.sharedkernel.domain.base.DomainEvent;
import com.project.oglasnik.vehicles.domain.model.VehicleId;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.Objects;

public class VehicleCreated implements DomainEvent {

    @JsonProperty("vehicleId")
    private final VehicleId vehicleId;

    @JsonProperty("occurredOn")
    private final Instant occurredOn;

    @JsonCreator
    public VehicleCreated(@JsonProperty("vehicleId") @NonNull VehicleId vehicleId,
                        @JsonProperty("occurredOn") @NonNull Instant occurredOn) {
        this.vehicleId = Objects.requireNonNull(vehicleId, "vehicleId must not be null");
        this.occurredOn = Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }

    @NonNull
    public VehicleId VehicleId() {
        return vehicleId;
    }

    @Override
    @NonNull
    public Instant occurredOn() {
        return occurredOn;
    }
}
