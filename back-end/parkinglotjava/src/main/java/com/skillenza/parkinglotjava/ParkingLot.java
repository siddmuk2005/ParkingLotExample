package com.skillenza.parkinglotjava;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GeneratorType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "parkinglots")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)


public class ParkingLot {
    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int getLot() {
        return lot;
    }

    public void setLot(int lot) {
        this.lot = lot;
    }

    public int getParking_amount() {
        return parking_amount;
    }

    public void setParking_amount(int parking_amount) {
        this.parking_amount = parking_amount;
    }

    public int getParking_duration() {
        return parking_duration;
    }

    public void setParking_duration(int parking_duration) {
        this.parking_duration = parking_duration;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(int vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

    @NotNull
    @NotBlank
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, columnDefinition="decimal(20) default 'NULL'")
    double id;

    @NotNull
    @NotBlank
    @Column(name = "created_at",unique = true, nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    Date created_at;

    @NotNull
    @NotBlank
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "lot",unique = true, nullable = false, columnDefinition="int(11) default 'NULL'")
    int lot;

    @NotNull
    @NotBlank
    int parking_amount;

    @NotNull
    @NotBlank
    int parking_duration;

    @NotNull
    @NotBlank
    Date updated_at;

    @NotNull
    @NotBlank
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int vehicle_number;


    
}
