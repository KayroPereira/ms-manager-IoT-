package com.pereira.kayro.validate.devices.controller;

import com.pereira.kayro.validate.devices.entities.DeviceRegister;
import com.pereira.kayro.validate.devices.repository.DeviceRegisterRepository;
import com.pereira.kayro.validate.devices.services.DeviceRegisterService;
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
    public ResponseEntity<List<DeviceRegister>> findAll(){
        List<DeviceRegister> list = deviceRegisterRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{model}/{mac}")
    public ResponseEntity<DeviceRegister> findByModelAndMac(@PathVariable String model, @PathVariable String mac){
        DeviceRegister device = deviceRegisterRepository.findByModelAndMac(model, mac);
        return ResponseEntity.ok(device);
    }

    @GetMapping("/isvalid/{id}")
    public ResponseEntity<DeviceRegister> isValid(@PathVariable Long id){
        DeviceRegister deviceRegister = deviceRegisterService.getDevice(id);

        return  ResponseEntity.ok(deviceRegister);
    }
}
