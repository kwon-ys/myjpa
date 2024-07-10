package com.kys.myjpa.rentcar;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="vehicletype_tbl")
public class VehicleEntity implements Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 20)
    private String company;

    @NotNull
    @Column(length = 20)
    private String model;

    @NotNull
    @Column(length = 20)
    private int makeYear;

    @NotNull
    @Column(length = 20)
    private VehicleType type;

    @NotNull
    @Column(length = 20)
    private String color;

    @NotNull
    @Column(length = 20)
    private int totalKm;

    @NotNull
    @Column(length = 20)
    private String factoryNumber;

    @NotNull
    @Column(length = 20)
    private String registNumber;

    @NotNull
    @Column(length = 20)
    private VehicleStatus status;
}