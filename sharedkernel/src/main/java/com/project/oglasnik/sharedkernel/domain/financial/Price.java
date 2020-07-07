package com.project.oglasnik.sharedkernel.domain.financial;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.oglasnik.sharedkernel.domain.base.ValueObject;
import org.springframework.lang.NonNull;

import java.util.Objects;

public class Price implements ValueObject {

    @JsonProperty("currency")
    private final Currency currency;

    @JsonProperty("amount")
    private final int amount;


    @JsonCreator
    public Price(@NonNull @JsonProperty("currency") Currency currency, @JsonProperty("amount") int amount) {
        this.currency = Objects.requireNonNull(currency, "currency must not be null");
        this.amount = amount;
    }
}
