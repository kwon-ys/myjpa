package com.kys.myjpa.rentcar;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleJpaRepository extends JpaRepository<VehicleEntity, Long> {
    List<VehicleEntity> findAllByCompanyContains(String company);
    List<VehicleEntity> findAllByModelContains(String model);
    List<VehicleEntity> findAllByMakeYear(int makeYear);
    List<VehicleEntity> findAllByType(VehicleType type);
    List<VehicleEntity> findAllByColorContains(String color);
    List<VehicleEntity> findAllByTotalKm(int totalKm);
    List<VehicleEntity> findAllByFactoryNumberContains(String factoryNumber);
    List<VehicleEntity> findAllByRegistNumberContains(String registNumber);
    List<VehicleEntity> findAllByStatus(VehicleStatus status);
}
