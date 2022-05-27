package com.pereira.kayro.validate.devices.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceWaterTank {
    private Long id;
    private String model;
    private String mac;
    private String name;
    private Boolean status;
}