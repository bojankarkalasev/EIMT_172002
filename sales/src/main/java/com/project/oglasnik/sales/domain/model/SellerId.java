package com.project.oglasnik.sales.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import com.project.oglasnik.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode
public class SellerId extends DomainObjectId {

    private SellerId() {
        super("");
    }

    public SellerId(@NonNull String id) {
        super(id);
    }
}
