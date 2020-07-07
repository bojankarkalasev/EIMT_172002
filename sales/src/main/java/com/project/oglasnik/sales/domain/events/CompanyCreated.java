package com.project.oglasnik.sales.domain.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.oglasnik.sales.domain.model.CompanyId;
import com.project.oglasnik.sharedkernel.domain.base.DomainEvent;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.Objects;

public class CompanyCreated implements DomainEvent {

    @JsonProperty("companyId")
    private final CompanyId companyId;

    @JsonProperty("occurredOn")
    private final Instant occurredOn;

    @JsonCreator
    public CompanyCreated(@JsonProperty("companyId") @NonNull CompanyId companyId,
                          @JsonProperty("occurredOn") @NonNull Instant occurredOn) {
        this.companyId = Objects.requireNonNull(companyId, "companyId must not be null");
        this.occurredOn = Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }

    @NonNull
    public CompanyId companyId() {
        return companyId;
    }

    @Override
    @NonNull
    public Instant occurredOn() {
        return occurredOn;
    }
}
