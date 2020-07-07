package com.project.oglasnik.vehicles.domain.model;

import com.project.oglasnik.sharedkernel.domain.base.AbstractEntity;
import com.project.oglasnik.sharedkernel.domain.base.DomainObjectId;
import com.project.oglasnik.sharedkernel.domain.people.Occupation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name="buyer")
public class Buyer extends AbstractEntity<BuyerId> {

    @Version
    private Long version;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "companyName", nullable = false)
    private String companyName;

    @Column(name = "occupation", nullable = false)
    @Enumerated(EnumType.STRING)
    private Occupation occupation;

    @Column(name = "taxNumber", nullable = false)
    private String taxNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "joinDate", nullable = false)
    private Instant joinDate;

    @Column(name = "isApproved", nullable = false)
    private boolean isApproved;

    @ManyToMany
    @JoinTable(
            name = "buyer_vehicle",
            joinColumns = @JoinColumn(name = "buyerId"),
            inverseJoinColumns = @JoinColumn(name = "vehicleId"))
    private Set<Vehicle> vehicles; // This is Favourites

    @SuppressWarnings("unused")
    private Buyer() {
    }

    public Buyer(@NotNull String firstName,
                 @NotNull String lastName,
                 @NotNull String companyName,
                 @NotNull Occupation occupation,
                 @NotNull String taxNumber,
                 @NotNull String email,
                 @NotNull String password) {
        super(DomainObjectId.randomId(BuyerId.class));
        setApproved(false);
        setFirstName(firstName);
        setLastName(lastName);
        setCompanyName(companyName);
        setOccupation(occupation);
        setTaxNumber(taxNumber);
        setEmail(email);
        setPassword(password);
        setJoinDate(Instant.now());
    }

    public void ApproveBuyer() {
        setApproved(true);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instant getJoinDate() { return joinDate; }
    public void setJoinDate(Instant joinDate) { this.joinDate = joinDate; }

    public boolean getApproved() {
        return isApproved;
    }

    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}