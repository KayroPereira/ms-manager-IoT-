package com.pereira.kayro.validate.devices.controller;

import com.pereira.kayro.validate.devices.entities.DeviceRegister;
import com.pereira.kayro.validate.devices.repository.DeviceRegisterRepository;
import com.pereira.kayro.validate.devices.services.DeviceRegisterService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("device-register")
public class DeviceRegisterController{

    @Autowired
    private DeviceRegisterRepository deviceRegisterRepository;
    @Autowired
    private DeviceRegisterService deviceRegisterService;

    @GetMapping
    @ApiOperation(value = "", notes = "Returns the list of all devices")
    public ResponseEntity<List<DeviceRegister>> findAll(){
        List<DeviceRegister> list = deviceRegisterRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{model}/{mac}")
    @ApiOperation(value = "", notes = "Returns device by match of model and MAC")
    public ResponseEntity<DeviceRegister> findByModelAndMac(@PathVariable String model, @PathVariable String mac){
        DeviceRegister device = deviceRegisterRepository.findByModelAndMac(model, mac);
        return ResponseEntity.ok(device);
    }

    @GetMapping("/isvalid/{id}")
    @ApiOperation(value = "",
            notes = "Receives an id number registered in the \"manager-iot\" service then performs a query in this service " +
                    "to obtain all the device data. Afterwards, a query is performed in the local database with the data obtained in the " +
                    "previous query. If the device exists in the database, return true, otherwise, return false.")
    public ResponseEntity<DeviceRegister> isValid(@PathVariable Long id){
        DeviceRegister deviceRegister = deviceRegisterService.getDevice(id);

        return  ResponseEntity.ok(deviceRegister);
    }
}