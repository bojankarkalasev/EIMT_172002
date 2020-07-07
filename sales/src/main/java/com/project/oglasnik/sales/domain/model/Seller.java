package com.project.oglasnik.sales.domain.model;

import com.project.oglasnik.sharedkernel.domain.base.AbstractEntity;
import com.project.oglasnik.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@Table(name="seller")
public class Seller extends AbstractEntity<SellerId> {

    @Version
    private Long version;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @ManyToOne
    @JoinColumn(name="companyId")
    private Company company;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "dateAdded", nullable = false)
    private Instant dateAdded;

    @SuppressWarnings({"unused"})
    private Seller() {
    }

    public Seller(@NotNull String firstName,
                   @NotNull String lastName,
                   @NotNull String email,
                   @NotNull String password) {
        super(DomainObjectId.randomId(SellerId.class));
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
    }

    public Seller(@NotNull String firstName,
                  @NotNull String lastName,
                  @NotNull String email,
                  @NotNull String password,
                  @NotNull Company company) {
        super(DomainObjectId.randomId(SellerId.class));
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setCompany(company);
        setDateAdded(Instant.now());
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    public Instant getDateAdded() { return dateAdded; }

    public void setDateAdded(Instant dateAdded) { this.dateAdded = dateAdded; }
}