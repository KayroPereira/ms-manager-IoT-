package com.pereira.kayro.manageriot.repository;

import com.pereira.kayro.manageriot.entities.DeviceWaterTank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceWaterTankRepository extends JpaRepository<DeviceWaterTank, Long> {

    DeviceWaterTank findByModelAndMac(String model, String mac);
}
