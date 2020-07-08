package com.project.oglasnik.sales.domain.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.oglasnik.sales.domain.model.Payment;
import com.project.oglasnik.sales.domain.model.PaymentId;
import com.project.oglasnik.sharedkernel.domain.base.DomainEvent;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.Objects;

public class PaymentDeleted implements DomainEvent {

    @JsonProperty("paymentId")
    private final PaymentId paymentId;

    @JsonProperty("occurredOn")
    private final Instant occurredOn;

    @JsonCreator
    public PaymentDeleted(@JsonProperty("paymentId") @NonNull PaymentId paymentId,
                          @JsonProperty("occurredOn") @NonNull Instant occurredOn) {
        this.paymentId = Objects.requireNonNull(paymentId, "paymentId must not be null");
        this.occurredOn = Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }

    @NonNull
    public PaymentId paymentId() {
        return paymentId;
    }

    @Override
    @NonNull
    public Instant occurredOn() {
        return occurredOn;
    }
}
