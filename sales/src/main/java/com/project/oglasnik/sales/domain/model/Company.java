package com.project.oglasnik.sales.domain.model;

import com.project.oglasnik.sharedkernel.domain.base.AbstractEntity;
import com.project.oglasnik.sharedkernel.domain.base.DomainObjectId;
import com.project.oglasnik.sharedkernel.domain.people.Occupation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name="company")
public class Company extends AbstractEntity<CompanyId> {

    @Version
    private long version;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "occupation", nullable = false)
    @Enumerated(EnumType.STRING)
    private Occupation occupation;

    @Column(name = "taxNumber", nullable = false)
    private String taxNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "isApproved", nullable = false)
    private boolean isApproved;

    @Column(name = "joinDate", nullable = false)
    private Instant joinDate;

    @OneToMany(mappedBy="company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Seller> sellers;

    @OneToMany(mappedBy="company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Payment> payments;

    @SuppressWarnings("unused")
    private Company() {
    }

    public Company(@NotNull String name,
                   @NotNull Occupation occupation,
                   @NotNull String taxNumber,
                   @NotNull String address,
                   @NotNull String email,
                   Seller seller) {
        super(DomainObjectId.randomId(CompanyId.class));
        setApproved(false);
        sellers.add(seller);
        seller.setCompany(this);
        setName(name);
        setOccupation(occupation);
        setTaxNumber(taxNumber);
        setAddress(address);
        setEmail(email);
        setJoinDate(Instant.now());
    }

    public void ApproveCompany() {
        setApproved(true);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getJoinDate() { return joinDate; }

    public void setJoinDate(Instant joinDate) { this.joinDate = joinDate; }

    public boolean getApproved() {
        return isApproved;
    }

    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Set<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(Set<Seller> sellers) {
        this.sellers = sellers;
    }

    public Set<Payment> getPayments() { return payments; }

    public void setPayments(Set<Payment> payments) { this.payments = payments; }
}