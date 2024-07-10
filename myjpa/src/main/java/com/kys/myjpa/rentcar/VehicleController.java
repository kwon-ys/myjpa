package com.kys.myjpa.rentcar;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vc")
public class VehicleController {
    private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<Vehicle> insert(@RequestBody VehicleDto dto) {
        try {
            if (dto == null) {
                return ResponseEntity.badRequest().build();
            }
            Vehicle result = this.vehicleService.insert(dto);
            if (result == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAll(){
        try {
            List<Vehicle> result = this.vehicleService.getAllList();
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        try {
            if (id == null) {
                return ResponseEntity.badRequest().build();
            }
            Boolean result = this.vehicleService.remove(id);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Vehicle> update(@PathVariable Long id, @RequestBody VehicleDto dto) {
        try {
            if (id == null || dto == null) {
                return ResponseEntity.badRequest().build();
            }
            Vehicle result = this.vehicleService.update(id, dto);
            if (result == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> findById(@PathVariable Long id) {
        try {
            if (id == null || id <= 0) {
                return ResponseEntity.badRequest().build();
            }
            Vehicle result = this.vehicleService.findById(id);
            if (result == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/cp/{company}")
    public ResponseEntity<List<Vehicle>> findAllByNameContains(@PathVariable String company) {
        try {
            if (company == null || company.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            List<Vehicle> result = this.vehicleService.getListFromCompany(company);
            if (result == null || result.size() <=0) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/md/{model}")
    public ResponseEntity<List<Vehicle>> findAllByModelContains(@PathVariable String model) {
        try {
            if (model == null || model.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            List<Vehicle> result = this.vehicleService.getListFromModel(model);
            if (result == null || result.size() <=0) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/my/{makeYear}")
    public ResponseEntity<List<Vehicle>> findAllByMakeYearContains(@PathVariable Integer makeYear) {
        try {
            if (makeYear == null) {
                return ResponseEntity.badRequest().build();
            }
            List<Vehicle> result = this.vehicleService.getListFromMakeYear(makeYear);
            if (result == null || result.size() <=0) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/ty/{type}")
    public ResponseEntity<List<Vehicle>> findAllByTypeContains(@PathVariable VehicleType type) {
        try {
            if (type == null) {
                return ResponseEntity.badRequest().build();
            }
            List<Vehicle> result = this.vehicleService.getListFromType(type);
            if (result == null || result.size() <=0) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/co/{color}")
    public ResponseEntity<List<Vehicle>> findAllByColorContains(@PathVariable String color) {
        try {
            if (color == null || color.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            List<Vehicle> result = this.vehicleService.getListFromColor(color);
            if (result == null || result.size() <=0) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/tk/{totalKm}")
    public ResponseEntity<List<Vehicle>> findAllByTotalKmContains(@PathVariable Integer totalKm) {
        try {
            if (totalKm == null) {
                return ResponseEntity.badRequest().build();
            }
            List<Vehicle> result = this.vehicleService.getListFromTotalKm(totalKm);
            if (result == null || result.size() <=0) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/fn/{factoryNumber}")
    public ResponseEntity<List<Vehicle>> findAllByFactoryNumberContains(@PathVariable String factoryNumber) {
        try {
            if (factoryNumber == null || factoryNumber.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            List<Vehicle> result = this.vehicleService.getListFromFactoryNumber(factoryNumber);
            if (result == null || result.size() <=0) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/rn/{registNumber}")
    public ResponseEntity<List<Vehicle>> findAllByRegistNumberContains(@PathVariable String registNumber) {
        try {
            if (registNumber == null || registNumber.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            List<Vehicle> result = this.vehicleService.getListFromRegistNumber(registNumber);
            if (result == null || result.size() <=0) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/st/{status}")
    public ResponseEntity<List<Vehicle>> findAllByStatusContains(@PathVariable VehicleStatus status) {
        try {
            if (status == null) {
                return ResponseEntity.badRequest().build();
            }
            List<Vehicle> result = this.vehicleService.getListFromStatus(status);
            if (result == null || result.size() <=0) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }
}
