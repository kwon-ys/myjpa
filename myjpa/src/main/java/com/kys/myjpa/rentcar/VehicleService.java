package com.kys.myjpa.rentcar;

import java.util.List;

public interface VehicleService {
    Vehicle findById(Long id);
    List<Vehicle> getAllList();
    Vehicle insert(Vehicle vehicle) throws Exception;
    boolean remove(Long id) throws Exception;
    Vehicle update(Long id, Vehicle vehicle) throws Exception;
    List<Vehicle> getListFromCompany(String company);
    List<Vehicle> getListFromModel(String model);
    List<Vehicle> getListFromMakeYear(int makeYear);
    List<Vehicle> getListFromType(VehicleType type);
    List<Vehicle> getListFromColor(String color);
    List<Vehicle> getListFromTotalKm(int totalKm);
    List<Vehicle> getListFromFactoryNumber(String factoryNumber);
    List<Vehicle> getListFromRegistNumber(String registNumber);
    List<Vehicle> getListFromStatus(VehicleStatus status);
}
