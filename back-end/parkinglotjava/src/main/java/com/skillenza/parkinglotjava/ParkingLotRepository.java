package com.skillenza.parkinglotjava;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long>{
    List<ParkingLot> findByLotIsNull();
    List<ParkingLot> getAllAvailableParkingLot();
}
