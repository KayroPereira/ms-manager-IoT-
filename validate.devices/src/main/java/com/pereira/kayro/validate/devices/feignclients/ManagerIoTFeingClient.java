package com.pereira.kayro.validate.devices.feignclients;

import com.pereira.kayro.validate.devices.entities.DeviceWaterTank;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "manager-iot", url = "localhost:8001", path = "/dv-water-tank")
public interface ManagerIoTFeingClient {

    @GetMapping("/device-filter")
    ResponseEntity<DeviceWaterTank> findByIdAndModelAndMac(@RequestParam String model, @RequestParam String mac);

}
