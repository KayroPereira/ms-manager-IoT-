package com.pereira.kayro.manageriot.controller;

import com.pereira.kayro.manageriot.entities.DeviceWaterTank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pereira.kayro.manageriot.repository.DeviceWaterTankRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/dv-water-tank")
public class DeviceWaterTankController {

    @Autowired
    private DeviceWaterTankRepository deviceWaterTankRepository;

    @GetMapping
    public ResponseEntity<List<DeviceWaterTank>> findAll(){
        List<DeviceWaterTank> devices = deviceWaterTankRepository.findAll();
        return ResponseEntity.ok(devices);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceWaterTank> findById(@PathVariable Long id){
        DeviceWaterTank device = deviceWaterTankRepository.findById(id).get();
        return  ResponseEntity.ok(device);
    }

    @GetMapping("/device-filter")
    public ResponseEntity<DeviceWaterTank> findByIdAndModelAndMac(@RequestParam String model, @RequestParam String mac){
        System.out.println("mac: " + mac + " model: " + model);
        DeviceWaterTank device = deviceWaterTankRepository.findByModelAndMac(model, mac);
        return ResponseEntity.ok(device);
    }
}