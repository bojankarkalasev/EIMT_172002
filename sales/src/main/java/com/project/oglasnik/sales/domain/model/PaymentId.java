package com.project.oglasnik.sales.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import com.project.oglasnik.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode
public class PaymentId extends DomainObjectId {

    private PaymentId() {
        super("");
    }

    public PaymentId(@NonNull String id) {
        super(id);
    }
}
