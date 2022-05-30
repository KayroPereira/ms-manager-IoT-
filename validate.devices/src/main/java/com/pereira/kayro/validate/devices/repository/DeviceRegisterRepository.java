package com.pereira.kayro.validate.devices.repository;

import com.pereira.kayro.validate.devices.entities.DeviceRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRegisterRepository extends JpaRepository<DeviceRegister, Long> {

    DeviceRegister findByModelAndMac(String model, String mac);
}
