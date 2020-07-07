package com.project.oglasnik.vehicles.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import com.project.oglasnik.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode
public class BuyerId extends DomainObjectId {

    private BuyerId() {
        super("");
    }

    public BuyerId(@NonNull String id) {
        super(id);
    }
}
