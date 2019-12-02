package com.skillenza.parkinglotjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class ParkingLotController {

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @GetMapping("/parkings")
    public List<ParkingLot> getAllParkings() {
        return parkingLotRepository.findByLotIsNull();

    }

    @PostMapping("/parkings")
    public ParkingLot assignParkingLot(@RequestBody ParkingLot lot) {
        long duration=lot.getUpdated_at().getTime() - lot.getCreated_at().getTime();
        // long minutes = (milliseconds / 1000) / 60;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        // long seconds = (milliseconds / 1000);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(duration);

        int hours = Math.toIntExact(minutes) / 60;
        long totalAmount=0;
        if(hours==1){
            totalAmount=20;
        }else if (hours>1){
            int remainingTotalminutes =  Math.toIntExact(minutes)-60;
            long partialamount = Math.round(remainingTotalminutes*0.333);
            totalAmount=20+partialamount;
        }
        lot.setParking_amount(Math.toIntExact(totalAmount));
        lot.setParking_duration(Math.round(duration));
        ParkingLot parkingLot = parkingLotRepository.save(lot);
        return parkingLot;
    }

}

