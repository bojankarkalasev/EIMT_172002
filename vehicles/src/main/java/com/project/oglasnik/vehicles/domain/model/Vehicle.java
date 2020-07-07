package com.project.oglasnik.vehicles.domain.model;

import com.project.oglasnik.sharedkernel.domain.base.AbstractEntity;
import com.project.oglasnik.vehicles.domain.enumeration.Make;
import com.project.oglasnik.vehicles.domain.enumeration.Fuel;
import com.project.oglasnik.vehicles.domain.enumeration.Transmission;
import com.project.oglasnik.vehicles.domain.enumeration.BodyType;
import com.project.oglasnik.vehicles.domain.enumeration.Color;
import com.project.oglasnik.vehicles.domain.enumeration.Damage;
import com.project.oglasnik.sharedkernel.domain.financial.Price;
import com.project.oglasnik.sharedkernel.domain.vehicle.Equipment;
import com.project.oglasnik.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name="vehicle")
public class Vehicle extends AbstractEntity<VehicleId> {

    @Version
    private Long version;

    @Column(name="make", nullable = false)
    @Enumerated(EnumType.STRING)
    private Make make;

    @Column(name="model", nullable = false)
    @Enumerated(EnumType.STRING)
    private String model;

    @Column(name="year", nullable = false)
    private int year;

    @Column(name="fuel", nullable = false)
    @Enumerated(EnumType.STRING)
    private Fuel fuel;

    @Column(name="transmission", nullable = false)
    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    @Column(name="mileage", nullable = false)
    private int mileage;

    @Column(name="power", nullable = false)
    private int power;

    @Column(name="bodyType", nullable = false)
    @Enumerated(EnumType.STRING)
    private BodyType bodyType;

    @Column(name="color", nullable = false)
    @Enumerated(EnumType.STRING)
    private Color color;

    @Column(name="damage", nullable = false)
    @Enumerated(EnumType.STRING)
    private Damage damage;

    @Column(name="equipment")
    private Equipment equipment;

    @Column(name="details")
    private String details;

    @Column(name="price", nullable = false)
    private Price price;

    @Column(name="image")
    private String image;

    @Column(name="datePosted", nullable = false)
    private Instant datePosted;

    @ManyToMany(mappedBy = "vehicles")
    private Set<Buyer> buyers;

    @SuppressWarnings("unused")
    private Vehicle() {
    }

    public Vehicle(@NotNull Make make,
                   @NotNull String model,
                   @NotNull int year,
                   @NotNull Fuel fuel,
                   @NotNull Transmission transmission,
                   @NotNull int mileage,
                   @NotNull int power,
                   @NotNull BodyType bodyType,
                   @NotNull Color color,
                   @NotNull Damage damage,
                   Equipment equipment,
                   String details,
                   String image,
                   @NotNull Price price) {
        super(DomainObjectId.randomId(VehicleId.class));
        setMake(make);
        setModel(model);
        setYear(year);
        setFuel(fuel);
        setTransmission(transmission);
        setMileage(mileage);
        setPower(power);
        setBodyType(bodyType);
        setColor(color);
        setDamage(damage);
        setEquipment(equipment);
        setDetails(details);
        setImage(image);
        setPrice(price);
        setDatePosted(Instant.now());
    }

    public Long getVersion() { return version; }
    public void setVersion(Long version) { this.version = version; }

    public Make getMake() {
        return make;
    };
    public void setMake(Make make) {
        this.make = make;
    };

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public Fuel getFuel() {
        return fuel;
    }
    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public Transmission getTransmission() {
        return transmission;
    }
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }

    public BodyType getBodyType() {
        return bodyType;
    }
    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public Damage getDamage() {
        return damage;
    }
    public void setDamage(Damage damage) {
        this.damage = damage;
    }

    public Equipment getEquipment() { return equipment; }
    public void setEquipment(Equipment equipment) { this.equipment = equipment; }

    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }

    public Price getPrice() { return price; }
    public void setPrice(Price price) { this.price = price; };

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public Instant getDatePosted() {
        return datePosted;
    }
    public void setDatePosted(Instant datePosted) {
        this.datePosted = datePosted;
    }

    public Set<Buyer> getBuyers() {
        return buyers;
    }
    public void setBuyers(Set<Buyer> buyers) {
        this.buyers = buyers;
    }
}