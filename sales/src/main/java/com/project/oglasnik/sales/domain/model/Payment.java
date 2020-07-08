package com.project.oglasnik.sales.domain.model;

import com.project.oglasnik.sharedkernel.domain.base.AbstractEntity;
import com.project.oglasnik.sharedkernel.domain.base.DomainObjectId;
import com.project.oglasnik.sharedkernel.domain.financial.Price;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name="payment")
public class Payment extends AbstractEntity<PaymentId> {

    @Version
    private Long version;

    @Column(name="price", nullable = false)
    private Price price;

    @Column(name = "date")
    private Instant date;

    @ManyToOne
    @JoinColumn(name="companyId", nullable = false)
    private Company company;

    @SuppressWarnings("unused")
    private Payment() {
    }

    public Payment(@NotNull Price price,
                   @NotNull Company company) {
        super(DomainObjectId.randomId(PaymentId.class));
        setDate(Instant.now());
        setPrice(price);
        setCompany(company);
    }

    private Price getPrice() {
        return price;
    }
    private void setPrice(Price price) {
        this.price = price;
    }

    private Instant getDate() {
        return date;
    }
    private void setDate(Instant date) {
        this.date = date;
    }

    public Company getCompany() { return company; }
    public void setCompany(Company company) { this.company = company; }
}
