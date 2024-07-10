package com.kys.myjpa.rentcar;

public enum VehicleType {
    Sedan(0),
    SUV(1),
    Small(2),
    Truck(3),
    Sports(4),
    Golf(5),
    Zeep(6),
    MotorCycle(7);

    private final Integer value;

    VehicleType(Integer value) {
        this.value = value;
    }
    public Integer getValue() {
        return this.value;
    }

    public static VehicleType integerOf(Integer value) {
        for (VehicleType item : VehicleType.values()) {
            if (value.equals(item.getValue())) {
                return item;
            }
        }
        throw new IllegalArgumentException("Error !, VehicleType not a value :" + value);
    }
}