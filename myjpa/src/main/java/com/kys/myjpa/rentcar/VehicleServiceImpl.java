package com.kys.myjpa.rentcar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    private VehicleJpaRepository vehicleJpaRepository;

    @Override
    public Vehicle findById(Long id) {
        if (id == null || id <= 0){
            return null;
        }
        Optional<VehicleEntity> find = this.vehicleJpaRepository.findById(id);
        return find.orElse(null);
    }

    @Override
    public List<Vehicle> getAllList() {
        List<Vehicle> list = this.getVehicleList(
                this.vehicleJpaRepository.findAll()
        );
        return list;
    }

    private List<Vehicle> getVehicleList(List<VehicleEntity> list) {
        if (list == null || list.size() <= 0) {
            return new ArrayList<>();
        }
        List<Vehicle> result = list.stream()
                .map(x -> (Vehicle)x)
                .toList();
        return result;
    }

    @Override
    public Vehicle insert(Vehicle vehicle) throws Exception {
        if (!isValidInsert(vehicle)) {
            return null;
        }
        VehicleEntity entity = new VehicleEntity();
        entity.copyFields(vehicle);
        Vehicle result = this.vehicleJpaRepository.saveAndFlush(entity);
        return result;
    }

    private boolean isValidInsert(Vehicle dto) {
        if (dto == null) {
            return false;
        }
        else if (dto.getCompany() == null || dto.getCompany().isEmpty()){
            return false;
        }
        else if (dto.getModel() == null || dto.getModel().isEmpty()){
            return false;
        }
        else if (dto.getMakeYear() == 0){
             return false;
        }
        else if (dto.getType() == null){
            return false;
        }
        else if (dto.getColor() == null || dto.getColor().isEmpty()){
            return false;
        }
        else if (dto.getTotalKm() == 0){
            return false;
        }
        else if (dto.getFactoryNumber() == null || dto.getFactoryNumber().isEmpty()){
            return false;
        }
        else if (dto.getRegistNumber() == null || dto.getRegistNumber().isEmpty()){
            return false;
        }
        else if (dto.getStatus() == null){
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(Long id) throws Exception {
        Vehicle find = this.findById(id);
        if (find == null) {
            return false;
        }
        this.vehicleJpaRepository.deleteById(id);
        return true;
    }

    @Override
    public Vehicle update(Long id, Vehicle vehicle) {
        Vehicle find = this.findById(id);
        if (find == null) {
            return null;
        }
        find.copyFields(vehicle);

        return this.vehicleJpaRepository.saveAndFlush((VehicleEntity) find);
    }

    @Override
    public List<Vehicle> getListFromCompany(String company) {
        if (company == null || company.isEmpty()) {
            return new ArrayList<>();
        }
        List<Vehicle> list = this.getVehicleList(
                this.vehicleJpaRepository.findAllByCompanyContains(company)
        );
        return list;
    }

    @Override
    public List<Vehicle> getListFromModel(String model) {
        if (model == null || model.isEmpty()) {
            return new ArrayList<>();
        }
        List<Vehicle> list = this.getVehicleList(
                this.vehicleJpaRepository.findAllByModelContains(model)
        );
        return list;
    }

    @Override
    public List<Vehicle> getListFromMakeYear(int makeYear) {
        if (makeYear == 0) {
            return new ArrayList<>();
        }
        List<Vehicle> list = this.getVehicleList(
                this.vehicleJpaRepository.findAllByMakeYear(makeYear)
        );
        return list;
    }

    @Override
    public List<Vehicle> getListFromType(VehicleType type) {
        if (type == null) {
            return new ArrayList<>();
        }
        List<Vehicle> list = this.getVehicleList(
                this.vehicleJpaRepository.findAllByType(type)
        );
        return list;
    }

    @Override
    public List<Vehicle> getListFromColor(String color) {
        if (color == null || color.isEmpty()) {
            return new ArrayList<>();
        }
        List<Vehicle> list = this.getVehicleList(
                this.vehicleJpaRepository.findAllByColorContains(color)
        );
        return list;
    }

    @Override
    public List<Vehicle> getListFromTotalKm(int totalKm) {
        if (totalKm == 0) {
            return new ArrayList<>();
        }
        List<Vehicle> list = this.getVehicleList(
                this.vehicleJpaRepository.findAllByTotalKm(totalKm)
        );
        return list;
    }

    @Override
    public List<Vehicle> getListFromFactoryNumber(String factoryNumber) {
        if (factoryNumber == null || factoryNumber.isEmpty()) {
            return new ArrayList<>();
        }
        List<Vehicle> list = this.getVehicleList(
                this.vehicleJpaRepository.findAllByFactoryNumberContains(factoryNumber)
        );
        return list;
    }

    @Override
    public List<Vehicle> getListFromRegistNumber(String registNumber) {
        if (registNumber == null || registNumber.isEmpty()) {
            return new ArrayList<>();
        }
        List<Vehicle> list = this.getVehicleList(
                this.vehicleJpaRepository.findAllByRegistNumberContains(registNumber)
        );
        return list;
    }

    @Override
    public List<Vehicle> getListFromStatus(VehicleStatus status) {
        if (status == null) {
            return new ArrayList<>();
        }
        List<Vehicle> list = this.getVehicleList(
                this.vehicleJpaRepository.findAllByStatus(status)
        );
        return list;
    }

}
