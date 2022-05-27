package com.pereira.kayro.validate.devices.services;

import com.pereira.kayro.validate.devices.entities.DeviceRegister;
import com.pereira.kayro.validate.devices.entities.DeviceWaterTank;
import com.pereira.kayro.validate.devices.feignclients.ManagerIoTFeingClient;
import com.pereira.kayro.validate.devices.repository.DeviceRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeviceRegisterService {

    @Value("${manager-iot.host}")
    String managerIotHost;

    @Autowired
    private DeviceRegisterRepository deviceRegisterRepository;

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private ManagerIoTFeingClient managerIoTFeingClient;

    public DeviceRegister getDevice(Long id){

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", id.toString());

        DeviceWaterTank deviceWaterTank = restTemplate.getForObject(managerIotHost + "/dv-water-tank/{id}", DeviceWaterTank.class, uriVariables);

        DeviceRegister deviceRegister = deviceRegisterRepository.findByModelAndMac(deviceWaterTank.getModel(), deviceWaterTank.getMac());
//        var device = new DeviceWaterTank(1L, "WTV1", "E678B4", "Device_1", true);
//        DeviceRegister device = deviceRegisterRepository.findById(id).get();
//        return new DeviceRegister(1L, "WTV1", "E678B4");


        return deviceRegister;
    }
}
